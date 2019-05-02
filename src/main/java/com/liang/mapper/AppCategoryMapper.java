package com.liang.mapper;

import com.liang.pojo.AppCategory;

import java.util.List;

public interface AppCategoryMapper {

    List<AppCategory> queryAllAppCategoriesLevelOne();

    List<AppCategory> queryAllAppCategoriesLevelTwo();

    List<AppCategory> queryAllAppCategoriesLevelThree();
}