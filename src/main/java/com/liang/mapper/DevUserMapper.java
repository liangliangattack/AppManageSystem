package com.liang.mapper;

import com.liang.pojo.DevUser;

import java.util.List;

public interface DevUserMapper {

    List<DevUser> queryByNamePwd(DevUser devUser);
}