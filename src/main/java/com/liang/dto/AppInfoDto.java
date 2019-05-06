package com.liang.dto;

public class AppInfoDto {

    private String softwareName;
    private Long appStatus;
    private Long appFlatform;
    private Long appCategoriesLevelOne;
    private Long appCategoriesLevelTwo;
    private Long appCategoriesLevelThree;

    private Integer pageNum;

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public String getSoftwareName() {
        return softwareName;
    }

    public void setSoftwareName(String softwareName) {
        this.softwareName = softwareName;
    }

    public Long getAppStatus() {
        return appStatus;
    }

    public void setAppStatus(Long appStatus) {
        this.appStatus = appStatus;
    }

    public Long getAppFlatform() {
        return appFlatform;
    }

    public void setAppFlatform(Long appFlatform) {
        this.appFlatform = appFlatform;
    }

    public Long getAppCategoriesLevelOne() {
        return appCategoriesLevelOne;
    }

    public void setAppCategoriesLevelOne(Long appCategoriesLevelOne) {
        this.appCategoriesLevelOne = appCategoriesLevelOne;
    }

    public Long getAppCategoriesLevelTwo() {
        return appCategoriesLevelTwo;
    }

    public void setAppCategoriesLevelTwo(Long appCategoriesLevelTwo) {
        this.appCategoriesLevelTwo = appCategoriesLevelTwo;
    }

    public Long getAppCategoriesLevelThree() {
        return appCategoriesLevelThree;
    }

    public void setAppCategoriesLevelThree(Long appCategoriesLevelThree) {
        this.appCategoriesLevelThree = appCategoriesLevelThree;
    }

    @Override
    public String toString() {
        return "AppInfoDto{" +
                "softwareName='" + softwareName + '\'' +
                ", appStatus=" + appStatus +
                ", appFlatform=" + appFlatform +
                ", appCategoriesLevelOne=" + appCategoriesLevelOne +
                ", appCategoriesLevelTwo=" + appCategoriesLevelTwo +
                ", appCategoriesLevelThree=" + appCategoriesLevelThree +
                ", pageNum=" + pageNum +
                '}';
    }
}
