package org.example;

import static org.example.DeliveryMethod.*;

public class Order {
    private String order_Number;
    private String customerName;
    private double totalAmount;
    private PaymentStatus status;
    private DeliveryMethod deliveryMethod;
    private OrderStatus orderStatus;
    private OrderStatus currentStatus;

    public Order(String order_Number, String customerName, double totalAmount, PaymentStatus status, DeliveryMethod deliveryMethod, OrderStatus orderStatus) {
        setOrder_Number(order_Number);
        setCustomerName(customerName);
        setTotalAmount(totalAmount);
        setStatus(status);
        setDeliveryMethod(deliveryMethod);
        this.orderStatus = orderStatus;
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
        if (totalAmount > 0) {
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

    public void setCurrentStatus(OrderStatus currentStatus) {
        this.currentStatus = currentStatus;
    }

    public OrderStatus getCurrentStatus() {
        return currentStatus;
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

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void nextStatus(OrderStatus targetStatus) {
        switch (this.orderStatus) {
            case IN_PROGRESS:
                if (targetStatus == OrderStatus.PLACED || targetStatus == OrderStatus.CANCELLED) {
                    this.orderStatus = targetStatus;
                    return;
                }
                break;
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
                if (targetStatus == OrderStatus.READY_FOR_COLLECTION ||
                        targetStatus == OrderStatus.OUT_FOR_DELIVERY) {
                    this.orderStatus = targetStatus;
                    return;
                }
                break;
            case READY_FOR_COLLECTION:
                if (targetStatus == OrderStatus.COLLECTED) {
                    this.orderStatus = targetStatus;
                    return;
                }
                break;
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

    void assignStatus() {
        if (this.status == PaymentStatus.PAID && this.orderStatus == OrderStatus.CONFIRMED) {
            this.nextStatus(OrderStatus.PLACED);
        } else if (this.status == PaymentStatus.FAILED) {
            this.nextStatus(OrderStatus.CANCELLED);
        } else if (this.status == PaymentStatus.PENDING && this.orderStatus == OrderStatus.IN_PROGRESS) {
            this.nextStatus(OrderStatus.PLACED);
        } else if (this.status == PaymentStatus.PAID && this.orderStatus == OrderStatus.READY_FOR_COLLECTION) {
            this.nextStatus(OrderStatus.COLLECTED);
        }else if (this.status == PaymentStatus.PAID && this.orderStatus == OrderStatus.OUT_FOR_DELIVERY) {
            this.nextStatus(OrderStatus.DELIVERED);
        } else {
            throw new IllegalArgumentException("Invalid Payment Status Match");
        }

        double deliveryFee = switch (getDeliveryMethod()) {
            case EXPRESS_DELIVERY -> 65.00;
            case STANDARD_DELIVERY -> 35.00;
            case COLLECTION -> 0.0;
        };


        System.out.println("Customer Name: " + getCustomerName());
        System.out.printf("Total Amount is: R%.2f\n", getTotalAmount());
        System.out.printf("Delivery fee is: R%.2f\n", deliveryFee);
        System.out.printf("Grand Total Amount: R%.2f\n", (getTotalAmount() + deliveryFee));
        System.out.println("Initial Order Status is: " + getCurrentStatus());
        System.out.println("Current Order Status: " + getOrderStatus());
    }
}
