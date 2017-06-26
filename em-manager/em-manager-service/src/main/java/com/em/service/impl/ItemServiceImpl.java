package com.em.service.impl;

import com.em.mapper.TbItemMapper;
import com.em.pojo.TbItem;
import com.em.pojo.TbItemExample;
import com.em.pojo.TbItemExample.Criteria;
import com.em.service.ItemService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import common.EasyUIDdataGridResult;
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

    @Override
    public EasyUIDdataGridResult getItemList(int page, int rows) {
        TbItemExample itemExample = new TbItemExample();
        //设置分页信息
        PageHelper.startPage(page, rows);

        //查询
        List<TbItem> list = itemMapper.selectByExample(itemExample);
        PageInfo<TbItem> pageInfo = new PageInfo<>(list);
        long total = pageInfo.getTotal();

        //获取结果
        EasyUIDdataGridResult result = new EasyUIDdataGridResult();
        result.setRows(list);
        result.setTota(total);

        return result;
    }
}
