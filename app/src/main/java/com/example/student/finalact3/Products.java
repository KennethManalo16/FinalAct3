package com.example.student.finalact3;

public class Products {
    private String name, price,discount, image;

    public String getName() {
        return name;
    }

    public Products(String name, String price, String discount, String image) {
        this.name = name;
        this.price = price;
        this.discount = discount;
        this.image = image;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Products() {

    }
}
