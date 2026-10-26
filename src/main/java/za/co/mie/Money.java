package za.co.mie;

import java.math.BigDecimal;

public class Money {
    public static BigDecimal of(String price){
        return new BigDecimal(price);
    }
}
