package org.example;

public class Order {
    private int orderNumber;
    private String customerName;
    private double totalAmount;
    private OrderStatus status;
    private PaymentStatus paymentStatus;
    private DeliveryMethod deliveryMethod;
    private boolean isValid = false;

    Order(int orderNumber, String customerName, double totalAmount, OrderStatus status,
          PaymentStatus paymentStatus, DeliveryMethod deliveryMethod) {

        if (orderNumber <= 0) {
            throw new IllegalArgumentException("Order numbers must be greater than 0");
        }

        if (customerName == null || customerName.isBlank()) {
            throw new IllegalArgumentException("Names cannot be left blank");
        }

        if (totalAmount <= 0) {
            throw new IllegalArgumentException("Order amounts must be greater than 0");
        }

        if (status == null) {
            throw new IllegalArgumentException("An order status cannot be left blank");
        }

        if (paymentStatus == null) {
            throw new IllegalArgumentException("A payment status cannot be left blank");
        }

        if (deliveryMethod == null) {
            throw new IllegalArgumentException("A delivery method cannot be left blank");
        }

        if (status.equals(OrderStatus.CONFIRMED) && paymentStatus != PaymentStatus.PAID) {
            throw new IllegalArgumentException("An order cannot be confirmed until payment is made");
        }

        this.orderNumber = orderNumber;
        this.customerName = customerName;
        this.totalAmount = totalAmount;
        this.status = status;
        this.paymentStatus = paymentStatus;
        this.deliveryMethod = deliveryMethod;
    }

    public void makePayment() {

        if (this.paymentStatus.equals(PaymentStatus.PAID)) {
            System.out.println("Order " + this.orderNumber + " has already been paid for\n");
        } else {
            this.paymentStatus = PaymentStatus.PAID;
            System.out.println("Payment successful for order " + this.orderNumber + "\n");
        }

    }

    public boolean confirmOrder() {

        if (status != OrderStatus.PLACED) {
            System.out.println("Only placed orders can be confirmed\n");
            return false;
        }

        if (paymentStatus != PaymentStatus.PAID) {
            System.out.println("Payment has not been made. Order cannot be confirmed\n");
            return false;
        }

        status = OrderStatus.CONFIRMED;
        isValid = true;
        System.out.println("Order " + orderNumber + " confirmed\n");
        return true;
    }

    public boolean updateStatus() {
        switch (this.status) {

            case PLACED:

                if (!isValid) {
                    System.out.println("Order cannot be confirmed until payment is made\n");
                    return false;
                }

                this.status = OrderStatus.CONFIRMED;
                break;

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
                System.out.println("The status of order " + this.orderNumber + " cannot be changed as it has already been" +
                        " delivered\n");
                return false;

            case CANCELLED:
                System.out.println("The status of order " + this.orderNumber + " cannot be changed as it has been " +
                        "cancelled\n");
                return false;
        }

        System.out.println("Order " + this.orderNumber + " status updated to " + this.status + "\n");
        return true;
    }

    public boolean cancelOrder() {

        if (status == OrderStatus.DELIVERED || status == OrderStatus.CANCELLED) {
            System.out.println("Order " + orderNumber + " cannot be cancelled. It has already been delivered or has " +
                    "already been cancelled\n");
            return false;
        }

        if (status == OrderStatus.OUT_FOR_DELIVERY) {
            System.out.println("Your order has been dispatched and cannot be cancelled\n");
            return false;
        }

        status = OrderStatus.CANCELLED;
        this.paymentStatus = PaymentStatus.REFUNDED;
        System.out.println("Order " + orderNumber + " cancelled and refunded\n");
        return true;
    }

    public double calculateDeliveryFee() {
        switch (this.deliveryMethod) {
            case COLLECTION:
                return 0;
            case STANDARD_DELIVERY:
                return 35;
            case EXPRESS_DELIVERY:
                return 65;
            default:
                return 0;
        }
    }

    public void displayOrderSummary() {
        System.out.println("Customer name: " + this.customerName);
        System.out.println("Order number: " + this.orderNumber);
        System.out.println("Order status: " + this.status);
        System.out.println("Payment status: " + this.paymentStatus);
        System.out.println("Delivery method: " + this.deliveryMethod);

        double deliveryFee = calculateDeliveryFee();
        double grandTotal = this.totalAmount + deliveryFee;

        System.out.println("Order total: R" + this.totalAmount);
        System.out.println("Delivery fee: R" + deliveryFee);
        System.out.println("Grand total: R" + grandTotal + "\n");
    }
}
