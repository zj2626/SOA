package com.em.controller;

import com.em.service.ItemCatService;
import common.EasyUIDdataGridResult;
import common.EasyUITreeNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by zj on 2017/6/27.
 */
@Controller
public class ItemCatController {

    private final ItemCatService itemCatService;

    @Autowired
    public ItemCatController(ItemCatService itemCatService) {
        this.itemCatService = itemCatService;
    }

    @ResponseBody
    @RequestMapping("/item/cat/list")
    public List<EasyUITreeNode> getCatList(@RequestParam(name = "id", defaultValue = "0") Long id) {
        return itemCatService.getItemCatList(id);
    }
}
