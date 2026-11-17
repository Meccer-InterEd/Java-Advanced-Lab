package org.example;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class RentalMotorcycle extends Vehicle{
    private static final BigDecimal DAILY_SAFETY_GEAR_CHARGE = new BigDecimal("45.00");

    public RentalMotorcycle(String regNumber, String brand, BigDecimal dailyRate) {
        super(regNumber, brand, dailyRate);
    }

    @Override
    public BigDecimal calculateRentalCost(int days) {
        BigDecimal discountedBase = calculateDiscountedBaseCost(days);
        BigDecimal totalSafetyCharge = DAILY_SAFETY_GEAR_CHARGE.multiply(BigDecimal.valueOf(days));

        return discountedBase.add(totalSafetyCharge).setScale(2, RoundingMode.HALF_UP);
    }

    @Override
    public void displayDetails() {
        System.out.println("----- Rental Motorcycle -----");
        super.displayDetails();
        System.out.println("Daily Safety Equipment Charge: R" + DAILY_SAFETY_GEAR_CHARGE);
    }
}
