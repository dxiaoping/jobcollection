package com.ccsu.jobcollection.pojo;

import java.util.Date;

/**
 * @Description
 * @auther DuanXiaoping
 * @create 2020-01-28 16:00
 */
public class JobInfo {
    /**jobId*/private int id;
    /**公司*/private String company;
    /**宣讲地点*/private String address;
    /**宣讲时间*/private String startTime;
    /**面向院系*/private String faceCollege;
    /**详情页URL*/private String detailUrl;
    /**宣讲学校*/private int school;
    /**宣讲时间*/private Date startTime1;
    /**距今多少天*/private int dayDiff;

    public JobInfo() {
    }

    public JobInfo(int id, String company, String address, String startTime, String faceCollege, String detailUrl, int school, Date startTime1, int dayDiff) {
        this.id = id;
        this.company = company;
        this.address = address;
        this.startTime = startTime;
        this.faceCollege = faceCollege;
        this.detailUrl = detailUrl;
        this.school = school;
        this.startTime1 = startTime1;
        this.dayDiff = dayDiff;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getFaceCollege() {
        return faceCollege;
    }

    public void setFaceCollege(String faceCollege) {
        this.faceCollege = faceCollege;
    }

    public String getDetailUrl() {
        return detailUrl;
    }

    public void setDetailUrl(String detailUrl) {
        this.detailUrl = detailUrl;
    }

    public int getSchool() {
        return school;
    }

    public void setSchool(int school) {
        this.school = school;
    }

    public Date getStartTime1() {
        return startTime1;
    }

    public void setStartTime1(Date startTime1) {
        this.startTime1 = startTime1;
    }

    public int getDayDiff() {
        return dayDiff;
    }

    public void setDayDiff(int dayDiff) {
        this.dayDiff = dayDiff;
    }
}
