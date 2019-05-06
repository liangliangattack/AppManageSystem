package com.liang.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.liang.constant.CommonCodeConstant;
import com.liang.dto.AppInfoDto;
import com.liang.mapper.AppCategoryMapper;
import com.liang.mapper.AppInfoMapper;
import com.liang.mapper.DataDictionaryMapper;
import com.liang.pojo.AppCategory;
import com.liang.pojo.AppInfo;
import com.liang.pojo.DataDictionary;
import com.liang.service.AppInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("appInfoService")
public class AppInfoServiceImpl implements AppInfoService {

    @Autowired
    private AppInfoMapper appInfoMapper;

    @Autowired
    private DataDictionaryMapper dataDictionaryMapper;

    @Autowired
    private AppCategoryMapper appCategoryMapper;

    @Override
    public PageInfo<AppInfo> queryByDevUserId(long id,PageInfo pageInfo) {

        PageHelper.startPage(pageInfo.getPageNum(),pageInfo.getPageSize());
        List<AppInfo> appInfos = appInfoMapper.queryByDevUserId(id);
        PageInfo<AppInfo> page = new PageInfo<>(appInfos);

        return page;
    }

    @Override
    public List<DataDictionary> queryAllAppStatus() {

        return dataDictionaryMapper.queryAllAppStatus();
    }

    @Override
    public List<DataDictionary> queryAllAppFlatform() {


        return dataDictionaryMapper.queryAllAppFlatform();
    }

    @Override
    public List<AppCategory> queryAllAppCategoriesLevelOne() {

        return appCategoryMapper.queryAllAppCategoriesLevelOne();
    }

    @Override
    public PageInfo<AppInfoDto> query(AppInfoDto appInfoDto) {
        PageHelper.startPage(appInfoDto.getPageNum() , CommonCodeConstant.PAGE_SIZE);

        List<AppInfoDto> appInfoDtos = appInfoMapper.query(appInfoDto);
        PageInfo<AppInfoDto> pageInfo = new PageInfo<>(appInfoDtos);

        return pageInfo;
    }
}
