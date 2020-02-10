package com.ccsu.jobcollection.controller;

import com.ccsu.jobcollection.common.Result;
import com.ccsu.jobcollection.pojo.JobDetail;
import com.ccsu.jobcollection.pojo.JobInfo;
import com.ccsu.jobcollection.pojo.UserJobRelation;
import com.ccsu.jobcollection.service.JobInfoService;
import com.ccsu.jobcollection.util.infocrawl.ReptileZN;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

/**
 * @Description
 * @auther DuanXiaoping
 * @create 2020-01-28 14:32
 */
@Controller
@RequestMapping("job")
public class JobInfoController {

    @Autowired
    private JobInfoService jobInfoService;

    @RequestMapping("update_job_info")
    @ResponseBody
    public String updateJobInfo(
    ) throws IOException, ParseException {
        jobInfoService.updateJobInfo();
        return "SUCCESS";
    }

    @RequestMapping("get_jobinfo")
    @ResponseBody
    public List<JobInfo> getJobInfo(int pageNo, int pageSize,
                                    boolean isTimeDesc, int dayRange,
                                    String openid) {

        List<JobInfo> jobInfos = null;
        jobInfos = jobInfoService.getJobInfoList(pageNo, pageSize, isTimeDesc, dayRange, openid);
        return jobInfos;
    }

    @RequestMapping("get_job_detail")
    @ResponseBody
    public Result getJobDetail(int id, String openid
    ) throws IOException, ParseException {
        JobDetail jobDetail = jobInfoService.getJobDetail(id);
        if (jobInfoService.getShoucangStatus(id, openid) == null) {
            return Result.success("未收藏", jobDetail);
        } else {
            return Result.success("已收藏", jobDetail);
        }
    }

    @RequestMapping("shoucang")
    @ResponseBody
    public JobDetail shoucangJob(
            UserJobRelation userJobRelation
    ) throws IOException, ParseException {
        jobInfoService.updateShoucang(userJobRelation);
        return null;
    }
}
