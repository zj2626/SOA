package com.em.service.impl;

import com.em.mapper.TbItemCatMapper;
import com.em.pojo.TbItemCat;
import com.em.pojo.TbItemCatExample;
import com.em.service.ItemCatService;
import common.EasyUITreeNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zj on 2017/6/27.
 */
@Service
public class ItemCatServiceImpl implements ItemCatService {
    private final TbItemCatMapper itemCatMapper;

    @Autowired
    public ItemCatServiceImpl(TbItemCatMapper itemCatMapper) {
        this.itemCatMapper = itemCatMapper;
    }

    @Override
    public List<EasyUITreeNode> getItemCatList(long parentId) {
        //根据parentId查询子节点列表
        TbItemCatExample example = new TbItemCatExample();
        TbItemCatExample.Criteria criteria = example.createCriteria();
        //设置查询条件
        criteria.andParentIdEqualTo(parentId);
        //执行查询
        List<TbItemCat> list = itemCatMapper.selectByExample(example);

        //新建结果list
        List<EasyUITreeNode> result = new ArrayList<>();
        //把列表转换成EasyUITreeNode列表
        for (TbItemCat itemCat : list) {
            EasyUITreeNode node = new EasyUITreeNode();
            //设置属性
            node.setId(itemCat.getId());
            node.setText(itemCat.getName());
            node.setState(itemCat.getIsParent() ? "closed" : "open"); //closed表示有子节点 open表示没有子节点
            result.add(node);
        }

        return result;
    }
}
