package com.liang.pojo;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class AppInfo {
    private Long id;

    private String softwareName;//

    private String apkName;//

    private String supportRom;//

    private String interfaceLanguage;//

    private BigDecimal softwareSize;//

    private Date updateDate;

    private String appInfo;//

    private Long status;
    private DataDictionary appStatus;//

    private Date onSaleDate;

    private Date offSaleDate;

    private Long flatformId;
    private DataDictionary flatForm;//

//    private Long categoryLevel3;

    private Long downloads;

    private Long createdBy;

    private Date creationDate;

    private Long modifyBy;

    private Date modifyDate;

//    private Long categoryLevel1;

//    private Long categoryLevel2;
    private String logoPicPath;

    private String logoLocPath;

//    private Long versionId;

    private AppCategory categoryLevel1;//
    private AppCategory categoryLevel2;//
    private AppCategory categoryLevel3;//

    private List<AppVersion> appVersions;

    private AppVersion latestVersion;

    private Long devId;
    private DevUser devUser;

    public Long getStatus() {
        return status;
    }

    public void setStatus(Long status) {
        this.status = status;
    }

    public Long getFlatformId() {
        return flatformId;
    }

    public void setFlatformId(Long flatformId) {
        this.flatformId = flatformId;
    }

    public Long getDevId() {
        return devId;
    }

    public void setDevId(Long devId) {
        this.devId = devId;
    }

    public DataDictionary getAppStatus() {
        return appStatus;
    }

    public void setAppStatus(DataDictionary appStatus) {
        this.appStatus = appStatus;
    }

    public DataDictionary getFlatForm() {
        return flatForm;
    }

    public void setFlatForm(DataDictionary flatForm) {
        this.flatForm = flatForm;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSoftwareName() {
        return softwareName;
    }

    public void setSoftwareName(String softwareName) {
        this.softwareName = softwareName == null ? null : softwareName.trim();
    }

    public String getApkName() {
        return apkName;
    }

    public void setApkName(String apkName) {
        this.apkName = apkName == null ? null : apkName.trim();
    }

    public String getSupportRom() {
        return supportRom;
    }

    public void setSupportRom(String supportRom) {
        this.supportRom = supportRom == null ? null : supportRom.trim();
    }

    public String getInterfaceLanguage() {
        return interfaceLanguage;
    }

    public void setInterfaceLanguage(String interfaceLanguage) {
        this.interfaceLanguage = interfaceLanguage == null ? null : interfaceLanguage.trim();
    }

    public BigDecimal getSoftwareSize() {
        return softwareSize;
    }

    public void setSoftwareSize(BigDecimal softwareSize) {
        this.softwareSize = softwareSize;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getAppInfo() {
        return appInfo;
    }

    public void setAppInfo(String appInfo) {
        this.appInfo = appInfo == null ? null : appInfo.trim();
    }

    public Date getOnSaleDate() {
        return onSaleDate;
    }

    public void setOnSaleDate(Date onSaleDate) {
        this.onSaleDate = onSaleDate;
    }

    public Date getOffSaleDate() {
        return offSaleDate;
    }

    public void setOffSaleDate(Date offSaleDate) {
        this.offSaleDate = offSaleDate;
    }

    public Long getDownloads() {
        return downloads;
    }

    public void setDownloads(Long downloads) {
        this.downloads = downloads;
    }

    public Long getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Long getModifyBy() {
        return modifyBy;
    }

    public void setModifyBy(Long modifyBy) {
        this.modifyBy = modifyBy;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    public String getLogoPicPath() {
        return logoPicPath;
    }

    public void setLogoPicPath(String logoPicPath) {
        this.logoPicPath = logoPicPath == null ? null : logoPicPath.trim();
    }

    public String getLogoLocPath() {
        return logoLocPath;
    }

    public void setLogoLocPath(String logoLocPath) {
        this.logoLocPath = logoLocPath == null ? null : logoLocPath.trim();
    }

    public List<AppVersion> getAppVersions() {
        return appVersions;
    }

    public void setAppVersions(List<AppVersion> appVersions) {
        this.appVersions = appVersions;
    }

    public AppCategory getCategoryLevel1() {
        return categoryLevel1;
    }

    public void setCategoryLevel1(AppCategory categoryLevel1) {
        this.categoryLevel1 = categoryLevel1;
    }

    public AppCategory getCategoryLevel2() {
        return categoryLevel2;
    }

    public void setCategoryLevel2(AppCategory categoryLevel2) {
        this.categoryLevel2 = categoryLevel2;
    }

    public AppCategory getCategoryLevel3() {
        return categoryLevel3;
    }

    public void setCategoryLevel3(AppCategory categoryLevel3) {
        this.categoryLevel3 = categoryLevel3;
    }

    public DevUser getDevUser() {
        return devUser;
    }

    public void setDevUser(DevUser devUser) {
        this.devUser = devUser;
    }

    public AppVersion getLatestVersion() {
        return latestVersion;
    }

    public void setLatestVersion(AppVersion latestVersion) {
        this.latestVersion = latestVersion;
    }

    @Override
    public String toString() {
        return "AppInfo{" +
                "id=" + id +
                ", softwareName='" + softwareName + '\'' +
                ", apkName='" + apkName + '\'' +
                ", supportRom='" + supportRom + '\'' +
                ", interfaceLanguage='" + interfaceLanguage + '\'' +
                ", softwareSize=" + softwareSize +
                ", updateDate=" + updateDate +
                ", appInfo='" + appInfo + '\'' +
                ", appStatus=" + appStatus +
                ", onSaleDate=" + onSaleDate +
                ", offSaleDate=" + offSaleDate +
                ", flatForm=" + flatForm +
                ", categoryLevel1=" + categoryLevel1 +
                ", categoryLevel2=" + categoryLevel2 +
                ", categoryLevel3=" + categoryLevel3 +
                ", appVersions=" + appVersions +
                ", latestVersion=" + latestVersion +
                ", devUser=" + devUser +
                '}';
    }
}