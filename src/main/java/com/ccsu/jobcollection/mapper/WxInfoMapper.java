package com.ccsu.jobcollection.mapper;

import com.ccsu.jobcollection.pojo.WxInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @Description
 * @auther DuanXiaoping
 * @create 2020-01-28 10:16
 */
@Repository
public interface WxInfoMapper {

    int insert(WxInfo wxInfo);
    int update(WxInfo wxInfo);
    WxInfo selectByOpenid(String openid);
}
