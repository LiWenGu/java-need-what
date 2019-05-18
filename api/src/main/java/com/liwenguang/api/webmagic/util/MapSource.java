package com.liwenguang.api.webmagic.util;

import lombok.Data;

import java.util.Map;

/**
 * @Author liwenguang
 * @Date 2019-05-18 13:40
 * @Description
 */
@Data
public class MapSource {

    private Map<String, Object> map;

    public MapSource(Map<String, Object> map, String source) {
        this.map = map;
        this.map.put("source", source);
    }
}