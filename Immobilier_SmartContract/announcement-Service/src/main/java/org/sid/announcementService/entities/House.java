package org.sid.announcementService.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "announce")
public class House {
    @Id
    private String id;
    private String location;
    private String title;
    private String HouseTitle;
    private Double cost;
    private String image;
    private String description;
    private String ownerAddress;
    private boolean validation;
    private boolean isValidate;
    private  boolean toPublish;
    private  boolean isRejected;



    public House() {
    }

    public House(String id, String location, String title, String houseTitle, Double cost, String image, String description, String ownerAddress, boolean validation, boolean isValidate,boolean toPublish,boolean IsRejected) {
        this.id = id;
        this.location = location;
        this.title = title;
        HouseTitle = houseTitle;
        this.cost = cost;
        this.image = image;
        this.description = description;
        this.ownerAddress = ownerAddress;
        this.validation = validation;
        this.isValidate = isValidate;
        this.toPublish=toPublish;
        this.isRejected=IsRejected;
    }

    public boolean isToPublish() {
        return toPublish;
    }

    public boolean isRejected() {
        return isRejected;
    }

    public void setRejected(boolean rejected) {
        isRejected = rejected;
    }

    public void setToPublish(boolean toPublish) {
        this.toPublish = toPublish;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isValidation() {
        return validation;
    }

    public void setValidation(boolean validation) {
        this.validation = validation;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getHouseTitle() {
        return HouseTitle;
    }

    public void setHouseTitle(String houseTitle) {
        HouseTitle = houseTitle;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getOwnerAddress() {
        return ownerAddress;
    }

    public void setOwnerAddress(String ownerAddress) {
        this.ownerAddress = ownerAddress;
    }

    public boolean getIsValidate() {
        return isValidate;
    }

    public void setIsValidate(boolean isValidate) {
        this.isValidate = isValidate;
    }
}
