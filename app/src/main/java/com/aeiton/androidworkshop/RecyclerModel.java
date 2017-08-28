package com.aeiton.androidworkshop;

/**
 * Created by User on 07-Feb-17.
 */

public class RecyclerModel {

    int imageId;
    String name, price;

    RecyclerModel(int imageId, String name, String price){
        this.imageId = imageId;
        this.name = name;
        this.price = price;
    }

    public int getImageId() {
        return imageId;
    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }
}
