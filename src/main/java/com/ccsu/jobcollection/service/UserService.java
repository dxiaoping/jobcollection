package com.ccsu.jobcollection.service;

import com.ccsu.jobcollection.pojo.WxInfo;

/**
 * @Description
 * @auther DuanXiaoping
 * @create 2020-01-28 13:32
 */
public interface UserService {
    void saveWxInfo(WxInfo wxInfo);
    WxInfo getWxInfoByOpenid(String openid);
    WxInfo decipher(String encry,String iv, String code);
}
