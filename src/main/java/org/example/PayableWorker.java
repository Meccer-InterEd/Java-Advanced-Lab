package org.example;

import java.math.BigDecimal;
import java.math.RoundingMode;

public abstract class PayableWorker {
    private String workerId;
    private String fullName;

    public PayableWorker(String workerId, String fullName) {
        setWorkerId(workerId);
        setFullName(fullName);
    }

    public String getWorkerId() {
        return workerId;
    }

    public void setWorkerId(String workerId) {
        if (workerId == null || workerId.trim().isEmpty()) {
            throw new IllegalArgumentException("Worker ID cannot be null or empty.");
        }
        this.workerId = workerId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        if (fullName == null || fullName.trim().isEmpty()) {
            throw new IllegalArgumentException("Full name cannot be null or empty.");
        }
        this.fullName = fullName;
    }

    public abstract String getWorkerType();

    public abstract BigDecimal calculateGrossPay();

    protected BigDecimal formatCurrency(BigDecimal amount) {
        return amount.setScale(2, RoundingMode.HALF_UP);
    }
}
