package org.example.PaymentSystem;

import java.math.BigDecimal;

public class Voucher implements PaymentMethod{
    String voucherID;
    String voucherCode;
    BigDecimal balance;

    Voucher(String voucherID, String voucherCode,BigDecimal balance){
        this.voucherID = voucherID;
        this.voucherCode=voucherCode;
        this.balance = balance;

    }


    @Override
    public PaymentResult pay(BigDecimal amount) {

        if(this.balance.doubleValue() < amount.doubleValue() || this.balance.compareTo(amount) < 0 ){
           return  new PaymentResult(false,this.voucherCode,"Payment failed");

        }else{
            this.balance = BigDecimal.valueOf(this.balance.doubleValue() - amount.doubleValue());
        return new PaymentResult(true,this.voucherID,"Payment successful");
    }

    }

    @Override
    public String getDisplayName() {
        return "";
    }
}
