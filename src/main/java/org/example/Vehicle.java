package org.example;

import java.math.BigDecimal;

public abstract class Vehicle {
    private String registrationNumber;
    private String brand;
    private BigDecimal rate;

    public Vehicle(String registrationNumber, String brand, BigDecimal rate) {
        this.registrationNumber = registrationNumber;
        this.brand = brand;
        this.rate = rate;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public String getBrand() {
        return brand;
    }

    public BigDecimal getRate() {
        return rate;
    }

    public abstract BigDecimal calculateRentalCost(int days);

    public void displayDetails() {
        System.out.println("Registration: " + registrationNumber);
        System.out.println("Brand: " + brand);
        System.out.println("Daily Rate: R" + rate);
    }
}
