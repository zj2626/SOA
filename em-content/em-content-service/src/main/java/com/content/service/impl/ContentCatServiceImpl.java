package com.content.service.impl;

import com.content.service.ContentCatService;
import com.em.mapper.TbContentCategoryMapper;
import com.em.mapper.TbContentMapper;
import com.em.pojo.TbContent;
import com.em.pojo.TbContentCategory;
import com.em.pojo.TbContentCategoryExample;
import com.em.pojo.TbContentExample;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import common.jedis.JedisClient;
import common.util.EasyUIDdataGridResult;
import common.util.EasyUITreeNode;
import common.util.JsonResult;
import common.util.JsonUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by zj on 2017/7/3.
 */
@Service
public class ContentCatServiceImpl implements ContentCatService {
    @Autowired
    private TbContentCategoryMapper mapper;
    @Autowired
    private TbContentMapper contentMapper;

    @Autowired
    private JedisClient jedisClient;

    @Value("${CONTENT_LIST}")
    private String CONTENT_LIST;

    @Override
    public List<EasyUITreeNode> getContentCats(long parentId) {
        //先查询缓存 再查询数据库
        try {
            String json = jedisClient.hget(CONTENT_LIST, parentId + "");
            if (StringUtils.isNotBlank(json)) {
                List<TbContentCategory> list = JsonUtils.jsonToList(json, TbContentCategory.class);

                List<EasyUITreeNode> nodes = makeResult(list);

                return nodes;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        //根据parentId查询子节点
        TbContentCategoryExample example = new TbContentCategoryExample();
        TbContentCategoryExample.Criteria criteria = example.createCriteria();
        //设置查询条件
        criteria.andParentIdEqualTo(parentId);

        //查询
        List<TbContentCategory> tbContentCategories = mapper.selectByExample(example);

        List<EasyUITreeNode> nodes = makeResult(tbContentCategories);

        //把查询的数据存放到缓存
        try {
            jedisClient.hset(CONTENT_LIST, parentId + "", JsonUtils.objectToJson(nodes));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return nodes;
    }

    private List<EasyUITreeNode> makeResult(List<TbContentCategory> tbContentCategories) {
        List<EasyUITreeNode> nodes = new ArrayList<>();
        for (TbContentCategory tbContentCategory : tbContentCategories) {
            EasyUITreeNode node = new EasyUITreeNode();
            node.setId(tbContentCategory.getId());
            node.setText(tbContentCategory.getName());
            node.setState(tbContentCategory.getIsParent() ? "closed" : "open");
            nodes.add(node);
        }

        return nodes;
    }

    @Override
    public JsonResult addContentCategory(long parentId, String name) {
        TbContentCategory contentCategory = new TbContentCategory();
        contentCategory.setName(name);
        contentCategory.setIsParent(false);
        contentCategory.setParentId(parentId);
        contentCategory.setStatus(1); //1正常 2删除
        contentCategory.setSortOrder(1);
        contentCategory.setCreated(new Date());
        contentCategory.setUpdated(new Date());
        mapper.insert(contentCategory);

        //更新缓存(删除对应缓存的数据)
        jedisClient.hdel(CONTENT_LIST, contentCategory.getId().toString());

        //查询父节点的id,修改父节点属性
        TbContentCategory father = mapper.selectByPrimaryKey(parentId);
        if (!father.getIsParent()) {
            father.setIsParent(true);
            mapper.updateByPrimaryKey(father);
        }

        return JsonResult.ok(contentCategory);
    }

    @Override
    public EasyUIDdataGridResult getContentCategoryList(Long categoryId, int page, int rows) {
        TbContentExample example = new TbContentExample();
        TbContentExample.Criteria criteria = example.createCriteria();
        criteria.andCategoryIdEqualTo(categoryId);
        //设置分页信息
        PageHelper.startPage(page, rows);

        //查询
        List<TbContent> list = contentMapper.selectByExample(example);
        PageInfo<TbContent> pageInfo = new PageInfo<>(list);
        long total = pageInfo.getTotal();

        //获取结果
        EasyUIDdataGridResult result = new EasyUIDdataGridResult();
        result.setRows(list);
        result.setTotal(total);

        return result;
    }

    @Override
    public List<TbContent> demo(Long categoryId, int page, int rows) {
        List<TbContent> list = null;
        //方法一
//        List<TbContent> list = contentMapper.demo(categoryId);

        //方法二
//        Map<String, Object> map = new HashMap<>();
//        map.put("cId", categoryId);
//        list = contentMapper.demo2(map);

        return list;
    }
}
