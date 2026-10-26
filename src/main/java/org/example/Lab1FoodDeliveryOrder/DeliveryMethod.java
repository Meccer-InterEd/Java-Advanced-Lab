package org.example.Lab1FoodDeliveryOrder;

import java.math.BigDecimal;

public enum DeliveryMethod {
    COLLECTION, STANDARD_DELIVERY, EXPRESS_DELIVERY;

    public BigDecimal determineDeliveryFee(DeliveryMethod m){
        switch (m){
            case COLLECTION -> {
                return new BigDecimal(0);
            }
            case STANDARD_DELIVERY -> {
                return new BigDecimal(35);
            }
            default -> {
                return new BigDecimal(65);
            }
        }
    }
}




