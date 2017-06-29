package com.em.service;

import com.em.pojo.TbItem;
import common.EasyUIDdataGridResult;
import common.JsonResult;

/**
 * Created by zj on 2017/5/22.
 */
public interface ItemService {
    TbItem getItemById(long itemId);

    EasyUIDdataGridResult getItemList(int page, int rows);

    JsonResult addItem(TbItem item, String desc);
}
