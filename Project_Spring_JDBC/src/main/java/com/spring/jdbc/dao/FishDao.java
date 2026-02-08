package com.spring.jdbc.dao;

import com.spring.jdbc.Entity.Fish;

import java.util.List;

public interface FishDao {
    public int addFish(Fish fish);
    public int updateFish(Fish fish);
    public int deleteFish(int fishId);
    public Fish getFishById(int fishId);
    List<Fish> getAllFish();
}
