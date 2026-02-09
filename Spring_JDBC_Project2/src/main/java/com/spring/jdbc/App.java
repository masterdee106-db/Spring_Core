package com.spring.jdbc;


import com.spring.jdbc.config.DishConfig;
import com.spring.jdbc.dao.DishDao;
import com.spring.jdbc.entity.Dish;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class App
{
    public static void main( String[] args )
    {

        System.out.println("Program Started....");

//        Load Spring Container using java based configuration
        ApplicationContext context=new AnnotationConfigApplicationContext(DishConfig.class);
//        Get Dao bean
        DishDao dishDao = context.getBean(DishDao.class);

//        ----------------INSERT DISH----------------//

//        Dish dish = new Dish();
//        dish.setDishName("Chilli Chicken");
//        dish.setDishType("Non-Veg");
//        dish.setPrice(250.00);
//
//        dishDao.addDish(dish);
//        System.out.println("Dish inserted successfully...");

//        ------------GET BY ID -------------------//

//        Dish fetchDish = dishDao.getDishById(2);
//        System.out.println(fetchDish.getDishId()+" | "+
//                fetchDish.getDishName() +" | "+
//                fetchDish.getDishType() + " | "+
//                fetchDish.getPrice());

//        -----------GET ALL DISH------------//

//        List<Dish> dishes=dishDao.getAllDish();
//        System.out.println("\nAll Dishes:");
//        for (Dish d: dishes){
//            System.out.println(d.getDishId()+" | "+
//                    d.getDishName()+" | "+
//                    d.getDishType()+" | "+
//                    d.getPrice());
//        }

//        --------------UPDATE-----------------//

//        dishDao.updateDishPrice(2,300.00);
//        System.out.println("\nDish price updated.....");

//        ---------------DELETE-----------------//

        dishDao.deleteDish(3);
        System.out.println("Dish Deleted...");

//
    }
}
