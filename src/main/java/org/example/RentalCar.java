package org.example;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class RentalCar extends Vehicle{
    private static final BigDecimal DAILY_INSURANCE_CHARGE = new BigDecimal("120.00");

    public RentalCar(String regNumber, String brand, BigDecimal dailyRate) {
        super(regNumber, brand, dailyRate);
    }

    @Override
    public BigDecimal calculateRentalCost(int days) {
        BigDecimal discountedBase = calculateDiscountedBaseCost(days);
        BigDecimal totalInsurance = DAILY_INSURANCE_CHARGE.multiply(BigDecimal.valueOf(days));

        return discountedBase.add(totalInsurance).setScale(2, RoundingMode.HALF_UP);
    }

    @Override
    public void displayDetails() {
        System.out.println("----- Rental Car -----");
        super.displayDetails();
        System.out.println("Daily Insurance Charge: R" + DAILY_INSURANCE_CHARGE);
    }
}
