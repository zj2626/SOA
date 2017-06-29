package com.em.controller;

import com.em.pojo.TbItem;
import com.em.service.ItemService;
import common.EasyUIDdataGridResult;
import common.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by zj on 2017/5/22.
 */
@Controller
//@RequestMapping("ItemController")
public class ItemController {

    private final ItemService itemService;

    @Autowired
    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @ResponseBody
    @RequestMapping("/item/{itemId}")
    public TbItem getItemById(@PathVariable Long itemId) {
        return itemService.getItemById(itemId);
    }

    @ResponseBody
    @RequestMapping("/item/list")
    public EasyUIDdataGridResult getItemList(Integer page, Integer rows) {
        EasyUIDdataGridResult result = itemService.getItemList(page, rows);
        System.out.println(result);
        return result;
    }

    @ResponseBody
    @RequestMapping(value = "/item/save", method = RequestMethod.POST)
    public JsonResult saveItemBy(TbItem item, String desc) {
        return itemService.addItem(item, desc);
    }
}
