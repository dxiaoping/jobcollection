package com.ccsu.jobcollection.util.infocrawl;

/**
 * @Description
 * @auther DuanXiaoping
 * @create 2020-01-28 19:12
 */

//import com.gargoylesoftware.htmlunit.BrowserVersion;
//import com.gargoylesoftware.htmlunit.WebClient;
//import com.gargoylesoftware.htmlunit.html.HtmlPage;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.io.*;

public class ReptileHD {
    //使用Jsoup+Htmlunit下载动态js的内容

    public static void main(String[] args) {
        String ENTRY_URL = "http://weixin.sogou.com/weixin?type=1&query=%s&ie=utf8&_sug_=n&_sug_type_=";//入口地址
        String QUERY_WORD = "DOTA每日节奏";//查询参数
        String BASE_URL = "";//从入口进入公众号后的公众号地址
        String WE_CHAT_URL = "http://mp.weixin.qq.com";//微信公众号官方入口
        int NEW_MSG_ID = 0;//最新msgId
        int MSG_NUM = 20;//需要获取的数量
        String url = String.format(ENTRY_URL, QUERY_WORD);
        //System.out.println(url);
//        WebClient webClient = new WebClient(BrowserVersion.CHROME);
//        webClient.getOptions().setCssEnabled(false);
//        webClient.getOptions().setJavaScriptEnabled(true);
//        webClient.getOptions().setRedirectEnabled(true);
//        webClient.getOptions().setThrowExceptionOnScriptError(false);
//        webClient.getOptions().setTimeout(50000);
//        Document doc = null;
//        try {
//            //首先用jsoup获取搜狗入口公众号连接
//            doc = Jsoup.connect(url).get();
//            //System.out.println("doc:" + doc);
//            BASE_URL = doc.select("p a").attr("href");
//            //System.out.println(BASE_URL);
//
//            //使用htmlunit加载公众号文章列表
//            HtmlPage htmlPage = webClient.getPage(BASE_URL);
//            webClient.waitForBackgroundJavaScript(10000);
//            doc = Jsoup.parse(htmlPage.asXml());
//            //System.out.println("doc:" + doc);
//            //获取最新文章msgid，之后的循环用msgid-1
//            String lastMsgId = doc.select(".weui_media_box").attr("msgid");
//            NEW_MSG_ID = Integer.parseInt(lastMsgId);
//            //System.out.println(NEW_MSG_ID);
//
//            for (int i = NEW_MSG_ID; i >= NEW_MSG_ID - MSG_NUM; i--) {
//                String articalPrev = "#WXAPPMSG";
//                String articalId = articalPrev + i;
//                String h4 = articalId + " h4";
//                String weui_media_desc = articalId + " .weui_media_desc";
//                String weui_media_extra_info = articalId + " .weui_media_extra_info";
//
//                System.out.println(articalId);
//                String title = doc.select(h4).text();
//                System.out.println(title);
//                String detailUrl = doc.select(h4).attr("hrefs");//2018.1.3 ok
//                System.out.println(WE_CHAT_URL + detailUrl);
//                String note = doc.select(weui_media_desc).text();//2018.1.3 ok
//                if (note.compareToIgnoreCase("") == 0) {
//                    continue;
//                }
//                System.out.println(note);
//                String releaseDate = doc.select(weui_media_extra_info).text().toString();//2018.1.3 ok
//                if (releaseDate.compareToIgnoreCase("") == 0) {
//                    continue;
//                }
//                System.out.println(releaseDate);
//            }
//            webClient.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//            webClient.close();
//        }
    }


}
