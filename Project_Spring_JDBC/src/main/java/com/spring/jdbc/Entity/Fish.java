package com.spring.jdbc.Entity;

public class Fish {
    private int fishId;
    private String fishName;
    private String fishType;

    public Fish(int fishId, String fishName, String fishType) {
        this.fishId = fishId;
        this.fishName = fishName;
        this.fishType = fishType;
    }

    public int getFishId() {
        return fishId;
    }

    public void setFishId(int fishId) {
        this.fishId = fishId;
    }

    public String getFishName() {
        return fishName;
    }

    public void setFishName(String fishName) {
        this.fishName = fishName;
    }

    public String getFishType() {
        return fishType;
    }

    public void setFishType(String fishType) {
        this.fishType = fishType;
    }

    public Fish(){
        super();
    }

    @Override
    public String toString() {
        return "Fish{" +
                "fishId=" + fishId +
                ", fishName='" + fishName + '\'' +
                ", fishType='" + fishType + '\'' +
                '}';
    }
}
