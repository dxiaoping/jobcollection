package com.ccsu.jobcollection.controller;

import com.ccsu.jobcollection.common.Result;

import com.ccsu.jobcollection.pojo.WxInfo;
import com.ccsu.jobcollection.service.UserService;
import com.ccsu.jobcollection.util.WxAPI;
import com.ccsu.jobcollection.vo.OpenIDAndSessionKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.Date;

/**
 * @Description
 * @auther DuanXiaoping
 * @create 2020-01-27 17:07
 */
@Controller
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("login")
    @ResponseBody
    public Result login(String encry,
                        String iv, String code) throws IOException {
//        如果没有用户主动授权就不会有openid
        OpenIDAndSessionKey openIDAndSessionKey = WxAPI.getOpenIDAndSessionKey(code);
//        通过openid判断用户是否注册，若没有注册
        WxInfo wxInfo = null;
        if (openIDAndSessionKey != null) wxInfo = userService.getWxInfoByOpenid(openIDAndSessionKey.getOpenId());
        System.out.println("login...");
//        如果已经注册了就更新信息
        System.out.println(openIDAndSessionKey.getOpenId() + new Date());
        if (wxInfo != null) {
            userService.decipher(encry,iv,openIDAndSessionKey.getSessionKey());
            return Result.success("已注册", openIDAndSessionKey);
        } else
            return Result.success("未注册", openIDAndSessionKey);
    }

    @RequestMapping("register")
    @ResponseBody
    public Result register(String encry,
                           String iv, String code) {
        //        通过code获取openId和session_key
        OpenIDAndSessionKey openIDAndSessionKey = WxAPI.getOpenIDAndSessionKey(code);
        WxInfo wxInfo = userService.decipher(encry,iv,openIDAndSessionKey.getSessionKey());
        System.out.println("register...");
        return Result.success(wxInfo);
    }
}
