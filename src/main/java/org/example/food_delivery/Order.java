package org.example.food_delivery;

import java.math.BigDecimal;

public class Order {
    private final String orderNumber;
    private final String customerName;
    private BigDecimal totalAmount;
    private OrderStatus status;
    private PaymentStatus paymentstatus;
    private final DeliveryMethod deliveryMethod;
    private boolean isValid;

    public Order(String orderNumber, String customerName, BigDecimal totalAmount, DeliveryMethod deliveryMethod) {
        this.orderNumber = orderNumber;
        this.customerName = customerName;
        setAmount(totalAmount);
        this.deliveryMethod = deliveryMethod;
        this.status = OrderStatus.PLACED;
        this.paymentstatus = PaymentStatus.PENDING;
    }

    public void displayDetails(){
        System.out.println(orderNumber);
        System.out.println("Customer Name " + customerName);
        System.out.println(deliveryMethod + ": R" + deliveryMethod.deliveryFee());
        System.out.println("Amount due: " + totalAmount);
        System.out.println("Payment status: " + paymentstatus + ", Order status: " + status);
    }

    public BigDecimal getAmount() {
        return totalAmount;
    }

    public void setAmount(BigDecimal amount) {
        if (amount.compareTo(BigDecimal.ZERO) > 0) {
            this.totalAmount = amount;
        }
        else {
            System.out.println("Invalid amount");
        }
    }

    public DeliveryMethod getDeliveryMethod() {
        return deliveryMethod;
    }

    public void pay(BigDecimal amount) {
        totalAmount = this.totalAmount.add(this.getDeliveryMethod().deliveryFee());
        if (amount.compareTo(totalAmount) >= 0) {
            this.paymentstatus = PaymentStatus.PAID;
            this.status = OrderStatus.CONFIRMED;
        } else {
            this.paymentstatus = PaymentStatus.FAILED;
        }
        setValid();
    }

    public void setValid() {
        isValid = this.paymentstatus.equals(PaymentStatus.PAID) && this.status.equals(OrderStatus.CONFIRMED);
    }

    public void updateStatus() {
        if (!isValid) {
            this.status = OrderStatus.CANCELLED;
            System.out.println("Order " + orderNumber + " " + status);
            return;
        }

        switch (status) {
            case CONFIRMED:
                this.status = OrderStatus.PREPARING;
                break;

            case PREPARING:
                switch (deliveryMethod) {
                    case STANDARD_DELIVERY, EXPRESS_DELIVERY:
                        this.status = OrderStatus.OUT_FOR_DELIVERY;
                        break;

                    case COLLECTION:
                        this.status = OrderStatus.READY_FOR_COLLECTION;
                        break;
                }
                break;

            case OUT_FOR_DELIVERY:
            case READY_FOR_COLLECTION:
                this.status = OrderStatus.DELIVERED;
                break;

            case CANCELLED:
                System.out.println("Order cancelled");
                return;

            case DELIVERED:
                System.out.println("Order already delivered");
                return;
        }
        System.out.println("Order status: " + status);
    }



    public void cancelOrder() {
        if (this.status.equals(OrderStatus.OUT_FOR_DELIVERY) || this.status.equals(OrderStatus.READY_FOR_COLLECTION ) || this.status.equals(OrderStatus.DELIVERED)) {
            System.out.println("Order can't be cancelled");
        } else {
            this.status = OrderStatus.CANCELLED;
            System.out.println("Order cancelled");
        }
    }
}
