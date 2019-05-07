package com.liang.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.liang.dto.AppInfoDto;
import com.liang.pojo.AppCategory;
import com.liang.pojo.AppInfo;
import com.liang.pojo.DataDictionary;
import com.liang.pojo.DevUser;
import com.liang.service.AppInfoService;
import com.liang.service.DataDictionaryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
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

    //首页默认查询
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

    //App信息表单多条件查询
    @RequestMapping("/query")
    public String query(AppInfoDto appInfoDto,Model model){//特别注意这里的表单的AppInfoDto和addApp的AppInfo两个pojo是有区别的
        LOGGER.warn("=================appInfoDto:=============="+appInfoDto);
        PageInfo<AppInfoDto> dtoPageInfo = appInfoService.query(appInfoDto);
        model.addAttribute("pageInfo",dtoPageInfo);

        //App平台
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

    //App添加
    @RequestMapping("/toAddApp")
    public String toAddApp(Model model){
        //App平台
        List<DataDictionary> appFlatform = appInfoService.queryAllAppFlatform();
        model.addAttribute("appFlatform",appFlatform);
        //查询App的发布状态
        List<DataDictionary> appStatus = appInfoService.queryAllAppStatus();
        model.addAttribute("appStatus",appStatus);
        //查询分类级别的信息
        //级别1
        List<AppCategory> appCategoriesLevelOne = appInfoService.queryAllAppCategoriesLevelOne();
        model.addAttribute("appCategoriesLevelOne",appCategoriesLevelOne);
        return "app/addapp";
    }
    @RequestMapping("/addApp")
    public String addApp(AppInfo appInfo, HttpSession session){//AppInfoDto里面保存的大多是基本数据类型，而AppInfo里面有很多的对象，所以表单提交的是时候
        //System.out.println(appInfo);        //的name属性就需要特别注意
        DevUser devUser = (DevUser) session.getAttribute("devUser");
        System.out.println("devUser:id"+devUser.getId());
        long userId = devUser.getId();

        //添加
        boolean isAdd = appInfoService.addApp(appInfo,userId);
        LOGGER.warn("添加App结果",isAdd);

        //添加之后 转发到一个action
        return "forward:/app/index/devId/"+userId+".do";
    }

    //App编辑
    @RequestMapping("/toEditApp/{appId}")
    public String toEditApp(@PathVariable("appId") Long appId,Model model){
        //查询需要编辑的App的信息
        AppInfo appInfo = appInfoService.queryAppById(appId);
        model.addAttribute("appInfo",appInfo);

        //App平台
        List<DataDictionary> appFlatform = appInfoService.queryAllAppFlatform();
        model.addAttribute("appFlatform",appFlatform);
        //查询App的发布状态
        List<DataDictionary> appStatus = appInfoService.queryAllAppStatus();
        model.addAttribute("appStatus",appStatus);
        //查询分类级别的信息
        //级别1
        List<AppCategory> appCategoriesLevelOne = appInfoService.queryAllAppCategoriesLevelOne();
        model.addAttribute("appCategoriesLevelOne",appCategoriesLevelOne);

        return "app/editapp";
    }
    @RequestMapping("/updateApp")
    public String updateApp(AppInfo appInfo,HttpSession session){
        LOGGER.warn("===============================appInfo=============================",appInfo);
        DevUser devUser = (DevUser) session.getAttribute("devUser");

        appInfo.setDevUser(devUser);
        appInfo.setCreatedByUser(devUser);
        appInfo.setModifyByUser(devUser);

        appInfoService.updateAppById(appInfo);
        return "redirect:/app/index/devId/"+devUser.getId()+".do";

    }

    /**
     * 查询App详细信息
     * @param appId
     * @return
     */
    @RequestMapping("/detailApp/{appId}")
    public String detailApp(@PathVariable("appId") Long appId,Model model){
        AppInfo appInfo = appInfoService.detailApp(appId);
        model.addAttribute("appInfo",appInfo);

        //App平台
        List<DataDictionary> appFlatform = appInfoService.queryAllAppFlatform();
        model.addAttribute("appFlatform",appFlatform);
        //查询App的发布状态
        List<DataDictionary> appStatus = appInfoService.queryAllAppStatus();
        model.addAttribute("appStatus",appStatus);
        //查询分类级别的信息
        //级别1
        List<AppCategory> appCategoriesLevelOne = appInfoService.queryAllAppCategoriesLevelOne();
        model.addAttribute("appCategoriesLevelOne",appCategoriesLevelOne);

        return "app/detail";
    }

    //删除App
    @RequestMapping("/deleteApp/{appId}")
    public String deleteApp(@PathVariable("appId") long appId,HttpSession session){

        boolean isDelete = appInfoService.deleteApp(appId);
        LOGGER.warn("删除结果："+isDelete);
        DevUser devUser = (DevUser) session.getAttribute("devUser");

        return "redirect:/app/index/devId/"+devUser.getId()+".do";
    }
}
