package com.liwenguang.api.webmagic.pipeline;

import com.liwenguang.api.dao.JobDesc;
import com.liwenguang.api.repository.JobDescRepository;
import com.liwenguang.api.webmagic.util.Map2JobDescMapper;
import com.liwenguang.api.webmagic.util.MapSource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

import java.util.regex.Pattern;

import static com.liwenguang.api.webmagic.util.Constants.URL_POST;

/**
 * @Author liwenguang
 * @Date 2019-05-18 13:31
 * @Description
 */
@Slf4j
@Component
public class H2Pipeline implements Pipeline {

    @Autowired
    private JobDescRepository userRepository;

    private final static Pattern pattern = Pattern.compile(URL_POST);

    @Override
    public void process(ResultItems resultItems, Task task) {
        String sourceUrl = resultItems.getRequest().getUrl();
        if (pattern.matcher(sourceUrl).find()) {
            JobDesc jobDesc = Map2JobDescMapper.MAPPER.getJobDesc(new MapSource(resultItems.getAll(), sourceUrl));
            log.info(jobDesc.toString());
            try {
                userRepository.save(jobDesc);
            } catch (Exception e) {
                log.error("数据保存失败" + jobDesc + "\n" + e.getMessage(), e);
            }
        }
    }
}