package com.spring.jdbc.config;

import com.spring.jdbc.dao.FishDao;
import com.spring.jdbc.dao.FishDaoImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class FishConfig {

    @Bean(name = {"ds"})
    public DataSource getDataSource(){
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
        ds.setUrl("jdbc:mysql://localhost:3306/fishdatabase");
        ds.setUsername("root");
        ds.setPassword("root");
        return ds;
    }
    @Bean(name = {"jdbcTemplate"})
    public JdbcTemplate getJdbcTemplate(){
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(getDataSource());
        return jdbcTemplate;
    }
    @Bean
    public FishDao fishDao(){
        FishDaoImpl fishDao = new FishDaoImpl();
        fishDao.setJdbcTemplate(getJdbcTemplate());
        return fishDao;

    }
}
