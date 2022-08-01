package com.example.myapplication11111;

import java.io.Serializable;

public class GalleryModelClass implements Serializable {
    String image;
    String title;
    Double price;


    GalleryModelClass(String image) {
        this.image = image;
    }
    public GalleryModelClass(){
    }
    public String getImage(){
        return image;

    }
    public String getTitle(){
        return title;
    }

    public Double getPrice() {
        return price;
    }
    public void setImage(String image){
        this.image=image;
    }
    public void setTitle(String title){
        this.title=title;
    }
    public void setPrice(Double price){
        this.price=price;
    }
}
