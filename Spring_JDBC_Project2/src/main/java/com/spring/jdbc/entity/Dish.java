package com.spring.jdbc.entity;

public class Dish {
    private int dishId;
    private String dishName;
    private String dishType;
    private double price;

    public Dish(){
        super();
    }

    public int getDishId() {
        return dishId;
    }

    public void setDishId(int dishId) {
        this.dishId = dishId;
    }

    public String getDishName() {
        return dishName;
    }

    public void setDishName(String dishName) {
        this.dishName = dishName;
    }

    public String getDishType() {
        return dishType;
    }

    public void setDishType(String dishType) {
        this.dishType = dishType;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Dish(int dishId, String dishName, String dishType, double price) {
        this.dishId = dishId;
        this.dishName = dishName;
        this.dishType = dishType;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Dish{" +
                "dishId=" + dishId +
                ", dishName='" + dishName + '\'' +
                ", dishType='" + dishType + '\'' +
                ", price=" + price +
                '}';
    }
}
