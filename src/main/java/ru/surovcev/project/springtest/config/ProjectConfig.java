package ru.surovcev.project.springtest.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * 13. Создайте конфигурационный класс, который создаёт бин DataSource.
 */
@Configuration
public class ProjectConfig {

    @Autowired
    JdbcTemplate jdbcTemplate;



}
