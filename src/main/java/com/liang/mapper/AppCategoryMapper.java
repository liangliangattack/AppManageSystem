package com.liang.mapper;

import com.liang.pojo.AppCategory;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AppCategoryMapper {

    List<AppCategory> queryAllAppCategoriesLevelOne();

    List<AppCategory> queryLevelByParentId(@Param("parentId") int parentId);
}