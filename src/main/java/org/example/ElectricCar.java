package org.example;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class ElectricCar extends Vehicle {
    private static final BigDecimal DAILY_INSURANCE_CHARGE = new BigDecimal("120.00");
    private static final BigDecimal DAILY_CHARGING_FEE = new BigDecimal("65.00");

    public ElectricCar(String regNumber, String brand, BigDecimal dailyRate) {
        super(regNumber, brand, dailyRate);
    }

    @Override
    public BigDecimal calculateRentalCost(int days) {
        BigDecimal discountedBase = calculateDiscountedBaseCost(days);
        BigDecimal rentalDays = BigDecimal.valueOf(days);

        BigDecimal totalInsurance = DAILY_INSURANCE_CHARGE.multiply(rentalDays);
        BigDecimal totalCharging = DAILY_CHARGING_FEE.multiply(rentalDays);

        return discountedBase.add(totalInsurance).add(totalCharging).setScale(2, RoundingMode.HALF_UP);
    }

    @Override
    public void displayDetails() {
        System.out.println("----- Electric Car -----");
        super.displayDetails();
        System.out.println("Daily Insurance Charge: R" + DAILY_INSURANCE_CHARGE);
        System.out.println("Daily Charging Fee: R" + DAILY_CHARGING_FEE);
    }
}

