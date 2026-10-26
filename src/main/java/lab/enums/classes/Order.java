package lab.enums.classes;

import lab.enums.DeliveryMethod;
import lab.enums.OrderStatus;
import lab.enums.PaymentStatus;

public class Order {

    private int orderNo;
    private String customerName;
    private double totalAmount;
    private OrderStatus orderStatus;
    private PaymentStatus  paymentStatus;
    private DeliveryMethod delivery;


    public Order() {
        orderNo = 0;
        customerName = "";
        totalAmount = 0;
        orderStatus = OrderStatus.CANCELLED;
        paymentStatus = PaymentStatus.PENDING;
        delivery = DeliveryMethod.EXPRESS_DELIVERY;
    }

    public Order(int orderNo, double totalAmount, String customerName, DeliveryMethod delivery) {
        this.orderNo = orderNo;
        this.totalAmount = totalAmount;
        this.customerName = customerName;
        this.orderStatus = OrderStatus.PLACED;
        this.paymentStatus = PaymentStatus.PENDING;
        this.delivery = delivery;
    }

    public int getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(int orderNo) {
        this.orderNo = orderNo;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(PaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public DeliveryMethod getDelivery() {
        return delivery;
    }

    public void setDelivery(DeliveryMethod delivery) {
        this.delivery = delivery;
    }

    void validatePaymentStatus()
    {

        if( paymentStatus == PaymentStatus.PAID )
        {

            orderStatus = OrderStatus.CONFIRMED;

        }

        else if(paymentStatus == PaymentStatus.FAILED || paymentStatus == PaymentStatus.REFUNDED )
        {

            orderStatus = OrderStatus.CANCELLED;

        }

        System.out.println("Payment Status is " + paymentStatus + " for order " + orderNo + " therefor Order status is " + orderStatus );

    }

    void transitionPaymentStatus()
    {
        if( paymentStatus == PaymentStatus.PAID )
        {

            orderStatus = OrderStatus.PREPARING;
            System.out.println("Order is being prepared, wait a few");

            DeliveryMethod delivery = this.delivery;

            double deliveryFee = 0;

            switch(delivery)
            {
                case EXPRESS_DELIVERY:
                    deliveryFee = 65;
                    orderStatus = OrderStatus.OUT_FOR_DELIVERY;
                    break;
                case STANDARD_DELIVERY:
                    deliveryFee = 35;
                    break;
                    default:
                        deliveryFee = 0;
                break;

            }




        }
        else {

            System.out.println("Order doesnt meet requirements for transitioning");

        }
    }






}
