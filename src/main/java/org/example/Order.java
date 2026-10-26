package org.example;

public class Order {
    private String orderNumber;
    private String customerName;
    private double totalAmount;
    private PaymentStatus status;
    private DeliveryMethod deliveryMethod;

    public Order(String orderNumber, String customerName, double totalAmount, PaymentStatus status, DeliveryMethod deliveryMethod) {
        setOrderNumber(orderNumber);
        setCustomerName(customerName);
        setTotalAmount(totalAmount);
        setStatus(status);
        setDeliveryMethod(deliveryMethod);

    }

    public String getOrderNumber() {return orderNumber;}
    public String getCustomerName() {return customerName;}
    public double getTotalAmount() {return totalAmount;}
    public PaymentStatus getStatus() {return status;}
    public DeliveryMethod getDeliveryMethod() {return deliveryMethod;}

    public void setOrderNumber(String orderNumber) {
        if(orderNumber != null && !orderNumber.isEmpty()) {
            this.orderNumber = orderNumber;
        } else {
            throw new IllegalArgumentException("Order number can not be empty");
        }
    }

    public void setCustomerName(String customerName) {
        if(customerName != null && !customerName.isEmpty()) {
            this.customerName = customerName;
        } else {
            throw new IllegalArgumentException("Customer name can not be empty");
        }
    }


    public void setTotalAmount(double totalAmount) {
        if (totalAmount > 0) {
            this.totalAmount = totalAmount;
        } else {
            throw new IllegalArgumentException("Invalid amount: R" + totalAmount);
        }
    }

    public void setStatus(PaymentStatus status) {
        if(status != null) {
            this.status = status;
        } else {
            throw new IllegalArgumentException("Status can not be empty");
        }

    }

    public void setDeliveryMethod(DeliveryMethod deliveryMethod) {
        if(status != null) {
            this.deliveryMethod = deliveryMethod;
        } else {
            throw new IllegalArgumentException(" Delivery method can not be empty");
        }
    }

}
