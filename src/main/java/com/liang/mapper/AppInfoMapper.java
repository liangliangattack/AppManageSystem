package com.liang.mapper;

import com.liang.pojo.AppInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AppInfoMapper {

    List<AppInfo> queryByDevUserId(@Param("devUserId") long id);
}