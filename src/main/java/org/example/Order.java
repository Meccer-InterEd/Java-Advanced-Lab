package org.example;

import java.math.BigDecimal;

public class Order {
  private   String orderNumber ;
 private    String customerName;
  private BigDecimal totalAmount;
  private   OrderStatus status;
  private   PaymentStatus paymentStaus;
  private   DeliveryMethod deliveryMethod;


    Order(String orderNumber, String customerName, BigDecimal totalAmount, DeliveryMethod deliveryMethod){
        this.orderNumber = orderNumber;
        this.customerName = customerName;
        this.totalAmount = totalAmount;
        this.deliveryMethod = deliveryMethod;
        status = OrderStatus.PLACED;
        paymentStaus = PaymentStatus.PENDING;
    }

    public  void Payment(BigDecimal amount){
        totalAmount = totalAmount.add(deliveryMethod.getDeliveryFee());
        if (amount.compareTo(totalAmount) >= 0){
            paymentStaus = PaymentStatus.PAID;
            System.out.println("\nPayment Successful for order "+orderNumber);
            status = OrderStatus.CONFIRMED;
            System.out.println("\nOrder "+orderNumber+" confirmed");
            status = OrderStatus.PREPARING;
            System.out.println("\nOrder "+orderNumber+" is preparing");
            if (deliveryMethod == DeliveryMethod.COLLECTION){
                status = OrderStatus.READY_FOR_COLLECTION;
                System.out.println("\nYour order "+orderNumber+" is ready for collection");
            }
            else {
                status = OrderStatus.OUT_FOR_DELIVERY;
                System.out.println("\nYour order "+orderNumber+" is out for delivery!");
                status = OrderStatus.DELIVERED;
            }
        }
        else {
            paymentStaus = PaymentStatus.FAILED;
            System.out.println("\npayment failed for order "+orderNumber);
            status = OrderStatus.CANCELLED;
            System.out.println(status);
        }
    }


}
