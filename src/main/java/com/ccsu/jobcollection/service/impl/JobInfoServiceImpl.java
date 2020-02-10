package com.ccsu.jobcollection.service.impl;

import com.ccsu.jobcollection.mapper.JobDetailMapper;
import com.ccsu.jobcollection.mapper.JobInfoMapper;
import com.ccsu.jobcollection.mapper.UserJobRelationMapper;
import com.ccsu.jobcollection.pojo.JobDetail;
import com.ccsu.jobcollection.pojo.JobInfo;
import com.ccsu.jobcollection.pojo.UserJobRelation;
import com.ccsu.jobcollection.service.JobInfoService;
import com.ccsu.jobcollection.util.infocrawl.ReptileZN;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * @auther DuanXiaoping
 * @create 2020-01-28 20:30
 */
@Service
public class JobInfoServiceImpl implements JobInfoService {

    @Autowired
    private JobInfoMapper jobInfoMapper;

    @Autowired
    private JobDetailMapper jobDetailMapper;

    @Autowired
    private UserJobRelationMapper relationMapper;

    @Override
    public void updateJobInfo() throws IOException, ParseException {
        /**
         * 设置detailUrl在数据库中唯一，
         * 在更新的时候新增到已经加入的招聘信息时就会抛出异常
         * 验证异常是重复url造成的，如果是则此次更新完成，否则继续更新
         */
        String urlHost = "http://career.csu.edu.cn/teachin/index?domain=jobcsu&page=";
        for (int page = 1; page < 4; page++) {
            String url = urlHost + page;
            Integer maxId = jobInfoMapper.getMaxId();
            if (maxId == null) maxId = 0;
            List<JobInfo> jobInfos = ReptileZN.getJobInfoForZndx(url, maxId);
            for (JobInfo jobInfo : jobInfos) {
                try {
                    jobInfoMapper.insertJobInfo(jobInfo);
                    saveDetail(jobInfo);
//                    System.out.println(jobInfo.getCompany());
                } catch (Exception e) {
                    e.printStackTrace();
                    JobInfo jobInfo2 = jobInfoMapper.selectByUrl(jobInfo.getDetailUrl());
                    System.out.println("更新招聘信息异常");
                    if (jobInfo2 != null) {
                        return;
                    } else {
                        continue;
                    }
                }
            }
        }
    }

    @Override
    public List<JobInfo> getJobInfoList(int page, int pageSize, boolean isTimeDesc, int dayRange, String openid) {
        List<JobInfo> jobInfos =null;
        if (openid == null || "".equals(openid)) {
             jobInfos = jobInfoMapper.queryJobInfo((page - 1) * pageSize, pageSize, (isTimeDesc ? "desc" : "asc"), dayRange);
        } else {
            jobInfos = jobInfoMapper.querySCJobInfo((page - 1) * pageSize, pageSize, (isTimeDesc ? "desc" : "asc"), dayRange, openid);
        }
        return jobInfos;
    }

    @Override
    public JobDetail getJobDetail(int id) {
        JobDetail jobDetail = jobDetailMapper.selectByJobInfoId(id);
        return jobDetail;
    }

    @Override
    public void updateShoucang(UserJobRelation userJobRelation) {
        if (userJobRelation.getIsShouCang()) {
            relationMapper.insert(userJobRelation);
        } else {
            relationMapper.delete(userJobRelation);
        }
    }

    @Override
    public Boolean getShoucangStatus(int id, String openid) {
        return relationMapper.getStatus(id, openid);
    }

    private void saveDetail(JobInfo jobInfo) throws IOException {
        JobDetail jobDetail = ReptileZN.getJobDetail(jobInfo);
        jobDetailMapper.insertJobDetail(jobDetail);
    }
}
