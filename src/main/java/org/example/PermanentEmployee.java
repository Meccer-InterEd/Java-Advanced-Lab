package org.example;

import java.math.BigDecimal;

public class PermanentEmployee extends PayableWorker {
    private final BigDecimal monthlySalary;

    public PermanentEmployee(String workerId, String fullName, BigDecimal monthlySalary) {
        super(workerId, fullName);
        if (monthlySalary == null || monthlySalary.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Monthly salary must be greater than zero.");
        }
        this.monthlySalary = formatCurrency(monthlySalary);
    }

    public BigDecimal getMonthlySalary() {
        return monthlySalary;
    }

    @Override
    public String getWorkerType() {
        return "Permanent Employee";
    }

    @Override
    public BigDecimal calculateGrossPay() {
        return monthlySalary;
    }
}
