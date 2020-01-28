package com.ccsu.jobcollection.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Description
 * @auther DuanXiaoping
 * @create 2020-01-28 14:32
 */
@Controller
@RequestMapping("job")
public class JobInfoController {
    @RequestMapping("add")
    @ResponseBody
    public String addJobInfo(
            String company,
            String school,
//                           String address,
            String date
    ) {
        System.out.println(company);
        System.out.println(school);
//        System.out.println(address);
        System.out.println(date);
        System.out.println("正在添加招聘信息学...");
        return "SUCCESS";
    }
}
