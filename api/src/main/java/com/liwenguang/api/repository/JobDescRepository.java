package com.liwenguang.api.repository;

import com.liwenguang.api.dao.JobDesc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Optional;

/**
 * @Author liwenguang
 * @Date 2019-05-18 01:07
 * @Description
 */
@RepositoryRestResource(collectionResourceRel = "jobDesc", path = "jobDesc")
public interface JobDescRepository extends JpaRepository<JobDesc, Long> {

    Optional<JobDesc> findTop1BySource(String source);
}