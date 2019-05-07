package com.liang.mapper;

import com.liang.dto.AppInfoDto;
import com.liang.pojo.AppInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AppInfoMapper {

    List<AppInfo> queryByDevUserId(@Param("devUserId") long id);

    List<AppInfoDto> query(AppInfoDto appInfoDto);

    void addApp(AppInfo appInfo);

    int deleteApp(long appId);

    AppInfo queryAppById(Long appId);

    void updateAppById(AppInfo appInfo);

    AppInfo queryAppDetailById(Long appId);
}