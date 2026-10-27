package org.example;

import java.math.BigDecimal;
import  java.math.RoundingMode;

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
        if (paymentStaus.equals(PaymentStatus.FAILED)){
            status = OrderStatus.CANCELLED;
        }
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
//        switch(status){
//            case CONFIRMED ->
//                status = OrderStatus.PREPARING;
//            case PREPARING ->
//                status = OrderStatus.READY_FOR_COLLECTION;
//            case READY_FOR_COLLECTION ->
//                status = OrderStatus.OUT_FOR_DELIVERY;
//            case OUT_FOR_DELIVERY ->
//                status = OrderStatus.DELIVERED;
//            default -> System.out.println("Invalid status transition from" + status);
//        }
    if (deliveryMethod.equals(DeliveryMethod.COLLECTION)){
        switch(status) {
            case CONFIRMED -> status = OrderStatus.PREPARING;
            case PREPARING -> status = OrderStatus.READY_FOR_COLLECTION;
        }
    } else {
        switch(status){
            case CONFIRMED ->
                status = OrderStatus.PREPARING;
            case PREPARING ->
                status = OrderStatus.OUT_FOR_DELIVERY;
            case OUT_FOR_DELIVERY ->
                status = OrderStatus.DELIVERED;
            default -> System.out.println("Invalid status transition from" + status);
        }
    }
}
public void cancelOrder(){
        if (status.equals(OrderStatus.OUT_FOR_DELIVERY) || status.equals(OrderStatus.DELIVERED)){
            System.out.println("Order cannot be cancelled once it is out for delivery / has been delivered");
        } else if (status.equals(OrderStatus.READY_FOR_COLLECTION)) {
            System.out.println("Order cannot be cancelled it is ready for collection");
        }
    if (status.equals(OrderStatus.CANCELLED)){
            System.out.println("order cancelled");
        }
}
public BigDecimal calcDeliveryFee(){
        return switch (deliveryMethod){
            case COLLECTION -> BigDecimal.ZERO.setScale(2, RoundingMode.HALF_UP);
            case STANDARD_DELIVERY -> new BigDecimal(35).setScale(2, RoundingMode.HALF_UP);
            case EXPRESS_DELIVERY ->  new BigDecimal(65).setScale(2, RoundingMode.HALF_UP);

        };

}
public BigDecimal calcGrandTotal(){
        return totalAmount.add(calcDeliveryFee()).setScale(2, RoundingMode.HALF_UP);
}
public void Summary(){
    System.out.println("Order Number:" + orderNumber + "\n|Customer:" + customerName + "\n|Status:" + status + "\n|Payment status:" + paymentStatus + "\n|Delivery method:" + deliveryMethod + "\n|Order total:" + totalAmount.setScale(2, RoundingMode.HALF_UP) + "\n|Delivery fee:R" + calcDeliveryFee() + "\n|Grand total:R" + calcGrandTotal()+"\n\n");
}

}









