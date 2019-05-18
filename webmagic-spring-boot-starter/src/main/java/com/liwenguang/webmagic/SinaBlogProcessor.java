package com.liwenguang.webmagic;

import com.liwenguang.webmagic.pipeline.H2Pipeline;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;

/**
 * @Author liwenguang
 * @Date 2019-05-18 11:01
 * @Description
 */
public class SinaBlogProcessor implements PageProcessor {

    public static final String URL_LIST = "https://www\\.zhipin\\.com/c101020100/e_105/\\?query=java&page=\\d+";

    public static final String URL_POST = "https://www\\.zhipin\\.com/job_detail/\\S+\\.html";

    private Site site = Site
            .me()
            .setDomain("www.zhipin.com")
            .setSleepTime(3000)
            .setUserAgent(
                    "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_4) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/74.0.3729.131 Safari/537.36");

    public void process(Page page) {
        //列表页
        if (page.getUrl().regex(URL_LIST).match()) {
            page.addTargetRequests(page.getHtml().xpath("//div[@class=\"job-list\"]").links().regex(URL_POST).all());
            page.addTargetRequests(page.getHtml().xpath("//div[@class=\"page\"]").links().regex(URL_LIST).all());
            //文章页
        } else {
            page.putField("title", page.getHtml().xpath("//*[@id=\"main\"]/div[1]/div/div/div[2]/div[2]/h1/text()"));
            page.putField("salary", page.getHtml().xpath("//*[@id=\"main\"]/div[1]/div/div/div[2]/div[2]/span/text()"));
            page.putField("city", page.getHtml().xpath("//*[@id=\"main\"]/div[1]/div/div/div[2]/p"));
            page.putField("require", page.getHtml().xpath("//*[@id=\"main\"]/div[3]/div/div[2]/div[2]/div[1]/div/text()"));
        }
    }

    public Site getSite() {
        return site;
    }

    public static void main(String[] args) {
        Spider.create(new SinaBlogProcessor()).addUrl("https://www.zhipin.com/c101020100/e_105/?query=java&page=1")
                .addPipeline(new H2Pipeline())
                .run();
    }

}