package org.example;

public class Order {

    private String orderNumber;
    private String customer;
    private double totalAmount;
    private OrderStatus orderStatus;
    private PaymentStatus paymentStatus;
    private DeliveryMethod deliveryMethod;

    Order() {
    }

    Order(String orderNumber, String customer, double totalAmount, DeliveryMethod deliveryMethod) {

        setOrderNumber(orderNumber);
        setCustomer(customer);
        setTotalAmount(totalAmount);
        setOrderStatus(OrderStatus.PLACED);
        setPaymentStatus(PaymentStatus.PENDING);
        setDeliveryMethod(deliveryMethod);
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getCustomer() {
        return customer;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setPaymentStatus(PaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    public void setDeliveryMethod(DeliveryMethod deliveryMethod) {
        this.deliveryMethod = deliveryMethod;
    }

    public DeliveryMethod getDeliveryMethod() {
        return deliveryMethod;
    }

    void cancelAble() {
        if (this.orderStatus == OrderStatus.DELIVERED || this.orderStatus == OrderStatus.CANCELLED) {
            throw new IllegalStateException("Cannot cancel an order that is " + this.orderStatus);
        }
    }

    double calculateDelivery() {
        double deliveryAmt = 0;

        switch (deliveryMethod) {
            case COLLECTION:
                deliveryAmt = 0;
                break;
            case STANDARD_DELIVERY:
                deliveryAmt = 35.00;
                break;
            case EXPRESS_DELIVERY:
                deliveryAmt = 65.00;
                break;
            default:
                System.out.println("Invalid Option");
                break;
        }
        return deliveryAmt;
    }

    double getSubtotal() {
        return totalAmount + calculateDelivery();
    }

    void confirmOrder(double amount) {

        if (amount >= getSubtotal()) {
            this.paymentStatus = PaymentStatus.PAID;
            this.orderStatus = OrderStatus.CONFIRMED;
            System.out.println("Payment successful!");
            System.out.println("Order " + this.orderNumber + " is confirmed");
        } else {
            this.paymentStatus = PaymentStatus.FAILED;
            this.orderStatus = OrderStatus.PLACED;
            System.out.println("Insufficient funds.");
        }
    }

    void cancelOrder() {

        if (this.orderStatus == OrderStatus.OUT_FOR_DELIVERY || this.orderStatus == OrderStatus.DELIVERED || this.orderStatus == OrderStatus.CANCELLED) {

            throw new IllegalArgumentException("The order can no longer be cancelled when it already " + this.orderStatus);
        }
        this.orderStatus = OrderStatus.CANCELLED;
        this.paymentStatus = PaymentStatus.REFUNDED;
        System.out.println("Order " + this.orderNumber + " has been canceled!");
    }

    void nextStatus(){

        if(this.orderStatus == OrderStatus.DELIVERED || this.orderStatus == OrderStatus.CANCELLED){
            throw new IllegalArgumentException("Order " + orderNumber+ " in this state cannot be progressed any further");
        }

        switch(this.orderStatus){
            case PLACED :
                if(this.paymentStatus != PaymentStatus.PAID){
                    throw new IllegalArgumentException("Payment has not been confirmed!");
                }
                this.orderStatus = OrderStatus.CONFIRMED; break;
            case CONFIRMED:
                this.orderStatus = OrderStatus.PREPARING; break;
            case PREPARING:
                if(this.deliveryMethod == DeliveryMethod.COLLECTION) {
                    this.orderStatus = OrderStatus.READY_FOR_COLLECTION;
                    System.out.println("Order waiting to be collected.");
                }else{
                    this.orderStatus = OrderStatus.OUT_FOR_DELIVERY;
            } break;
            case READY_FOR_COLLECTION:
                System.out.println(orderNumber + " ready for collection."); break;
            case OUT_FOR_DELIVERY:
                this.orderStatus = OrderStatus.DELIVERED;
                System.out.println(orderNumber + " is out for delivery");break;
            default: throw new IllegalArgumentException("Invalid status.");
        }
        System.out.println("Order " + orderNumber + " has moved to " + orderStatus);
    }

    void display() {

        System.out.println("========================================");
        System.out.println("           ORDER SUMMARY                ");
        System.out.println("========================================");
        System.out.println("Order Number   : " + orderNumber);
        System.out.println("Customer Name  : " + customer);
        System.out.println("Delivery Method: " + deliveryMethod);
        System.out.println("Order Status   : " + orderStatus);
        System.out.println("Payment Status : " + paymentStatus);
        System.out.println("----------------------------------------");
        System.out.println("Order Total    : R " + totalAmount);
        //System.out.println("Delivery Fee   : R " + deliveryAmt);
        System.out.println("Grand Total    : R " + getSubtotal());
        System.out.println("========================================\n");
    }
}
