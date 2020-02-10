package com.ccsu.jobcollection.util;

import com.ccsu.jobcollection.common.Const;
import com.ccsu.jobcollection.vo.OpenIDAndSessionKey;
import org.json.JSONObject;
import org.jsoup.Connection;
import org.jsoup.helper.HttpConnection;

import java.io.IOException;

/**
 * @Description
 * @auther DuanXiaoping
 * @create 2020-02-05 15:38
 */
public class WxAPI {
    public static OpenIDAndSessionKey getOpenIDAndSessionKey(String code) {
        OpenIDAndSessionKey openIDAndSessionKey = null;
        String openId = "";
        String sessionkey = "";
        String url = Const.WxAPI.GET_SESSION.replace("APPID", Const.WxAPI.AppID);
        url = url.replace("SECRET", Const.WxAPI.AppSecret);
        url = url.replace("JSCODE", code);
        System.out.println(url);
        Connection conn = HttpConnection.connect(url);
        Connection.Response response = null;
        try {
            response = conn.execute();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("从网络获取openid失败");
            return null;
        }


        if (response.statusCode() == 200) {
            JSONObject json = new JSONObject(response.body());

            if (!json.isNull("openid") && !json.isNull("session_key")) {
                openId = json.getString("openid");
                sessionkey = json.getString("session_key");
                openIDAndSessionKey = new OpenIDAndSessionKey(openId,sessionkey);
            }
        }
        return openIDAndSessionKey;
    }
}
