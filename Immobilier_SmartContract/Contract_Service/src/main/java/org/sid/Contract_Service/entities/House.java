package org.sid.Contract_Service.entities;

public class House {

    private String ownerAddress;
    private String location;
    private Double cost;
    private int HouseID;


    public House() {
    }

    public House(String ownerAddress, String location, Double cost, int houseID) {
        this.ownerAddress = ownerAddress;
        this.location = location;
        this.cost = cost;
        HouseID = houseID;
    }

    public String getOwnerAddress() {
        return ownerAddress;
    }

    public void setOwnerAddress(String ownerAddress) {
        this.ownerAddress = ownerAddress;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public int getHouseID() {
        return HouseID;
    }

    public void setHouseID(int houseID) {
        HouseID = houseID;
    }
}
