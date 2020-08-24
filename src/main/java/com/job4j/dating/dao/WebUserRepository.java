package com.job4j.dating.dao;

import com.job4j.dating.entity.WebUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface WebUserRepository extends JpaRepository<WebUser, Long> {
    WebUser findByEmail(String email);
}
