package org.example.food_delivery;

import java.math.BigDecimal;

public enum DeliveryMethod {
    COLLECTION,
    STANDARD_DELIVERY,
    EXPRESS_DELIVERY;

    public BigDecimal deliveryFee(){
        switch (this){
            case EXPRESS_DELIVERY:
                return new BigDecimal("65");

            case STANDARD_DELIVERY:
                return new BigDecimal("35.00");
            default:
                return new BigDecimal("0");
        }
    }
}
