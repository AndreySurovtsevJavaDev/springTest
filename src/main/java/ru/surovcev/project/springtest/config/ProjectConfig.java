package ru.surovcev.project.springtest.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class ProjectConfig {

    @Autowired
    JdbcTemplate jdbcTemplate;

}
