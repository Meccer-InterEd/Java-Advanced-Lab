package org.example;

import java.math.BigDecimal;

public class InstantEftPayment implements PaymentMethod{
    private BigDecimal accountBalance;
    private String accountHolder;
    private StringBuilder reference;
    private static int paymentNum = 0;

    public InstantEftPayment(String holder, BigDecimal balance){
        accountBalance = balance;
        accountHolder = holder;
    }

    @Override
    public PaymentResult pay(BigDecimal amount){
        if (isAmountValid(amount)){
            if (accountBalance.compareTo(amount) >= 0){
                accountBalance = accountBalance.subtract(amount);
                InstantEftPayment.paymentNum += 1;
                reference = new StringBuilder("EFT").append("-").append(accountHolder.replace(" ","_")).append("-").append(paymentNum);
                return new PaymentResult(true,reference.toString(),"Ref: "+reference+" | Successfully made an EFT payment R"+amount+" | Current balance: R"+accountBalance);
            }
            System.out.println("\nEFT payment unsuccessful! account balance is insufficient.");
        }
        return new PaymentResult(false,"EFT-Failed","Failed to make an EFT payment of R"+amount);
    }

    @Override
    public String getDisplayName() {
        return "Payment Type: Instant EFT\nAccount Holder: "+accountHolder+"\nReference: "+reference;
    }
}
