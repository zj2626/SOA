package com.content.service.impl;

import com.content.service.ContentCatService;
import com.em.mapper.TbContentCategoryMapper;
import com.em.pojo.TbContentCategory;
import com.em.pojo.TbContentCategoryExample;
import common.EasyUITreeNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zj on 2017/7/3.
 */
@Service
public class ContentCatServiceImpl implements ContentCatService {
    @Autowired
    private TbContentCategoryMapper mapper;

    @Override
    public List<EasyUITreeNode> getContentCats(long parentId) {
        //根据parentId查询子节点
        TbContentCategoryExample example = new TbContentCategoryExample();
        TbContentCategoryExample.Criteria criteria = example.createCriteria();
        //设置查询条件
        criteria.andParentIdEqualTo(parentId);

        //查询
        List<TbContentCategory> tbContentCategories = mapper.selectByExample(example);

        List<EasyUITreeNode> nodes = new ArrayList<>();
        for (TbContentCategory tbContentCategory : tbContentCategories){
            EasyUITreeNode node = new EasyUITreeNode();
            node.setId(tbContentCategory.getId());
            node.setText(tbContentCategory.getName());
            node.setState(tbContentCategory.getIsParent() ? "closed" : "open");
            nodes.add(node);
        }

        return nodes;
    }
}
