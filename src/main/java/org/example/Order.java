package org.example;

public class Order {
    private int orderNumber;
    private String customerName;
    private double totalAmount;
    private OrderStatus status;
    private PaymentStatus paymentStatus;
    private DeliveryMethod deliveryMethod;

    Order(int orderNumber, String customerName, double totalAmount, OrderStatus status,
          PaymentStatus paymentStatus, DeliveryMethod deliveryMethod) {

        this.orderNumber = orderNumber;
        this.customerName = customerName;
        this.totalAmount = totalAmount;
        this.status = status;
        this.paymentStatus = paymentStatus;
        this.deliveryMethod = deliveryMethod;
    }

    public boolean confirmOrder() {

        if (status != OrderStatus.PLACED) {
            System.out.println("Only placed orders can be confirmed");
            return false;
        }

        if (paymentStatus != PaymentStatus.PAID) {
            System.out.println("Payment has not been made. Order cannot be confirmed");
            return false;
        }

        status = OrderStatus.CONFIRMED;
        System.out.println("Order " + orderNumber + " confirmed");
        return true;
    }

    public boolean updateStatus() {
        switch (this.status) {

            case PLACED:

                if (this.paymentStatus == PaymentStatus.PAID) {
                    this.status = OrderStatus.CONFIRMED;
                    break;
                } else {
                    System.out.println("Order cannot be confirmed until payment is made");
                    return false;
                }

            case CONFIRMED:

                this.status = OrderStatus.PREPARING;
                break;

            case PREPARING:

                this.status = OrderStatus.READY_FOR_COLLECTION;
                break;

            case READY_FOR_COLLECTION:

                if (this.deliveryMethod == DeliveryMethod.COLLECTION) {
                    this.status = OrderStatus.DELIVERED;
                } else {
                    this.status = OrderStatus.OUT_FOR_DELIVERY;
                }
                break;

            case OUT_FOR_DELIVERY:
                this.status = OrderStatus.DELIVERED;
                break;

            case DELIVERED:
                System.out.println("The status of this order cannot be changed as it has already been" +
                        "delivered");
                return false;

            case CANCELLED:
                System.out.println("The status of this order cannot be changed as it has been " +
                        "cancelled");
                return false;
        }

        System.out.println("Order " + this.orderNumber + " status updated to " + this.status);
        return true;
    }

    public boolean cancelOrder() {

        if (status == OrderStatus.DELIVERED || status == OrderStatus.CANCELLED) {
            System.out.println("Order " + orderNumber + " has already been delivered or cancelled");
            return false;
        }

        if (status == OrderStatus.OUT_FOR_DELIVERY) {
            System.out.println("Your order has been dispatched and cannot be cancelled");
            return false;
        }

        status = OrderStatus.CANCELLED;
        System.out.println("Order " + orderNumber + " cancelled");
        return true;
    }

//    public void calculateDeliveryFee() {
//        switch (this.deliveryMethod) {
//            case COLLECTION:
//                this.totalAmount = this.totalAmount + 0;
//                break;
//            case STANDARD_DELIVERY:
//                this.totalAmount = this.totalAmount + 35;
//                break;
//            case EXPRESS_DELIVERY:
//                this.totalAmount = this.totalAmount + 65;
//                break;
//        }
//    }

}
