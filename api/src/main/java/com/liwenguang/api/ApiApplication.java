package com.liwenguang.api;

import com.liwenguang.api.webmagic.BossMainProcessor;
import com.liwenguang.api.webmagic.pipeline.H2Pipeline;
import com.liwenguang.api.webmagic.util.ThreadPoolUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import us.codecraft.webmagic.Spider;

@SpringBootApplication
public class ApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiApplication.class, args);
        //startBoss();
    }

    private static void startBoss() {
        Spider.create(bossMainProcessor).addUrl("https://www.zhipin.com/c101020100/e_105/?query=java&page=0")
                .thread(ThreadPoolUtil.get("webmagic-boss"), ThreadPoolUtil.THREAD_NUMBER)
                .addPipeline(h2Pipeline)
                .start();
    }

    private static H2Pipeline h2Pipeline;

    @Autowired
    public void setH2Pipeline(H2Pipeline h2Pipeline) {
        ApiApplication.h2Pipeline = h2Pipeline;
    }

    @Autowired
    private static BossMainProcessor bossMainProcessor;

    @Autowired
    public void setBossMainProcessor(BossMainProcessor bossMainProcessor) {
        ApiApplication.bossMainProcessor = bossMainProcessor;
    }
}
