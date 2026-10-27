package org.example.Lab01_Enum_Food_Delivery_Order;

import java.math.BigDecimal;

public class Order {
    private String orderNumber;
    private String customerName;
    private BigDecimal totalAmount;
    private DeliveryMethod deliveryMethod;
    PaymentStatus paymentStatus;
    OrderStatus status;

    // added the contructor
    public Order(String customerName, String orderNumber, BigDecimal totalAmount, DeliveryMethod deliveryMethod) {
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
        if (status == OrderStatus.DELIVERED || status == OrderStatus.CANCELLED) {
            System.out.println("Cannot change payment on a closed order.");
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
        }
    }
    public void displayPaymentStatus() {
        switch (paymentStatus) {
            case PENDING -> System.out.println("Payment is pending.");
            case PAID -> System.out.println("Payment successful.");
            case FAILED -> System.out.println("Payment was unsuccessful.");
            case REFUNDED -> System.out.println("Payment has been refunded.");
        }
    }

    // add confirmation for order
    public void confirmingOrder() {
        if (paymentStatus != PaymentStatus.PAID) {
            System.out.println("Order cannot be confirmed when payment is not successful.");
        } else if (status != OrderStatus.PLACED) {
            System.out.println(" Placed order can be confirmed.");
        } else {
            status = OrderStatus.CONFIRMED;
            System.out.println("Order confirmed successfully.");
        }
    }


    public BigDecimal calculateTotalAmount() {

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

    public void nextStatus() {
        if (status == null || paymentStatus == null) {
            System.out.println("ERROR: Missing status.");
            return;
        }
        switch (status) {
            case PLACED -> {
                if (paymentStatus != PaymentStatus.PAID) {
                    System.out.println("ERROR: Payment required.");
                    return;
                }
                status = OrderStatus.CONFIRMED;
            }
            case CONFIRMED -> status = OrderStatus.PREPARING;
            case PREPARING -> status = OrderStatus.OUT_FOR_DELIVERY;
            case OUT_FOR_DELIVERY -> status = OrderStatus.DELIVERED;
            case DELIVERED, CANCELLED -> {
                System.out.println("Order cannot continue.");
                return;
            }
        }
        System.out.println("New status: " + status);
    }

    public void cancelOrder() {
        if (status == null) {
            System.out.println("Cannot cancel because order status is missing.");
        } else if (status == OrderStatus.DELIVERED) {
            System.out.println("A delivered order cannot be cancelled.");
        } else if (status == OrderStatus.CANCELLED) {
            System.out.println(": This order is already cancelled.");
        } else if (status == OrderStatus.OUT_FOR_DELIVERY) {
            System.out.println(" Cannot cancel an order that is out for delivery.");
        } else {
            status = OrderStatus.CANCELLED;
            System.out.println("Order cancelled successfully.");
        }
    }


}



