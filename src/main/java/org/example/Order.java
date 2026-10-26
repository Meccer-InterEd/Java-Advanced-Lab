package org.example;

import java.math.BigDecimal;

public class Order {
  private   String orderNumber ;
 private    String customerName;
  private BigDecimal totalAmount;
  private   OrderStatus status;
  private   PaymentStatus paymentStaus;
  private   DeliveryMethod deliveryMethod;

  /*
  Order order = new Order(
    "ORD-1001", orderNumber
    "Lerato", customerName
    new BigDecimal("249.99"), totalAmount
    DeliveryMethod.STANDARD_DELIVERY deliveryMethod
    );
   */

    Order(String orderNumber, String customerName, BigDecimal totalAmount, DeliveryMethod deliveryMethod){
        this.orderNumber = orderNumber;
        this.customerName = customerName;
        this.totalAmount = totalAmount;
        this.deliveryMethod = deliveryMethod;
        status = OrderStatus.PLACED;
        paymentStaus = PaymentStatus.PENDING;
    }


}
