package org.example.Lab1;

public class Order {
    private int orderNumber;
    private String name;
    private double amount;
    private OrderStatus status;
    private PaymentStatus paymentStatus;
    private DeliveryMethod method;

    public Order( int orderNumber, String name,
                  double amount, DeliveryMethod method){
        this.orderNumber = orderNumber;
        this.name = name;
        this.amount = amount;
        this.status = OrderStatus.PLACED;
        this.paymentStatus = PaymentStatus.PENDING;
        this.method = method;

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
        return switch (method) {
            case COLLECTION -> 0.0;
            case STANDARD_DELIVERY -> 35.0;
            case EXPRESS_DELIVERY -> 65.0;
        };
    }

    public double calculateTotal() {
        return amount + deliveryFee();
    }



    public void nextStatus() {
        if (status == OrderStatus.DELIVERED || status == OrderStatus.CANCELLED) {
            throw new IllegalStateException("Order can no longer be changed");
        }

        switch (status) {
            case CONFIRMED -> status = OrderStatus.PREPARING;

            case PREPARING -> status = OrderStatus.READY_FOR_COLLECTION;

            case READY_FOR_COLLECTION -> {
                if (method == DeliveryMethod.COLLECTION) {
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

    public void displaySummary() {
        System.out.println("===== ORDER SUMMARY =====");
        System.out.println("Order Number: " + orderNumber);
        System.out.println("Customer: " + name);
        System.out.println("Order Status: " + status);
        System.out.println("Payment Status: " + paymentStatus);
        System.out.println("Delivery Method: " + method);
        System.out.printf("Food Total: R%.2f%n", amount);
        System.out.printf("Delivery Fee: R%.2f%n", deliveryFee());
        System.out.printf("Grand Total: R%.2f%n", calculateTotal());
        System.out.println("=========================");
    }


}
