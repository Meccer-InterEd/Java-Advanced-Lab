package org.example;

import java.math.BigDecimal;

public class Order {
  private   String orderNumber ;
 private    String customerName;
  private BigDecimal totalAmount;
  private   OrderStatus status;
  private   PaymentStatus paymentStatus;
  private   DeliveryMethod deliveryMethod;


    Order(String orderNumber, String customerName, BigDecimal totalAmount, DeliveryMethod deliveryMethod){
        this.orderNumber = orderNumber;
        this.customerName = customerName;
        this.totalAmount = totalAmount;
        this.deliveryMethod = deliveryMethod;
        status = OrderStatus.PLACED;
        paymentStatus = PaymentStatus.PENDING;

        if (totalAmount.compareTo(BigDecimal.ZERO) < 0){
            System.out.println("The total order amount cannot be negative");
        }

    }
    public void setPaymentStatus(PaymentStatus paymentStaus){

        this.paymentStatus = paymentStaus;
    }

public void confirmOrder(){
        if (paymentStatus == PaymentStatus.PAID){
            status = OrderStatus.CONFIRMED;
            System.out.println("Your order is confirmed.");
        }
        else {
            System.out.println("Order cannot be confirmed until order payment succeeds.");
        }
}
public void nextStatus(){
        switch(status){
            case CONFIRMED ->
                status = OrderStatus.PREPARING;
            case PREPARING ->
                status = OrderStatus.READY_FOR_COLLECTION;
            case READY_FOR_COLLECTION ->
                status = OrderStatus.OUT_FOR_DELIVERY;
            case OUT_FOR_DELIVERY ->
                status = OrderStatus.DELIVERED;
            default -> System.out.println("Invalid status transition from" + status);


        }
}
public void cancelOrder(){
        if (status == OrderStatus.OUT_FOR_DELIVERY){
            System.out.println("Order cannot be cancelled once it is out for delivery");
        }
        if (status == OrderStatus.CANCELLED){
            System.out.println("order cancelled");
        }
}
public BigDecimal calcDeliveryFee(){
        return switch (deliveryMethod){
            case COLLECTION -> BigDecimal.ZERO;
            case STANDARD_DELIVERY -> new BigDecimal(35);
            case EXPRESS_DELIVERY ->  new BigDecimal(65);

        };

}
public BigDecimal calcGrandTotal(){
        return
                totalAmount.add(calcDeliveryFee());
}
public void Summary(){
    System.out.println("Order Number:" + orderNumber + " Customer:" + customerName + " Status:" + status + " Payment status:" + paymentStatus + " Delivery method:" + deliveryMethod + " Order total:" + totalAmount + " Delivery fee:R" + calcDeliveryFee() + " Grand total:R" + calcGrandTotal());
}

}









