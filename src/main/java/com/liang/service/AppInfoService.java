package com.liang.service;

import com.github.pagehelper.PageInfo;
import com.liang.pojo.AppCategory;
import com.liang.pojo.AppInfo;
import com.liang.pojo.DataDictionary;

import java.util.List;

public interface AppInfoService {
    PageInfo<AppInfo> queryByDevUserId(long id,PageInfo pageInfo);

    List<DataDictionary> queryAllAppPublishStatus();

    List<DataDictionary> queryAllAppFlatform();

    List<AppCategory> queryAllAppCategoriesLevelOne();

    List<AppCategory> queryAllAppCategoriesLevelTwo();

    List<AppCategory> queryAllAppCategoriesLevelThree();
}
