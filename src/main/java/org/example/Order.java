package org.example;

import java.util.PrimitiveIterator;

import static org.example.OrderStatus.*;
import static org.example.PaymentStatus.*;

public class Order {
    private String orderNumber;
    private String customerName;
    private double totalAmount;
    private PaymentStatus status;
    private DeliveryMethod deliveryMethod;
    private OrderStatus orderStatus;
    private  OrderStatus currentStatus;


    public Order(String orderNumber, String customerName, double totalAmount, PaymentStatus status, DeliveryMethod deliveryMethod, OrderStatus orderStatus) {
        setOrderNumber(orderNumber);
        setCustomerName(customerName);
        setTotalAmount(totalAmount);
        setStatus(status);
        setDeliveryMethod(deliveryMethod);
        this.orderStatus = orderStatus;

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

    public OrderStatus getOrderStatus() {
        return orderStatus;
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
        if (deliveryMethod != null) {
            this.deliveryMethod = deliveryMethod;
        } else {
            throw new IllegalArgumentException(" Delivery method can not be empty");
        }
    }

    public void setCurrentStatus(OrderStatus currentStatus) {
        this.currentStatus = currentStatus;
    }



    public void nextStatus(OrderStatus targetStatus) {
        switch (this.orderStatus) {
            case PLACED:
                if (targetStatus == CONFIRMED || targetStatus == OrderStatus.CANCELLED){
                    this.orderStatus = targetStatus;
                    System.out.println(targetStatus);
                    return;
                }
                break;
            case CONFIRMED:
                if (targetStatus == PREPARING || targetStatus == OrderStatus.CANCELLED) {
                    this.orderStatus = targetStatus;
                    System.out.println(targetStatus);
                    return;
                }
                break;
            case PREPARING:
                if (targetStatus == OrderStatus.READY_FOR_COLLECTION || targetStatus == OrderStatus.OUT_FOR_DELIVERY) {
                    this.orderStatus = targetStatus;
                    System.out.println(targetStatus);
                    return;
                }
                break;
            case READY_FOR_COLLECTION:
                if( targetStatus == OrderStatus.COLLECTED){
                    this.orderStatus = targetStatus;
                    System.out.println(targetStatus);
                    return;
                }
            case OUT_FOR_DELIVERY:
                if (targetStatus == OrderStatus.DELIVERED) {
                    this.orderStatus = targetStatus;
                    System.out.println(targetStatus);
                    return;
                }
                break;
            case DELIVERED:
                if (targetStatus == OrderStatus.RETURNED) {
                    this.orderStatus = targetStatus;
                    System.out.println(targetStatus);
                    return;
                }
                break;
            case CANCELLED:
            case RETURNED:
                break;
        }
        throw new IllegalStateException("Invalid order move: Cannot change from " + this.orderStatus + " to " + targetStatus);
    }

     void assignStatus(){

         double deliveryFee = switch (getDeliveryMethod()) {
             case EXPRESS_DELIVERY -> 65.00;
             case STANDARD_DELIVERY -> 35.00;
             case COLLECTION -> 0.0;
         };

             if (this.status == PaymentStatus.PAID && this.orderStatus == OrderStatus.CONFIRMED) {
                 this.nextStatus(OrderStatus.PLACED);
             } else if (this.status == PaymentStatus.FAILED) {
                 this.nextStatus(OrderStatus.CANCELLED);
             } else if (this.status == PaymentStatus.PENDING && this.orderStatus == OrderStatus.IN_PROGRESS) {
                 this.nextStatus(OrderStatus.PLACED);
             } else if (this.status == PaymentStatus.PAID && this.orderStatus == OrderStatus.READY_FOR_COLLECTION) {
                 this.nextStatus(OrderStatus.COLLECTED);
             }else if (this.status == PaymentStatus.PAID && this.orderStatus == OrderStatus.OUT_FOR_DELIVERY) {
                 this.nextStatus(DELIVERED);
             }else if (this.status == PENDING && this.orderStatus == OrderStatus.PLACED) {
                 this.nextStatus(CONFIRMED);
             } else {
                 throw new IllegalArgumentException("Invalid Payment Status Match");
             }

        System.out.println("Customer Name: " + getCustomerName());
        System.out.printf("Total Amount is: R%.2f\n", getTotalAmount());
        System.out.printf("Delivery fee is: R%.2f\n", deliveryFee);
        System.out.printf("Grand Total Amount: R%.2f\n", (getTotalAmount() + deliveryFee));
        System.out.println("Current order status: " + currentStatus);
        System.out.println("Proceeding order status: " + getOrderStatus());

    }

}







