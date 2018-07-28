package com.content.service;

import com.em.pojo.TbContent;
import common.util.EasyUIDdataGridResult;
import common.util.EasyUITreeNode;
import common.util.JsonResult;

import java.util.List;

/**
 * Created by zj on 2017/7/3.
 */
public interface ContentCatService {
    List<EasyUITreeNode> getContentCats(long parentId);

    JsonResult addContentCategory(long parentId, String name);

    EasyUIDdataGridResult getContentCategoryList(Long categoryId, int page, int rows);

    List<TbContent> demo(Long categoryId, int page, int rows);
}
