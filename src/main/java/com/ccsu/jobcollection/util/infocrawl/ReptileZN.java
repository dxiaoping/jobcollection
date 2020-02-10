package com.ccsu.jobcollection.util.infocrawl;

import com.ccsu.jobcollection.mapper.JobInfoMapper;
import com.ccsu.jobcollection.pojo.JobDetail;
import com.ccsu.jobcollection.pojo.JobInfo;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Description 爬取中南大学的宣讲信息
 * @auther DuanXiaoping
 * @create 2020-01-28 19:12
 */
public class ReptileZN {

    public static final DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
    public static final DateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");

    public static List<JobInfo> getJobInfoForZndx(String url, int startId) throws IOException, ParseException {
        String host = "http://career.csu.edu.cn";
//        中南大学
        List<JobInfo> list = new ArrayList<>(100);
        Document doc = Jsoup.connect(url).get();
        Elements elements = doc.select("ul[class=infoList teachinList]");
        for (Element element : elements) {
            startId++;
            String company = element.select("a").text();
            String href = host + element.select("a[href]").attr("href");
            String address = element.select("li[class=span4]").text();
            String startTime = element.select("li[class=span5]").text();
//            System.out.println(startTime);
            int dateLength = startTime.length();
            Date date = null;
            long dayDiff = 0;
            if (dateLength > 20) {
                date = format.parse(startTime.substring(0, 16));
                dayDiff = (date.getTime() - new Date().getTime()) / (24L * 3600L * 1000L);
            } else {
                date = format1.parse(startTime.substring(0, 10));
                dayDiff = (date.getTime() - new Date().getTime()) / (24L * 3600L * 1000L);
            }
            JobInfo jobInfo = new JobInfo(startId, company, address, startTime, "", href, 1, date, (int) dayDiff);
            list.add(jobInfo);
        }
        return list;
    }

    public static JobDetail getJobDetail(JobInfo jobInfo) throws IOException {
        Document doc = Jsoup.connect(jobInfo.getDetailUrl()).get();
        JobDetail detail = null;
//        宣讲信息（时间地点）
        Elements talkInfoelements = doc.select("div[id=mn]");
        String talkInfo =
                talkInfoelements.first().select("div[class=viewHead] > h1").toString() +
                        talkInfoelements.first().select("ul[class=xInfo xInfo-2]").toString() +
                        talkInfoelements.first().select("ul[class=xInfo xInfo-2 cl tInfo-2]").toString();
//        宣讲详情
        Elements talkDetailelements = doc.select("div[id=vTab1]");
        String talkDetail = "";
        if (!talkDetailelements.first().text().equals("")) {
            talkDetail = talkDetailelements.first().toString();
            talkDetail = talkDetail.replaceAll("display: none;", "display: block;");
        }
//        公司简介
        Elements companyDetailelements = doc.select("ul[id=vTab2]");
        String companyDetail = "";
        if (!companyDetailelements.first().text().equals("")) {
            companyDetail = companyDetailelements.first().toString();
            companyDetail = companyDetail.replaceAll("display: none;", "display: block;");

        }

        detail = new JobDetail(jobInfo.getId(), talkInfo, talkDetail, companyDetail);
        return detail;
    }

    public static void main(String[] args) {
        String url = "http://career.csu.edu.cn/teachin/index?domain=jobcsu&page=1";
    }
}
