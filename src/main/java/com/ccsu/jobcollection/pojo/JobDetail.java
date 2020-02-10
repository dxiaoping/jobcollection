package com.ccsu.jobcollection.pojo;

/**
 * @Description 招聘详情信息
 * @auther DuanXiaoping
 * @create 2020-01-28 23:51
 */
public class JobDetail {
    /**宣讲信息目录id*/
    private int jobInfoId;
    /**宣讲信息*/
    private String talkInfo;
    /**宣讲详情*/
    private String talkDetail;
    /**公司简介*/
    private String companyDetail;

    public JobDetail(int jobInfoId, String talkInfo, String talkDetail, String companyDetail) {
        this.jobInfoId = jobInfoId;
        this.talkInfo = talkInfo;
        this.talkDetail = talkDetail;
        this.companyDetail = companyDetail;
    }

    public JobDetail() {
    }

    public int getJobInfoId() {
        return jobInfoId;
    }

    public void setJobInfoId(int jobInfoId) {
        this.jobInfoId = jobInfoId;
    }

    public String getTalkInfo() {
        return talkInfo;
    }

    public void setTalkInfo(String talkInfo) {
        this.talkInfo = talkInfo;
    }

    public String getTalkDetail() {
        return talkDetail;
    }

    public void setTalkDetail(String talkDetail) {
        this.talkDetail = talkDetail;
    }

    public String getCompanyDetail() {
        return companyDetail;
    }

    public void setCompanyDetail(String companyDetail) {
        this.companyDetail = companyDetail;
    }
}
