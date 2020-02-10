package com.ccsu.jobcollection.mapper;

import com.ccsu.jobcollection.pojo.JobInfo;
import com.ccsu.jobcollection.pojo.UserJobRelation;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Description
 * @auther DuanXiaoping
 * @create 2020-01-28 20:16
 */
@Repository
public interface UserJobRelationMapper {
    void insert(UserJobRelation userJobRelation);
    void delete(UserJobRelation userJobRelation);
    Boolean getStatus(@Param("jobId") int jobId,@Param("openid")String openid);
}
