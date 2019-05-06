package com.liang.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.liang.dto.AppInfoDto;
import com.liang.pojo.AppCategory;
import com.liang.pojo.AppInfo;
import com.liang.pojo.DataDictionary;
import com.liang.service.AppInfoService;
import com.liang.service.DataDictionaryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/app")
public class AppController {

    private Logger LOGGER = LoggerFactory.getLogger(AppController.class);

    @Autowired
    private AppInfoService appInfoService;

    @Autowired
    private DataDictionaryService dataDictionaryService;

    @RequestMapping("/index/devId/{id}")
    public String index(@PathVariable("id") long id, Model model){
        System.out.println(id);
        PageInfo<AppInfo> pageInfo = new PageInfo<>();
        pageInfo.setPageSize(4);
        pageInfo.setPageNum(1);

        //pageInfo信息
        pageInfo = appInfoService.queryByDevUserId(id,pageInfo);
        model.addAttribute("pageInfo",pageInfo);

        //平台和状态其实都可以做缓存
        //查询所属平台
        List<DataDictionary> appFlatform = appInfoService.queryAllAppFlatform();
        model.addAttribute("appFlatform",appFlatform);
        //查询App的发布状态
        List<DataDictionary> appStatus = appInfoService.queryAllAppStatus();
        model.addAttribute("appStatus",appStatus);

        //查询分类级别的信息
        //级别1
        List<AppCategory> appCategoriesLevelOne = appInfoService.queryAllAppCategoriesLevelOne();
        model.addAttribute("appCategoriesLevelOne",appCategoriesLevelOne);

        return "app/index";
    }

    @RequestMapping("/query")
    public String query(AppInfoDto appInfoDto,Model model){
        LOGGER.warn("=================appInfoDto:=============="+appInfoDto);
        PageInfo<AppInfoDto> dtoPageInfo = appInfoService.query(appInfoDto);
        model.addAttribute("pageInfo",dtoPageInfo);

        //平台和状态其实都可以做缓存
        //查询所属平台
        List<DataDictionary> appFlatform = appInfoService.queryAllAppFlatform();
        model.addAttribute("appFlatform",appFlatform);
        //查询App的发布状态
        List<DataDictionary> appStatus = appInfoService.queryAllAppStatus();
        model.addAttribute("appStatus",appStatus);

        //查询分类级别的信息
        //级别1
        List<AppCategory> appCategoriesLevelOne = appInfoService.queryAllAppCategoriesLevelOne();
        model.addAttribute("appCategoriesLevelOne",appCategoriesLevelOne);

        return "app/index";
    }

    @RequestMapping("/addApp")
    public String addApp(){


        return "app/index";
    }
}
