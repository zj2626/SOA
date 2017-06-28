package com.em.service;

import common.EasyUITreeNode;

import java.util.List;

/**
 * Created by zj on 2017/6/27.
 */
public interface ItemCatService {
    List<EasyUITreeNode> getItemCatList(long parentId);
}
