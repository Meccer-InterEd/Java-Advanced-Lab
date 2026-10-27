package org.example.Lab1FoodDeliveryOrder;

import java.math.BigDecimal;

public class Order {
    private String orderNum;
    private String custName;
    private BigDecimal totalAmount;
    private OrderStatus orderStatus;
    private PaymentStatus paymentStatus;
    private DeliveryMethod deliveryMethod;


    public Order(String orderNum, String custName, BigDecimal totalAmount, DeliveryMethod deliveryMethod) {

        if (totalAmount == null || totalAmount.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Enter a valid Amount, Order total cannot be negative");
        }

        this.orderNum = orderNum;
        this.custName = custName;
        this.totalAmount = totalAmount;
        this.deliveryMethod = deliveryMethod;

        this.orderStatus = OrderStatus.PLACED;
        this.paymentStatus = PaymentStatus.PENDING;

    }


    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public DeliveryMethod getDeliveryMethod() {
        return deliveryMethod;
    }

    public void setDeliveryMethod(DeliveryMethod deliveryMethod) {

        if (!(this.orderStatus == OrderStatus.PLACED || this.orderStatus == OrderStatus.CONFIRMED || this.orderStatus == OrderStatus.PREPARING)) {

            throw new IllegalArgumentException("Delivery cannot be changed at this stage");
        }
        this.deliveryMethod = deliveryMethod;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(PaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
    }


    public BigDecimal determineDeliveryFee() {
        switch (deliveryMethod) {
            case COLLECTION -> {
                return new BigDecimal(0);
            }
            case STANDARD_DELIVERY -> {
                return new BigDecimal("35.00");
            }
            default -> {
                return new BigDecimal("65.00");
            }

        }
    }

    public BigDecimal overallTotal() {
        return totalAmount.add(determineDeliveryFee());
    }


    public void confirmPayment(BigDecimal amount) {
        BigDecimal grandTotal = overallTotal();

        if (amount.compareTo(grandTotal) >= 0) {
            this.paymentStatus = PaymentStatus.PAID;
            this.orderStatus = OrderStatus.CONFIRMED;
            System.out.println("Payment is successful");
            System.out.println("Order: " + orderNum + " is confirmed");
        } else {
            this.orderStatus = OrderStatus.PLACED;
            this.paymentStatus = PaymentStatus.FAILED;
            System.out.println("Payment has failed due to insufficient funds:  Required Amount R" + grandTotal);
        }
    }

    public void cancelOrder() {
        if (this.orderStatus == OrderStatus.DELIVERED || this.orderStatus == OrderStatus.CANCELLED) {
            throw new IllegalArgumentException("Cannot change an order that is already " + this.orderStatus);
        }

        if (this.orderStatus == OrderStatus.OUT_FOR_DELIVERY) {
            throw new IllegalArgumentException("Cannot cancel order. It is already out for delivery!");
        }

        this.orderStatus = OrderStatus.CANCELLED;
        this.paymentStatus = PaymentStatus.REFUNDED;
        System.out.println("Order " + this.orderNum + " has been successfully cancelled.");
    }


    public void display() {
        System.out.println("=========================");
        System.out.println("      ORDER SUMMARY      ");
        System.out.println("=========================");
        System.out.println("Order Number:" + this.orderNum + "\nCustomer Name:" + this.custName);
        System.out.println("Delivery Method:" + this.deliveryMethod + "\nOrder Status:" + this.orderStatus + "\nPayment Status:" + this.paymentStatus );
        System.out.println("------------------------------");
        System.out.println("Amount of Items :R" + this.totalAmount + "\nDelivery Fee :R" + this.determineDeliveryFee() + "\nTotal due with deliveryFee :R" + overallTotal());
        System.out.println("=========================");
    }

    public void nextStatus() {
        if (this.orderStatus == OrderStatus.DELIVERED || this.orderStatus == OrderStatus.CANCELLED) {
            throw new IllegalArgumentException("Cannot advance status. Order is already " + this.orderStatus);
        }

        switch (this.orderStatus) {
            case PLACED:
                if (this.paymentStatus != PaymentStatus.PAID) {
                    throw new IllegalArgumentException("Payment still pending, cannot confirm order");
                }
                this.orderStatus = OrderStatus.CONFIRMED;
                break;

            case CONFIRMED:
                this.orderStatus = OrderStatus.PREPARING;
                break;

            case PREPARING:
                if (this.deliveryMethod == DeliveryMethod.COLLECTION) {
                    this.orderStatus = OrderStatus.READY_FOR_COLLECTION;
                } else {
                    this.orderStatus = OrderStatus.OUT_FOR_DELIVERY;
                }
                break;

            case READY_FOR_COLLECTION:
                System.out.println("Order: " + this.orderNum + " ready for collection");
                break;
            case OUT_FOR_DELIVERY:
                this.orderStatus = OrderStatus.DELIVERED;
                break;

            default:
                throw new IllegalArgumentException("Invalid current status ");
        }

        System.out.println("Order " + this.orderNum + "  moved to next status: " + this.orderStatus);
    }


}
