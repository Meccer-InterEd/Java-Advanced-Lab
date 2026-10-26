package org.example;

public class Order {
    private String order_Number;
    private String customerName;
    private double totalAmount;
    private String status;
    private String deliveryMethod;

    public Order(String order_Number, String customerName, double totalAmount, String status, String deliveryMethod) {
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        if (status != null && !status.isEmpty()) {
            this.status = status;
        } else {
            throw new IllegalArgumentException("Status name cannot be empty");
        }
    }

    public String getDeliveryMethod() {
        return deliveryMethod;
    }

    public void setDeliveryMethod(String deliveryMethod) {
        if (deliveryMethod != null && !deliveryMethod.isEmpty()) {
            this.deliveryMethod = deliveryMethod;
        } else {
            throw new IllegalArgumentException("Delivery method cannot be empty");
        }
    }
}
