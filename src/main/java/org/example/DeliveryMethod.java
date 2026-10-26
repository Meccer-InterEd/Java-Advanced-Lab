package org.example;
import java.math.BigDecimal;

public enum DeliveryMethod {
    COLLECTION("0.00"),
    STANDARD_DELIVERY("35.00"),
    EXPRESS_DELIVERY("65.00");

    DeliveryMethod(String description){


    }

    public BigDecimal getDeliveryFee(){
        if (this == COLLECTION){
            return new BigDecimal("0.00");
        } else if (this == STANDARD_DELIVERY) {
            return  new BigDecimal("35.00");
        }
        else {
            return new BigDecimal("65.00");
        }
    }
}
