package com.spring.jdbc.dao;

import com.spring.jdbc.entity.Dish;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class DishDaoImpl implements DishDao{
    private JdbcTemplate jdbcTemplate;
    public DishDaoImpl(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate=jdbcTemplate;
    }

    private RowMapper<Dish> rowMapper = new RowMapper<Dish>() {
        @Override
        public Dish mapRow(ResultSet rs, int rowNum) throws SQLException {
            Dish dish = new Dish();
            dish.setDishId(rs.getInt("dishId"));
            dish.setDishName(rs.getString("dishName"));
            dish.setDishType(rs.getString("dishType"));
            dish.setPrice(rs.getDouble("price"));
            return dish;
        }
    };

    @Override
    public int addDish(Dish dish) {
        String insertQuery = "insert into dish(dishName, dishType, price) values(?, ?, ?)";
        int result = jdbcTemplate.update(insertQuery,
                dish.getDishName(),
                dish.getDishType(),
                dish.getPrice());
        return result;
    }

    @Override
    public int updateDishPrice(int dishId, double price) {
        String updateQuery = "update dish set price=? where dishId=?";
        int result = jdbcTemplate.update(updateQuery, price, dishId);
        return result;
    }

    @Override
    public int deleteDish(int dishId) {
        String deleteQuery = "delete from dish where dishId=?";
        int result = jdbcTemplate.update(deleteQuery, dishId);
        return result;
    }

    @Override
    public Dish getDishById(int dishId) {
        String getDishQuery = "select * from dish where dishId=?";
        Dish dish = jdbcTemplate.queryForObject(getDishQuery, rowMapper, dishId);
        return dish;
    }

    @Override
    public List<Dish> getAllDish() {
        String getDishesQuery = "select * from dish";
        List<Dish> getAllDish = jdbcTemplate.query(getDishesQuery, rowMapper);
        return getAllDish;
    }
}
