package org.example;

public abstract class Vehicle {
    private String regNumber;
    private String brand;
    private double dailyRate;

    public Vehicle(String regNumber, String brand, double dailyRate) {
        setRegNumber(regNumber);
        setBrand(brand);
        setDailyRate(dailyRate);
    }

    public String getRegNumber() {
        return regNumber;
    }

    public void setRegNumber(String regNumber) {
        if (regNumber == null || regNumber.trim().isEmpty()) {
            throw new IllegalArgumentException("Registration number cannot be null or empty");
        }
        this.regNumber = regNumber;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        if (brand == null || brand.trim().isEmpty()) {
            throw new IllegalArgumentException("Brand cannot be null or empty.");
        }
        this.brand = brand.trim();
    }

    public double getDailyRate() {
        return dailyRate;
    }

    public void setDailyRate(double dailyRate) {
        if (dailyRate <= 0) {
            throw new IllegalArgumentException("Daily rate cannot be zero or less");
        }
        this.dailyRate = dailyRate;
    }
}
