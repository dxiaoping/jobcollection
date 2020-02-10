package com.ccsu.jobcollection.mapper;

import com.ccsu.jobcollection.pojo.JobDetail;

import org.springframework.stereotype.Repository;

/**
 * @Description
 * @auther DuanXiaoping
 * @create 2020-01-28 20:16
 */
@Repository
public interface JobDetailMapper {
    void insertJobDetail(JobDetail jobDetail);
    JobDetail selectByJobInfoId(int id);
}
