package com.content.service;

import common.EasyUITreeNode;

import java.util.List;

/**
 * Created by zj on 2017/7/3.
 */
public interface ContentCatService {
    List<EasyUITreeNode> getContentCats(long parentId);
}