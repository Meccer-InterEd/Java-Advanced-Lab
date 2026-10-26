package org.example;

import java.math.BigDecimal;

public enum DeliveryMethod {
    COLLECTION,
    STANDARD_DELIVERY,
    EXPRESS_DELIVERY;

    public BigDecimal getDeliveryFee(){
        if (this == COLLECTION){
            return new BigDecimal("0.00");
        } else if (this == STANDARD_DELIVERY){
            return  new BigDecimal("35.00");
        }
        return new BigDecimal("65.00");
    }
}
