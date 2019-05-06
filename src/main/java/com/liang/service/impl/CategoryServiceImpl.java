package com.liang.service.impl;

import com.liang.mapper.AppCategoryMapper;
import com.liang.pojo.AppCategory;
import com.liang.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("categoryService")
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private AppCategoryMapper appCategoryMapper;


    @Override
    public List<AppCategory> queryLevelTwoByLevelOne(int levelOneId) {
        System.out.println("levelOneId:"+levelOneId);
        return appCategoryMapper.queryLevelByParentId(levelOneId);
    }

    @Override
    public List<AppCategory> queryLevelThreeByLevelTwo(int levelTwoId) {
        return appCategoryMapper.queryLevelByParentId(levelTwoId);
    }
}
