package org.example;

import java.math.BigDecimal;

public class Contractor extends PayableWorker {
    private final BigDecimal monthlyContractFee;

    public Contractor(String workerId, String fullName, BigDecimal monthlyContractFee) {
        super(workerId, fullName);
        if (monthlyContractFee == null || monthlyContractFee.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Monthly contract fee must be greater than zero.");
        }
        this.monthlyContractFee = formatCurrency(monthlyContractFee);
    }

    public BigDecimal getMonthlyContractFee() {
        return monthlyContractFee;
    }

    @Override
    public String getWorkerType() {
        return "Contractor";
    }

    @Override
    public BigDecimal calculateGrossPay() {
        return monthlyContractFee;
    }
}

