package com.em.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by zj on 2017/6/14.
 */
@Controller
public class PageController {

    @RequestMapping("/")
    public String showIndex() {
        return "index";
    }

    @RequestMapping("/{page}")
    public String itemAdd(@PathVariable String page) {
        return page;
    }

    /*
    @RequestMapping("/item-add")
    public String itemAdd() {
        return "item-add";
    }

    @RequestMapping("/item-list")
    public String itemList() {
        return "item-list";
    }

    @RequestMapping("/item-param-list")
    public String itemParamList() {
        return "item-param-list";
    }

    @RequestMapping("/content-category")
    public String contentCategory() {
        return "content-category";
    }

    @RequestMapping("/content")
    public String content() {
        return "content";
    }

    @RequestMapping("/index-item")
    public String indexItem() {
        return "index-item";
    }
    */
}
