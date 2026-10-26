package org.example;

public class Order {
    private String order_Number;
    private String customerName;
    private double totalAmount;
    private PaymentStatus status;
    private DeliveryMethod deliveryMethod;

    public Order(String order_Number, String customerName, double totalAmount, PaymentStatus status, DeliveryMethod deliveryMethod) {
        setOrder_Number(order_Number);
        setCustomerName(customerName);
        setTotalAmount(totalAmount);
        setStatus(status);
        setDeliveryMethod(deliveryMethod);
    }

    public String getOrder_Number() {
        return order_Number;
    }

    public void setOrder_Number(String order_Number) {
        if (order_Number != null && !order_Number.isEmpty()) {
            this.order_Number = order_Number;
        } else {
            throw new IllegalArgumentException("Order number cannot be empty");
        }
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        if (customerName != null && !customerName.isEmpty()) {
            this.customerName = customerName;
        } else {
            throw new IllegalArgumentException("Customer name cannot be empty");
        }
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        if (totalAmount > 0 ) {
            this.totalAmount = totalAmount;
        } else {
            throw new IllegalArgumentException("Invalid amount: R" + totalAmount);
        }
    }

    public PaymentStatus getStatus() {
        return status;
    }

    public void setStatus(PaymentStatus status) {
        if (status != null) {
            this.status = status;
        } else {
            throw new IllegalArgumentException("Status name cannot be empty");
        }
    }

    public DeliveryMethod getDeliveryMethod() {
        return deliveryMethod;
    }

    public void setDeliveryMethod(DeliveryMethod deliveryMethod) {
        if (deliveryMethod != null) {
            this.deliveryMethod = deliveryMethod;
        } else {
            throw new IllegalArgumentException("Delivery method cannot be empty");
        }
    }
}
