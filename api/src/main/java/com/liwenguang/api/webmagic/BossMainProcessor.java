package com.liwenguang.api.webmagic;

import lombok.extern.slf4j.Slf4j;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Request;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;

import static com.liwenguang.api.webmagic.util.Constants.*;

/**
 * @Author liwenguang
 * @Date 2019-05-18 11:01
 * @Description
 */
@Slf4j
public class BossMainProcessor implements PageProcessor {

    private Site site = Site
            .me()
            .setDomain(DOMAIN)
            .setSleepTime(10000)
            .setUserAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_4) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/74.0.3729.131 Safari/537.36");

    @Override
    public boolean needProcess(Request request) {
        log.info(request.getUrl());
        return true;
    }

    @Override
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

    @Override
    public Site getSite() {
        return site;
    }

}