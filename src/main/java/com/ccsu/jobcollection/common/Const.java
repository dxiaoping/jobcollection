package com.ccsu.jobcollection.common;

/**
 * @Description
 * @auther DuanXiaoping
 * @create 2020-02-04 20:13
 */
public interface Const {
    interface WxAPI{
        String AppID = "wx85ba6df0e1434c0a";
        String AppSecret = "ff68fc1c88cc84ae10e84cbf0f2ed433";
        //获取session_key的接口
        String GET_SESSION = "https://api.weixin.qq.com/sns/jscode2session?appid=APPID&secret=SECRET&js_code=JSCODE&grant_type=authorization_code";
        //获取Access_Token的接口
        String ACCESS_TOKEN = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";

        //发送模板消息
        String SEND_TEMPLATE_MSG = "https://api.weixin.qq.com/cgi-bin/message/wxopen/template/send?access_token=ACCESS_TOKEN";

        //生成小程序码 C类接口
        String CREATE_AQRCODE_C = "https://api.weixin.qq.com/cgi-bin/wxaapp/createwxaqrcode?access_token=ACCESS_TOKEN";

        //生成小程序码 B类接口
        String CREATE_AQRCODE_B = "https://api.weixin.qq.com/wxa/getwxacodeunlimit?access_token=ACCESS_TOKEN";

        //生成小程序码 A类接口
        String CREATE_AQRCODE_A = "https://api.weixin.qq.com/wxa/getwxacode?access_token=ACCESS_TOKEN";
    }
}
