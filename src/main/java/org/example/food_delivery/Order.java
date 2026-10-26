package org.example.food_delivery;

import java.math.BigDecimal;

public class Order {
    private String orderNumber;
    private String customerName;
    private BigDecimal totalAmount;
    private OrderStatus status;
    private PaymentStatus paymentstatus;



    private DeliveryMethod deliveryMethod;

    public Order(String orderNumber, String customerName, BigDecimal totalAmount, DeliveryMethod deliveryMethod) {
        this.orderNumber = orderNumber;
        this.customerName = customerName;
        this.totalAmount = totalAmount;
        this.deliveryMethod = deliveryMethod;
        this.status = OrderStatus.PLACED;
        this.paymentstatus = PaymentStatus.PENDING;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public void displayDetails(){
        System.out.println(orderNumber);
        System.out.println("Name: " + customerName);
        System.out.println("Delivery fee: " + deliveryFee(getDeliveryMethod()));;
        System.out.println("Amount: " + getAmount());
        System.out.println("Total Amount Due: " + this.totalAmount.add(deliveryFee(getDeliveryMethod())));
        System.out.println("Payment: " + paymentstatus);
        System.out.println("Order status: " + status);
    }


    public BigDecimal getAmount() {
        return totalAmount;
    }

    public DeliveryMethod getDeliveryMethod() {
        return deliveryMethod;
    }

    public void setAmount(BigDecimal amount) {
        if(amount.compareTo(BigDecimal.ZERO) > 0){
            this.totalAmount = amount;
        }
    }

    public BigDecimal deliveryFee(DeliveryMethod deliveryMethod){
        switch (deliveryMethod){
            case EXPRESS_DELIVERY:
                return new BigDecimal("65");

            case STANDARD_DELIVERY:
                return new BigDecimal("35.00");
            default:
                return new BigDecimal("0");
        }
    }

    public void updateStatus(PaymentStatus paymentstatus, OrderStatus status) {
        if(paymentstatus == PaymentStatus.PAID){
            this.status = OrderStatus.CONFIRMED;
            switch (status){
                case CONFIRMED ->
                    this.status = OrderStatus.PREPARING;
                case PREPARING ->
                        this.status = OrderStatus.READY_FOR_COLLECTION;
                case READY_FOR_COLLECTION ->
                    this.status = OrderStatus.OUT_FOR_DELIVERY;
                case OUT_FOR_DELIVERY ->
                    this.status = OrderStatus.DELIVERED;
            }

        }
    }

    public void confirmPayment(BigDecimal amount){
        totalAmount = this.totalAmount.add(deliveryFee(getDeliveryMethod()));
        if(amount.compareTo(totalAmount) >= 0){
            this.paymentstatus = PaymentStatus.PAID;
            System.out.println("\n Payment Status: " + paymentstatus);
        }
        else {
            this.paymentstatus = PaymentStatus.FAILED;
            this.status = OrderStatus.CANCELLED;
        }
    }
}
