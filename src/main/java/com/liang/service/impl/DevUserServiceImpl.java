package com.liang.service.impl;

import com.liang.mapper.DevUserMapper;
import com.liang.pojo.DevUser;
import com.liang.service.DevUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("devUserService")
public class DevUserServiceImpl implements DevUserService {

    @Autowired
    DevUserMapper devUserMapper;

    @Override
    public DevUser login(DevUser devUser) {
        List<DevUser> users = devUserMapper.queryByNamePwd(devUser);
        if(users != null && users.size() == 1){
            return users.get(0);
        }
        return null;
    }
}
