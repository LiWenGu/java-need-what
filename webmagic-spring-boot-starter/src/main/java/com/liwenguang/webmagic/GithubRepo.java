package com.liwenguang.webmagic;

import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.model.ConsolePageModelPipeline;
import us.codecraft.webmagic.model.OOSpider;
import us.codecraft.webmagic.model.annotation.ExtractBy;
import us.codecraft.webmagic.model.annotation.ExtractByUrl;
import us.codecraft.webmagic.model.annotation.HelpUrl;
import us.codecraft.webmagic.model.annotation.TargetUrl;

/**
 * @Author liwenguang
 * @Date 2019-05-18 02:08
 * @Description
 */
@TargetUrl("https://www.zhipin.com/\\w+/\\w+")
@HelpUrl("https://www.zhipin.com/\\w+")
public class GithubRepo {

    @ExtractBy(value = "//*[@id=\"main\"]/div/div[2]/ul/li[1]/div/div[1]/h3/a/div[1]", notNull = true)
    private String name;

    @ExtractByUrl("//*[@id=\"main\"]/div/div[2]/ul/li[1]/div/div[2]/div/h3/a")
    private String author;

    @ExtractBy("//*[@id=\"main\"]/div/div[2]/ul/li[1]/div/div[1]/p/text()[2]")
    private String readme;

    public static void main(String[] args) {
        OOSpider.create(Site.me().setSleepTime(1000)
                , new ConsolePageModelPipeline(), GithubRepo.class)
                .addUrl("https://www.zhipin.com/job_detail/?query=&city=101020100&industry=&position=").thread(5).run();
    }
}