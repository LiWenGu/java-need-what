package com.liwenguang.webmagic.pipeline;

import com.liwenguang.webmagic.JobDesc;
import com.liwenguang.webmagic.util.Map2JobDescMapper;
import com.liwenguang.webmagic.util.MapSource;
import lombok.extern.slf4j.Slf4j;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

import java.util.regex.Pattern;

import static com.liwenguang.webmagic.SinaBlogProcessor.URL_POST;

/**
 * @Author liwenguang
 * @Date 2019-05-18 13:31
 * @Description
 */
@Slf4j
public class H2Pipeline implements Pipeline {

    private Pattern pattern = Pattern.compile(URL_POST);

    public void process(ResultItems resultItems, Task task) {
        if (pattern.matcher(resultItems.getRequest().getUrl()).find()) {
            JobDesc jobDesc = Map2JobDescMapper.MAPPER.getJobDesc(new MapSource(resultItems.getAll()));
            log.info(jobDesc.toString());
        }
    }
}