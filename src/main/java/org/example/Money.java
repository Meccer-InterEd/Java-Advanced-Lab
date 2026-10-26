package org.example;

import java.math.BigDecimal;

public class Money {
    public static BigDecimal of(String amount){
        return new BigDecimal(amount);
    }
}
