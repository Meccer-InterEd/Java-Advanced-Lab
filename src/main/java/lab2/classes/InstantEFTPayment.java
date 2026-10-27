package lab2.classes;

import lab2.interfaces.PaymentMethod;
import lab2.records.PaymentResult;

public class InstantEFTPayment implements PaymentMethod {

    private String bank;


    public InstantEFTPayment() {

        bank = "No bank";

    }

    public InstantEFTPayment(String bank) {
        this.bank = bank;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    @Override
    public PaymentResult pay(double amount) {

        if( bank == null || bank.isBlank())
        {
            return new PaymentResult(false,"Card Payment","Invalid Bank");

        }
        return new PaymentResult(true,"Card Payment","Valid Bank");

    }

    @Override
    public String displayName() {
        return "InstantEFT";
    }
}
