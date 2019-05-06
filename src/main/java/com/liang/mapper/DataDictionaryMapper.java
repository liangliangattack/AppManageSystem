package com.liang.mapper;

import com.liang.pojo.DataDictionary;

import java.util.List;

public interface DataDictionaryMapper {

    List<DataDictionary> queryAllAppStatus();

    List<DataDictionary> queryAllAppFlatform();
}