package com.content.service;

import common.util.EasyUITreeNode;
import common.util.JsonResult;

import java.util.List;

/**
 * Created by zj on 2017/7/3.
 */
public interface ContentCatService {
    List<EasyUITreeNode> getContentCats(long parentId);

    JsonResult addContentCategory(long parentId, String name);

}
