package org.example;

import java.math.BigDecimal;

public class Order {

    private  int orderNumber;
    private String customerName;
    private double totalAmt;
    private OrderStatus status;
    private PaymentStatus paymentStatus;
    private DeliveryMethod deliveryMethod;

    public Order(int orderNumber, String customerName, double totalAmt, DeliveryMethod deliveryMethod) {
        this.orderNumber = orderNumber;
        this.customerName = customerName;
        this.totalAmt = totalAmt;
        this.deliveryMethod = deliveryMethod;

        this.paymentStatus=PaymentStatus.PENDING;
        this.status=OrderStatus.PLACED;

    }
    public void setPaymentStatus(PaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
    }


    public void confirmOrder(){

        if(paymentStatus!= PaymentStatus.PAID){
            throw new IllegalStateException("order cannot be comfirmed until payment succeeds");
        }
        if(status!=OrderStatus.PLACED){
            throw new IllegalStateException("only placed order can be comfirmed");
        }
        status=OrderStatus.CONFIRMED;
    }

    public double deliveryFee(){
       return switch (deliveryMethod){
            case COLLECTION -> 0.0;
            case EXPRESS_DELIVERY -> 65.00;
           case STANDARD_DELIVERY -> 35.00;

        };
    }
    public double totalMethod(){
        return  totalAmt + deliveryFee();
    }
    public void nextStatus(){

        if(status==OrderStatus.CANCELLED || status==OrderStatus.DELIVERED){
            throw new IllegalStateException("Order cannot be changed");
        }
        switch (status){

            case PLACED : if(paymentStatus!=PaymentStatus.PAID){
                throw new IllegalStateException("Payment must be paid first!");
            }
            status=OrderStatus.CONFIRMED;
            break;
            case CONFIRMED:
                status=OrderStatus.PREPARING;
                break;

            case PREPARING:if(deliveryMethod==DeliveryMethod.COLLECTION){
                status=OrderStatus.READY_FOR_COLLECTION;

            }else{
                status=OrderStatus.OUT_FOR_DELIVERY;
            }
            break;
            case READY_FOR_COLLECTION:
            case OUT_FOR_DELIVERY:
                status=OrderStatus.DELIVERED;
                break;
            default:
                throw new IllegalStateException("");


        }

    }
    public void cancelOrder(){
        if(status == OrderStatus.DELIVERED || status == OrderStatus.CANCELLED){
            throw new IllegalArgumentException("Delivered or cancelled orders cannot be changed");
        }

        if(status == OrderStatus.OUT_FOR_DELIVERY){
            throw new IllegalArgumentException("Order cannot be cancelled after dispatch");
        }

        status = OrderStatus.CANCELLED;

        System.out.println("Order cancelled successfully");
    }

    public void displayDetails(){
        System.out.println("---ORDER SUMMARY---");
        System.out.println("Order number: " + orderNumber);
        System.out.println("Customer Name: " + customerName);
        System.out.println("Status: " + status);
        System.out.println("Payment Status: " + paymentStatus);
        System.out.println("Delivery Method: " + deliveryMethod);
        System.out.println("Order Total: R" + totalAmt);
        System.out.println("Delivery Fee: R" + deliveryFee());
        System.out.println("Net Total: R" + totalMethod());
        System.out.println(" ");
    }


}
