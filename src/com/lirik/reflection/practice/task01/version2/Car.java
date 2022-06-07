package com.lirik.reflection.practice.task01.version2;

/**
 * Чтобы не указывать name = "car", достаточно в аннотации Table сделать не метод String name(), а метод String values();
 * Тогда можно просто писать "car". Но такой метод может быть только ОДИН!!!
 * Если метод помечен словом default, то в случае если в аннотации мы не указываем значение, то его значение приходит по дефолту!!!
 */

@Table(name = "car")
public class Car {

    @Column(name = "brand")
    private String brand;

    @Column(name = "model")
    private String model;

    public Car(String brand, String model) {
        this.brand = brand;
        this.model = model;
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

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                '}';
    }
}
