package org.example;

public class Order {

    private String orderNumber;
    private String customer;
    private double totalAmount;
    private OrderStatus orderStatus;
    private PaymentStatus paymentStatus;
    private DeliveryMethod deliveryMethod;

    Order(){}

    Order(String orderNumber, String customer, double totalAmount, OrderStatus orderStatus, PaymentStatus paymentStatus, DeliveryMethod deliveryMethod){

        setOrderNumber(orderNumber);
        setCustomer(customer);
        setTotalAmount(totalAmount);
        setOrderStatus(OrderStatus.PLACED);
        setPaymentStatus(PaymentStatus.PENDING);
        setDeliveryMethod(DeliveryMethod.COLLECTION);
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
    void cancelAble(){
        if(this.orderStatus == OrderStatus.DELIVERED || this.orderStatus == OrderStatus.CANCELLED){
            throw new IllegalStateException("Cannot cancel an order that is " + this.orderStatus);
        }
    }

    void confirmOrder(PaymentStatus status){

        if(status == PaymentStatus.PENDING){
            orderStatus = OrderStatus.PLACED;
            System.out.println("Order has been placed. Proceeding to payment.");
        }
        else if(status == PaymentStatus.PAID){
            orderStatus = OrderStatus.CONFIRMED;
            System.out.println("Order confirmed!");

        }
        else if(status == PaymentStatus.FAILED){
            orderStatus = OrderStatus.CANCELLED;
            System.out.println("Payment has failed. Order Cancelled!");
        }
        else if(status == PaymentStatus.REFUNDED){
            orderStatus = OrderStatus.CANCELLED;
            System.out.println("Money refunded, place another order");
        }

    }

    void cancelOrder(){

        if(this.orderStatus == OrderStatus.OUT_FOR_DELIVERY || this.orderStatus == OrderStatus.DELIVERED || this.orderStatus == OrderStatus.CANCELLED){

            throw new IllegalArgumentException("The order can no longer be cancelled when it already " + this.orderStatus);
        }
        this.orderStatus = OrderStatus.CANCELLED;
        this.paymentStatus = PaymentStatus.REFUNDED;
        System.out.println("Order " + this.orderNumber + " has been canceled!");
    }

    void calculateDelivery(){
        double deliveryAmt = 0;

        switch(deliveryMethod){
            case COLLECTION : deliveryAmt = 0;break;
            case STANDARD_DELIVERY: deliveryAmt = 35.00; break;
            case EXPRESS_DELIVERY: deliveryAmt = 65.00; break;
            default:
                System.out.println("Invalid Option"); break;
        }
    }

    void display(){

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
        //System.out.println("Delivery Fee   : R " + deliveryFee);
        //System.out.println("Grand Total    : R " + grandTotal);
        System.out.println("========================================\n");
    }
}
