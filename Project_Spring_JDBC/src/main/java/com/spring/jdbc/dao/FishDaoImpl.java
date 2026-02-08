package com.spring.jdbc.dao;

import com.spring.jdbc.Entity.Fish;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.util.List;

public class FishDaoImpl implements FishDao{
    private JdbcTemplate jdbcTemplate;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }



    @Override
    public int addFish(Fish fish) {
        String insertQuery="insert into fish(fishId, fishName, fishType) values(?, ?, ?)";
        System.out.println("jdbcTemplate: "+jdbcTemplate);
        return this.jdbcTemplate.update(insertQuery,
                fish.getFishId(),
                fish.getFishName(),
                fish.getFishType());
    }

    @Override
    public int updateFish(Fish fish) {
        String updateQuery = "update fish set fishName=?, fishType=? where fishId=?";
        return jdbcTemplate.update(updateQuery,
                fish.getFishName(),
                fish.getFishType(),
                fish.getFishId());
    }

    @Override
    public int deleteFish(int fishId) {
        String deleteQuery = "delete from fish where fishId=?";
        return jdbcTemplate.update(deleteQuery, fishId);
    }

    @Override
    public Fish getFishById(int fishId) {
        String readQuery="select * from fish where fishId=?";
        RowMapper<Fish>rowMapper = new RowMapperImpl();
        Fish fish= jdbcTemplate.queryForObject(readQuery, rowMapper, fishId);
        return fish;
    }

    @Override
    public List<Fish> getAllFish() {
        String readQuery2="select * from fish";
        RowMapper<Fish> rowMapper= new RowMapperImpl();
        List<Fish> allFish=jdbcTemplate.query(readQuery2,rowMapper);
        return allFish;
    }

}
