package com.liwenguang.webmagic.util;

import java.util.Map;

/**
 * @Author liwenguang
 * @Date 2019-05-18 13:40
 * @Description
 */
public class MapSource {

    private Map<String, Object> map;

    public Map<String, Object> getMap() {
        return map;
    }

    public void setMap(Map<String, Object> map) {
        this.map = map;
    }

    public MapSource(Map<String, Object> map) {
        this.map = map;
    }
}