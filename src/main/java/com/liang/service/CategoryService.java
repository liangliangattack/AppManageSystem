package com.liang.service;

import com.liang.pojo.AppCategory;

import java.util.List;

public interface CategoryService {

    List<AppCategory> queryLevelTwoByLevelOne(int levelOneId);

    List<AppCategory> queryLevelThreeByLevelTwo(int levelTwoId);
}
