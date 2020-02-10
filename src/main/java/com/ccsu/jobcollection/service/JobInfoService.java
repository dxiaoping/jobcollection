package com.ccsu.jobcollection.service;

import com.ccsu.jobcollection.pojo.JobDetail;
import com.ccsu.jobcollection.pojo.JobInfo;
import com.ccsu.jobcollection.pojo.UserJobRelation;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

public interface JobInfoService {
    void updateJobInfo() throws IOException, ParseException;
    List<JobInfo> getJobInfoList(int page,int pageSize,boolean isTimeDesc,int dayRange,String openid) ;
    JobDetail getJobDetail(int id) ;
    void updateShoucang(UserJobRelation userJobRelation);
    Boolean getShoucangStatus(int id,String openid);
}
