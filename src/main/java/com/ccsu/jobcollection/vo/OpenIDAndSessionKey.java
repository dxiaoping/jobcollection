package com.ccsu.jobcollection.vo;

/**
 * @Description
 * @auther DuanXiaoping
 * @create 2020-02-05 15:39
 */
public class OpenIDAndSessionKey {
    private String openId;
    private String sessionKey;

    public OpenIDAndSessionKey(String openId, String sessionKey) {
        this.openId = openId;
        this.sessionKey = sessionKey;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getSessionKey() {
        return sessionKey;
    }

    public void setSessionKey(String sessionKey) {
        this.sessionKey = sessionKey;
    }
}
