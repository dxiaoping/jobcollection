package com.ccsu.jobcollection.pojo;

/**
 * @Description
 * @auther DuanXiaoping
 * @create 2020-02-05 22:58
 */
public class UserJobRelation {
    private String openid;
    private int jobId;
    private boolean isShouCang;

    public UserJobRelation(String openid, int jobId, boolean isShouCang) {
        this.openid = openid;
        this.jobId = jobId;
        this.isShouCang = isShouCang;
    }


    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public int getJobId() {
        return jobId;
    }

    public void setJobId(int jobId) {
        this.jobId = jobId;
    }

    public boolean getIsShouCang() {
        return isShouCang;
    }

    public void setIsShouCang(boolean isShouCang) {
        this.isShouCang = isShouCang;
    }
}
