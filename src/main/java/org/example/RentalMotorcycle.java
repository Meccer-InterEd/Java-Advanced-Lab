package org.example;

import java.math.BigDecimal;

public class RentalMotorcycle extends Vehicle{

    private BigDecimal safetyEquipmentCharge = new BigDecimal("45");

    public RentalMotorcycle(String registrationNumber, String brand, BigDecimal rate, BigDecimal safetyEquipmentCharge) {
        super(registrationNumber, brand, rate);

    }

    @Override
    public BigDecimal calculateRentalCost(int days) {
        if (days < 1) {
            throw new IllegalArgumentException("Rental period must be at least one day");
        }

        BigDecimal baseCost = getRate().multiply(BigDecimal.valueOf(days));

        BigDecimal safetyCharge = safetyEquipmentCharge.multiply(BigDecimal.valueOf(days));

        if (days >= 7) {
            baseCost = baseCost.multiply(new BigDecimal("0.90"));
        }

        return baseCost.add(safetyCharge);
    }
}
