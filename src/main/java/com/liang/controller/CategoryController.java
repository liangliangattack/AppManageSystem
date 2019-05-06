package com.liang.controller;

import com.liang.pojo.AppCategory;
import com.liang.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @RequestMapping("/queryLevelTwoByLevelOne/{levelOneId}")
    @ResponseBody
    public List<AppCategory> queryLevelTwoByLevelOne(@PathVariable("levelOneId") int levelOneId){
        //级别2
        List<AppCategory> queryLevelTwoByLevelOne = categoryService.queryLevelTwoByLevelOne(levelOneId);

        return queryLevelTwoByLevelOne;
    }

    @RequestMapping("/queryLevelThreeByLevelTwo/{levelTwoId}")
    @ResponseBody
    public List<AppCategory> queryLevelThreeByLevelTwo(@PathVariable("levelTwoId") int levelTwoId){
        //级别3
        List<AppCategory> queryLevelThreeByLevelTwo = categoryService.queryLevelThreeByLevelTwo(levelTwoId);

        return queryLevelThreeByLevelTwo;
    }
}
