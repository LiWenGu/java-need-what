package com.liwenguang.api.webmagic.util;

import com.liwenguang.api.dao.JobDesc;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * @Author liwenguang
 * @Date 2019-05-18 13:45
 * @Description
 */
@Mapper(uses = MappingUtil.class)
public interface Map2JobDescMapper {

    Map2JobDescMapper MAPPER = Mappers.getMapper(Map2JobDescMapper.class);

    @Mapping(source = "map", target = "title", qualifiedBy = MappingUtil.Title.class)
    @Mapping(source = "map", target = "salary", qualifiedBy = MappingUtil.Salary.class)
    @Mapping(source = "map", target = "city", qualifiedBy = MappingUtil.City.class)
    @Mapping(source = "map", target = "require", qualifiedBy = MappingUtil.Require.class)
    @Mapping(source = "map", target = "source", qualifiedBy = MappingUtil.Source.class)
    JobDesc getJobDesc(MapSource s);
}