package org.example;

import java.math.BigDecimal;

public enum DeliveryMethod {
    COLLECTION,
    STANDARD_DELIVERY,
    EXPRESS_DELIVERY;

    public BigDecimal getDeliveryFee(){
        switch (this){
            case COLLECTION -> {
                return new BigDecimal("0.00");
            }
            case STANDARD_DELIVERY -> {
                return new BigDecimal("35.00");
            }
            default -> {
                return new BigDecimal("65.00");
            }
        }
    }
}
