package com.liwenguang.api.webmagic.util;

import org.mapstruct.Qualifier;
import us.codecraft.webmagic.selector.HtmlNode;
import us.codecraft.webmagic.selector.PlainText;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Map;

/**
 * @Author liwenguang
 * @Date 2019-05-18 13:36
 * @Description
 */
public class MappingUtil {

    @Qualifier
    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.SOURCE)
    @interface Title {
    }

    @Qualifier
    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.SOURCE)
    @interface Salary {
    }

    @Qualifier
    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.SOURCE)
    @interface City {
    }

    @Qualifier
    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.SOURCE)
    @interface Require {
    }

    @Qualifier
    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.SOURCE)
    @interface Source {
    }

    @Title
    public String title(Map<String, Object> in) {
        return ((PlainText) in.get("title")).get();
    }

    @Salary
    public String salary(Map<String, Object> in) {
        return ((PlainText) in.get("salary")).get();
    }

    @City
    public String city(Map<String, Object> in) {
        return ((HtmlNode) in.get("city")).get();
    }

    @Require
    public String require(Map<String, Object> in) {
        return ((PlainText) in.get("require")).get();
    }

    @Source
    public String source(Map<String, Object> in) {
        return (String) in.get("source");
    }
}