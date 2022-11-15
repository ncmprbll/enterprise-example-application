package org.example.models;

public class CoffeeMachine {
    private Integer id;
    private String brand;
    private String model;
    private String countryOfOrigin;
    private Double price;

    public CoffeeMachine(Integer id, String brand, String model, String countryOfOrigin, Double price) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.countryOfOrigin = countryOfOrigin;
        this.price = price;
    }

    public CoffeeMachine() {}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getCountryOfOrigin() {
        return countryOfOrigin;
    }

    public void setCountryOfOrigin(String countryOfOrigin) {
        this.countryOfOrigin = countryOfOrigin;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "CoffeeMachine{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", countryOfOrigin='" + countryOfOrigin + '\'' +
                ", price=" + price +
                '}';
    }
}
