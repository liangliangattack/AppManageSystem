package com.liang.service;

import com.github.pagehelper.PageInfo;
import com.liang.dto.AppInfoDto;
import com.liang.pojo.AppCategory;
import com.liang.pojo.AppInfo;
import com.liang.pojo.DataDictionary;

import java.util.List;

public interface AppInfoService {
    PageInfo<AppInfo> queryByDevUserId(long id,PageInfo pageInfo);

    List<DataDictionary> queryAllAppStatus();

    List<DataDictionary> queryAllAppFlatform();

    List<AppCategory> queryAllAppCategoriesLevelOne();

    PageInfo<AppInfoDto> query(AppInfoDto appInfoDto);

    boolean addApp(AppInfo appInfo, long userId);

    boolean deleteApp(long appId);

    AppInfo queryAppById(Long appId);

    void updateAppById(AppInfo appInfo);

    AppInfo detailApp(Long appId);
}
