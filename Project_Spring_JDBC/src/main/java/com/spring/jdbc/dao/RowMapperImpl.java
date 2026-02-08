package com.spring.jdbc.dao;

import com.spring.jdbc.Entity.Fish;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RowMapperImpl implements RowMapper {
    @Override
    public Fish mapRow(ResultSet rs, int rowNum) throws SQLException {
        Fish fish= new Fish();
        fish.setFishId(rs.getInt(1));
        fish.setFishName(rs.getString(2));
        fish.setFishType(rs.getString(3));
return fish;

    }
}
