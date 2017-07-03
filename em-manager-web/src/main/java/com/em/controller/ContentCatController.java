package com.em.controller;

import com.content.service.ContentCatService;
import common.EasyUITreeNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by zj on 2017/7/3.
 */
@Controller
public class ContentCatController {
    @Autowired
    private ContentCatService service;

    @RequestMapping("/content/category/list")
    @ResponseBody
    public List<EasyUITreeNode> category(@RequestParam(name = "id", defaultValue = "0") Long parentId) {
        return service.getContentCats(parentId);
    }
}
