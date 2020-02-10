package com.ccsu.jobcollection.mapper;

import com.ccsu.jobcollection.pojo.JobInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Description
 * @auther DuanXiaoping
 * @create 2020-01-28 20:16
 */
@Repository
public interface JobInfoMapper {
    void insertJobInfo(JobInfo jobInfo);
    JobInfo selectByUrl(String url);
    JobInfo queryOrderById();
    Integer getMaxId();
    List<JobInfo> queryJobInfo(@Param("startIndex")int startIndex,@Param("pageSize") int pageSize,@Param("order") String order,@Param("dayRange") int dayRange);
    List<JobInfo> querySCJobInfo(@Param("startIndex")int startIndex,@Param("pageSize") int pageSize,@Param("order") String order,@Param("dayRange") int dayRange,@Param("openid")String openid);
}
