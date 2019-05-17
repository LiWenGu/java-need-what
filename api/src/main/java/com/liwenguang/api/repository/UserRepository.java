package com.liwenguang.api.repository;

import com.liwenguang.api.dao.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * @Author liwenguang
 * @Date 2019-05-18 01:07
 * @Description
 */
@RepositoryRestResource(collectionResourceRel = "user", path = "user")
public interface UserRepository extends JpaRepository<User, Long> {
}