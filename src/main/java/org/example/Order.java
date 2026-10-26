package org.example;

import static org.example.OrderStatus.CANCELLED;
import static org.example.OrderStatus.CONFIRMED;
import static org.example.PaymentStatus.*;
import static org.example.PaymentStatus.PAID;

public class Order {
    private String orderNumber;
    private String customerName;
    private double totalAmount;
    private PaymentStatus status;
    private DeliveryMethod deliveryMethod;
    private OrderStatus orderStatus;

    public Order(String orderNumber, String customerName, double totalAmount, PaymentStatus status, DeliveryMethod deliveryMethod) {
        setOrderNumber(orderNumber);
        setCustomerName(customerName);
        setTotalAmount(totalAmount);
        setStatus(status);
        setDeliveryMethod(deliveryMethod);
        this.orderStatus = OrderStatus.PLACED;

    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public String getCustomerName() {
        return customerName;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public PaymentStatus getStatus() {
        return status;
    }

    public DeliveryMethod getDeliveryMethod() {
        return deliveryMethod;
    }

    public void setOrderNumber(String orderNumber) {
        if (orderNumber != null && !orderNumber.isEmpty()) {
            this.orderNumber = orderNumber;
        } else {
            throw new IllegalArgumentException("Order number can not be empty");
        }
    }

    public void setCustomerName(String customerName) {
        if (customerName != null && !customerName.isEmpty()) {
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
        if (status != null) {
            this.status = status;
        } else {
            throw new IllegalArgumentException("Status can not be empty");
        }

    }

    public void setDeliveryMethod(DeliveryMethod deliveryMethod) {
        if (status != null) {
            this.deliveryMethod = deliveryMethod;
        } else {
            throw new IllegalArgumentException(" Delivery method can not be empty");
        }
    }


    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void nextStatus(OrderStatus targetStatus) {
        switch (this.orderStatus) {
            case PLACED:
                if (targetStatus == OrderStatus.CONFIRMED || targetStatus == OrderStatus.CANCELLED) {
                    this.orderStatus = targetStatus;
                    return;
                }
                break;
            case CONFIRMED:
                if (targetStatus == OrderStatus.PREPARING || targetStatus == OrderStatus.CANCELLED) {
                    this.orderStatus = targetStatus;
                    return;
                }
                break;
            case PREPARING:
                if (targetStatus == OrderStatus.IN_PROGRESS ||
                        targetStatus == OrderStatus.READY_FOR_COLLECTION || targetStatus == OrderStatus.OUT_FOR_DELIVERY) {
                    this.orderStatus = targetStatus;
                    return;
                }
                break;
            case IN_PROGRESS:
            case READY_FOR_COLLECTION:
            case OUT_FOR_DELIVERY:
                if (targetStatus == OrderStatus.DELIVERED) {
                    this.orderStatus = targetStatus;
                    return;
                }
                break;
            case DELIVERED:
                if (targetStatus == OrderStatus.RETURNED) {
                    this.orderStatus = targetStatus;
                    return;
                }
                break;
            case CANCELLED:
            case RETURNED:
                break;
        }
        throw new IllegalStateException("Invalid order move: Cannot change from " + this.orderStatus + " to " + targetStatus);
    }

    double deliveryFee = switch (getDeliveryMethod()) {
        case EXPRESS_DELIVERY -> 65.00;
        case STANDARD_DELIVERY -> 35.00;
        case COLLECTION -> 0.0;
    };

    public void orderDetails(){
        if (getStatus() == PENDING) {
            System.out.println("\nAwaiting Payment");
            nextStatus(CONFIRMED);

        } else if (getStatus() == PAID) {
            System.out.println("\nPayment Successful");
            nextStatus(CONFIRMED);

        } else if (getStatus() == FAILED) {
            System.out.println("\nPayment Failed");
            nextStatus(CANCELLED);

        } else {
            throw new IllegalArgumentException("Invalid Payment Status Match");
        }

        System.out.println("Customer Name: " + getCustomerName());
        System.out.println("Order status: " + getOrderStatus());
        System.out.printf("Total Amount is: R%.2f\n", getTotalAmount());
        System.out.printf("Delivery fee is: R%.2f\n", deliveryFee);
        System.out.printf("Grand Total Amount: R%.2f\n", (getTotalAmount() + deliveryFee));

    }

}







