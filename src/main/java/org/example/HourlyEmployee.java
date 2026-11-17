package org.example;

import java.math.BigDecimal;

public class HourlyEmployee extends PayableWorker {
    private final BigDecimal hourlyRate;
    private final BigDecimal approvedHours;

    public HourlyEmployee(String workerId, String fullName, BigDecimal hourlyRate, BigDecimal approvedHours) {
        super(workerId, fullName);
        if (hourlyRate == null || hourlyRate.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Hourly rate must be greater than zero.");
        }
        if (approvedHours == null || approvedHours.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Approved hours cannot be negative.");
        }
        this.hourlyRate = formatCurrency(hourlyRate);
        this.approvedHours = approvedHours;
    }

    public BigDecimal getHourlyRate() {
        return hourlyRate;
    }

    public BigDecimal getApprovedHours() {
        return approvedHours;
    }

    @Override
    public String getWorkerType() {
        return "Hourly Worker";
    }

    @Override
    public BigDecimal calculateGrossPay() {
        return formatCurrency(hourlyRate.multiply(approvedHours));
    }
}

