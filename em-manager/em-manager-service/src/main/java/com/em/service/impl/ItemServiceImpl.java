package com.em.service.impl;

import com.em.mapper.TbItemMapper;
import com.em.pojo.TbItem;
import com.em.pojo.TbItemExample;
import com.em.pojo.TbItemExample.Criteria;
import com.em.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zj on 2017/5/22.
 */
@Service
public class ItemServiceImpl implements ItemService {
    private TbItemMapper itemMapper;

    @Autowired
    public ItemServiceImpl(TbItemMapper itemMapper) {
        this.itemMapper = itemMapper;
    }

    @Override
    public TbItem getItemById(long itemId) {
        //根据主键查询
        //TbItem tbItem = itemMapper.selectByPrimaryKey(itemId);
        TbItemExample example = new TbItemExample();
        Criteria criteria = example.createCriteria();
        //设置查询条件
        criteria.andIdEqualTo(itemId);
        //执行查询
        List<TbItem> list = itemMapper.selectByExample(example);
        if (list != null && list.size() > 0) {
            return list.get(0);
        }
        return null;
    }
}
