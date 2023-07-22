package com.tekup.RestApi.Model;

import io.swagger.annotations.ApiModelProperty;

public class Item {

    @ApiModelProperty(notes = "Name of the Item", name = "name", required = true)
    private String name;

    @ApiModelProperty(notes = "Description of the Item", name = "description", required = true)
    private String description;

    @ApiModelProperty(notes = "Price of the Item", name = "price", required = true)
    private float price;

    public String getName() {
        return name;
    }

    public void setName(String Name) {
        this.name = Name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String Description) {
        this.description = Description;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float Price) {
        this.price = Price;
    }
}
