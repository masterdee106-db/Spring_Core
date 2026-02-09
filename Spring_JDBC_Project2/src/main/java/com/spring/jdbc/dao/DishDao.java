package com.spring.jdbc.dao;

import com.spring.jdbc.entity.Dish;

import java.util.List;

public interface DishDao {
    int addDish(Dish dish);
    int updateDishPrice(int dishId, double price);
    int deleteDish(int dishId);
    Dish getDishById(int dishId);
    List<Dish> getAllDish();
}
