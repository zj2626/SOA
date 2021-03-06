package com.em.controller;

import com.content.service.ContentCatService;
import com.em.pojo.TbContent;
import common.util.EasyUIDdataGridResult;
import common.util.EasyUITreeNode;
import common.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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

    @RequestMapping(value = "/content/category/create", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult createCategory(Long parentId, String name) {
        return service.addContentCategory(parentId, name);
    }

    @RequestMapping("/content/query/list")
    @ResponseBody
    public EasyUIDdataGridResult queryList(Long categoryId, Integer page, Integer rows) {
        return service.getContentCategoryList(categoryId, page, rows);
    }

    @RequestMapping("/content/demo")
    @ResponseBody
    public List<TbContent> queryListDemo() {
        return service.demo(89L, 1, 20);
    }
}
