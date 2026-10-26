package org.example;

import java.math.BigDecimal;

public class Order {
    private String orderNumber;
    private String customerName;
    private BigDecimal totalAmount;
    private  DeliveryMethod deliveryMethod;
    PaymentStatus paymentStatus;
    OrderStatus status;

    // added the contructor
    Order(String customerName, String orderNumber, BigDecimal totalAmount, DeliveryMethod  deliveryMethod){
        this.orderNumber = orderNumber;
        this.customerName = customerName;
         this.totalAmount = totalAmount;
        this.deliveryMethod = deliveryMethod;
        this.paymentStatus = PaymentStatus.PENDING;
        this.status = OrderStatus.PLACED;


    }


    public String getOrderNumber() {

        return orderNumber;
    }

    public String getCustomerName() {

        return customerName;
    }

    public BigDecimal getTotalAmount() {

        return totalAmount;
    }

    public DeliveryMethod getDeliveryMethod() {

        return deliveryMethod;
    }

    public PaymentStatus getPaymentStatus() {

        return paymentStatus;
    }

    public OrderStatus getStatus() {
        return status;
    }


// payment status  for payment
public void setPaymentStatus(PaymentStatus paymentStatus) {
    if (paymentStatus == null) {
        System.out.println("Payment status cannot be null.");
    } else {
        this.paymentStatus = paymentStatus;
        System.out.println("Payment status updated to " + paymentStatus);
    }
}

    // added the  free delivary and after the collection
    public BigDecimal calculateFreeDelivery() {
        if (deliveryMethod == DeliveryMethod.COLLECTION) {
            return new BigDecimal("0.00");
        } else if (deliveryMethod == DeliveryMethod.STANDARD_DELIVERY) {
            return new BigDecimal("35.00");
        } else if (deliveryMethod == DeliveryMethod.EXPRESS_DELIVERY) {
            return new BigDecimal("65.00");
        } else {
            return BigDecimal.ZERO;
        }}


    // add confirmation for order
    public void confirmingOrder() {
        if (paymentStatus != PaymentStatus.PAID) {
            System.out.println("Order cannot be confirmed when payment is not successful.");
        } else if (status != OrderStatus.PLACED) {
            System.out.println(" Placed order can be confirmed.");
        }
        else {
            status = OrderStatus.CONFIRMED;
            System.out.println("Order confirmed successfully.");
        }
    }



    public BigDecimal calculateTotalAmount(){
    return totalAmount.add(calculateFreeDelivery());
    }
    public void displayOrderSummary() {
        System.out.println("===== ORDER SUMMARY =====");
        System.out.println("Order Number: " + orderNumber);
        System.out.println("Customer: " + customerName);
        System.out.println("Order Status: " + status);
        System.out.println("Payment Status: " + paymentStatus);
        System.out.println("Delivery Method: " + deliveryMethod);
        System.out.println("Order Total: R" + totalAmount.toPlainString());
        System.out.println("Delivery Fee: R" + calculateFreeDelivery());
        System.out.println("Grand Total: R" + calculateTotalAmount());
        System.out.println("=========================");
    }
}



