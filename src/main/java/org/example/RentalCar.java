package org.example;

import java.math.BigDecimal;

public class RentalCar extends Vehicle {

    private BigDecimal insuranceCharge = new BigDecimal("120");

    public RentalCar(String registrationNumber, String brand, BigDecimal rate) {
        super(registrationNumber, brand, rate);
    }

    @Override
    public BigDecimal calculateRentalCost(int days) {
        if (days < 1) {
            throw new IllegalArgumentException("Rental period must be at least one day");
        }

        BigDecimal baseCost = getRate().multiply(BigDecimal.valueOf(days));

        BigDecimal insurance = insuranceCharge.multiply(BigDecimal.valueOf(days));

        if (days >= 7) {
            baseCost = baseCost.multiply(new BigDecimal("0.90"));
        }

        return baseCost.add(insurance);
    }
}
