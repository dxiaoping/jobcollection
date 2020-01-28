package com.ccsu.jobcollection.service.impl;

import com.ccsu.jobcollection.mapper.WxInfoMapper;
import com.ccsu.jobcollection.pojo.WxInfo;
import com.ccsu.jobcollection.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description
 * @auther DuanXiaoping
 * @create 2020-01-28 13:33
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private WxInfoMapper wxInfoMapper;

    @Override
    public void saveWxInfo(WxInfo wxInfo) {
        wxInfoMapper.insert(wxInfo);
    }
}
