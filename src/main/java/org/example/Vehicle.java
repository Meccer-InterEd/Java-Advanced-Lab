package org.example;

import java.math.BigDecimal;
import java.math.RoundingMode;

public abstract class Vehicle {
    private String regNumber;
    private String brand;
    private BigDecimal dailyRate;

    public Vehicle(String regNumber, String brand, BigDecimal dailyRate) {
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

    public BigDecimal getDailyRate() {
        return dailyRate;
    }

    public void setDailyRate(BigDecimal dailyRate) {
        if (dailyRate.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Daily rate cannot be zero or less");
        }
        this.dailyRate = dailyRate;
    }

    void validateRentalDays(int days) {
        if (days < 1) {
            throw new IllegalArgumentException("Rental period must be at least 1 day.");
        }
    }

    protected BigDecimal calculateDiscountedBaseCost(int days) {
        validateRentalDays(days);
        BigDecimal rentalDays = BigDecimal.valueOf(days);
        BigDecimal baseCost = dailyRate.multiply(rentalDays);

        if (days >= 7) {
            BigDecimal discountRate = new BigDecimal("0.10");
            BigDecimal discount = baseCost.multiply(discountRate);
            baseCost = baseCost.subtract(discount);
        }

        return baseCost.setScale(2, RoundingMode.HALF_UP);
    }

    public abstract BigDecimal calculateRentalCost(int days);

    public void displayDetails() {
        System.out.println("Registration Number: " + regNumber);
        System.out.println("Brand: " + brand);
        System.out.println("Daily Rate: R" + dailyRate);
    }
}
