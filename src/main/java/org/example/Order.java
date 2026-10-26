package org.example;

import java.math.BigDecimal;

public class Order {
    private String orderNumber;
    private String customerName;
    private BigDecimal totalAmount;
    private  DeliveryMethod deliveryMethod;
    PaymentStatus paymentStatus;
    OrderStatus status;

    Order(String orderName, String orderNumber,String customerName){
        this.orderNumber = orderNumber;
        this.customerName = customerName;
        BigDecimal totalAmount;
        DeliveryMethod deliveryMethod;
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

    public void setTotalAmount(BigDecimal totalAmount) {

        this.totalAmount = totalAmount;
    }
// payment status  for payment
    public void setPaymentStatus(PaymentStatus paymentStatus) {
        if (this.status == OrderStatus.DELIVERED || this.status == OrderStatus.CANCELLED) {
            System.out.println("Cannot change payment on a closed order.");
        } else if (paymentStatus == null) {
            System.out.println("Payment status cannot be null.");
        } else if (this.paymentStatus == PaymentStatus.REFUNDED && paymentStatus != PaymentStatus.REFUNDED) {
            System.out.println("A refunded payment cannot be reversed.");
        } else if (this.paymentStatus == PaymentStatus.PAID
                && paymentStatus != PaymentStatus.PAID
                && paymentStatus != PaymentStatus.REFUNDED) {
            System.out.println("A paid payment cannot be changed to failed or pending.");
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



    public BigDecimal calculateTotalAmount() {
        return totalAmount.add(calculateFreeDelivery());
    }

}



