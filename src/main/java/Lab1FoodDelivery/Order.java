
package Lab1FoodDelivery;
import java.math.BigDecimal;

import static Lab1FoodDelivery.DeliveryMethod.*;


public class Order {
    private int orderNumber;
    private String customerName;
    private BigDecimal totalAmount;
    private OrderStatus status;
    private PaymentStatus paymentStatus;
    private DeliveryMethod deliveryMethod;

    public Order(int orderNumber, String name,
                 BigDecimal amount, DeliveryMethod deliveryMethod){
        this.orderNumber = orderNumber;
        this.customerName = name;
        this.totalAmount = amount;
        this.status = OrderStatus.PLACED;
        this.paymentStatus = PaymentStatus.PENDING;
        this.deliveryMethod = deliveryMethod;

    }

    public void confirmOrder(){
        if((status == OrderStatus.PLACED) && (paymentStatus == PaymentStatus.PAID)){
            this.status = OrderStatus.CONFIRMED;
        }else {
            throw new IllegalArgumentException("Order must be paid first for it to go through");
        }
    }

    public void cancelOrder() {
        if (status == OrderStatus.OUT_FOR_DELIVERY || status == OrderStatus.DELIVERED || status == OrderStatus.CANCELLED) {

            throw new IllegalArgumentException("This order cannot be cancelled");
        }else{
            status = OrderStatus.CANCELLED;
        }


    }

    public void paymentStatus(PaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public double deliveryFee() {
        return switch (deliveryMethod) {
            case COLLECTION -> 0.0;
            case STANDARD_DELIVERY -> 35.0;
            case EXPRESS_DELIVERY -> 65.0;
        };
    }

    public double calculateTotal() {
        return totalAmount + deliveryFee();
    }



    public void nextStatus() {
        if (status == OrderStatus.DELIVERED || status == OrderStatus.CANCELLED) {
            throw new IllegalStateException("Order can no longer be changed");
        }

        switch (status) {
            case CONFIRMED -> status = OrderStatus.PREPARING;

            case PREPARING -> status = OrderStatus.READY_FOR_COLLECTION;

            case READY_FOR_COLLECTION -> {
                if (deliveryMethod == COLLECTION) {
                    status = OrderStatus.DELIVERED;
                } else {
                    status = OrderStatus.OUT_FOR_DELIVERY;
                }
            }

            case OUT_FOR_DELIVERY ->
                    status = OrderStatus.DELIVERED;

            default ->
                    throw new IllegalStateException("This order cannot move to the next status");
        }
    }

    public void display() {
        System.out.println("ORDER SUMMARY");
        System.out.println("Order Number: " + orderNumber);
        System.out.println("Customer: " + customerName);
        System.out.println("Order Status: " + status);
        System.out.println("Payment Status: " + paymentStatus);
        System.out.println("Delivery Method: " + deliveryMethod);
        System.out.printf("Food Total: R %n", totalAmount);
        System.out.printf("Delivery Fee: R %n", deliveryFee());
        System.out.printf("Grand Total: R %n", calculateTotal());
        System.out.println("=========================");
    }



}
