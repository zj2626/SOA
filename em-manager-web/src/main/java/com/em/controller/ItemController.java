package com.em.controller;

import com.em.pojo.TbItem;
import com.em.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by zj on 2017/5/22.
 */
@Controller
@RequestMapping("ItemController")
public class ItemController {

    private final ItemService itemService;

    @Autowired
    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @ResponseBody
    @RequestMapping("/item/{itemId}")
    public TbItem getItemById(@PathVariable Long itemId) {
        System.out.println("AAAA");
        return itemService.getItemById(itemId);
    }
}
