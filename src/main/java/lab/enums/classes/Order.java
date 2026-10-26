package lab.enums.classes;

import lab.enums.DeliveryMethod;
import lab.enums.OrderStatus;
import lab.enums.PaymentStatus;
import lab.enums.classes.exception.MyException;

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

        if (totalAmount <= 0) {
            throw new IllegalArgumentException("Please enter a valid amount");
        }

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

        if (totalAmount <= 0) {
            throw new IllegalArgumentException("Please enter a valid amount");
        }
        this.totalAmount = totalAmount;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {

        if (orderStatus == OrderStatus.CANCELLED ) {

            if(this.orderStatus == OrderStatus.PLACED)
            {
                this.paymentStatus = PaymentStatus.FAILED;
            }
            else
            {
                this.paymentStatus = PaymentStatus.REFUNDED;
            }

        }
        else if ( orderStatus == OrderStatus.PLACED)
        {
            this.paymentStatus = PaymentStatus.PENDING;
        }
        else {
            this.paymentStatus = PaymentStatus.PAID;
        }

        this.orderStatus = orderStatus;
    }

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(PaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;

        if(paymentStatus == PaymentStatus.PENDING)
        {
            this.orderStatus = OrderStatus.PLACED;
        }
        else if (paymentStatus == PaymentStatus.FAILED || paymentStatus == PaymentStatus.REFUNDED)
        {
            this.orderStatus = OrderStatus.CANCELLED;
        }
        else {
            this.orderStatus = OrderStatus.CONFIRMED;
        }
    }

    public DeliveryMethod getDelivery() {
        return delivery;
    }

    public void setDelivery(DeliveryMethod delivery) throws MyException {

        if (( this.orderStatus == OrderStatus.PLACED || this.orderStatus == OrderStatus.CONFIRMED || this.orderStatus == OrderStatus.PREPARING ))
        {
            if(this.delivery == DeliveryMethod.EXPRESS_DELIVERY)
            {
                totalAmount = this.totalAmount - 65;
            }
            else if(this.delivery == DeliveryMethod.STANDARD_DELIVERY)
            {
                totalAmount = this.totalAmount - 35;
            }
            this.delivery = delivery;
        }
        else {
            throw new MyException("Cannot set delivery method, while almost done");
        }
    }

    private void validatePaymentStatus()
    {
        if( paymentStatus == PaymentStatus.PAID )
        {
            orderStatus = OrderStatus.CONFIRMED;
            System.out.println("Payment Status is " + paymentStatus + " for order " + orderNo + " therefor Order status is " + orderStatus + " \n Order payment succesfful please wait for an update");
        }
        else if(paymentStatus == PaymentStatus.FAILED || paymentStatus == PaymentStatus.REFUNDED ) {
            orderStatus = OrderStatus.CANCELLED;
            System.out.println("Payment Status is " + paymentStatus + " for order " + orderNo + " therefor Order status is " + orderStatus + " \n Feel free to retry the order");
        }
        else
        {
            System.out.println("Payment Status is " + paymentStatus + " for order " + orderNo + " therefor Order status is " + orderStatus + " \n Wait a few");

        }
    }

    public void nextStatus()
    {
        validatePaymentStatus();
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
                    orderStatus = OrderStatus.OUT_FOR_DELIVERY;
                    break;
                    default:
                        orderStatus = OrderStatus.READY_FOR_COLLECTION;
                        deliveryFee = 0;
                break;
            }
            this.totalAmount = this.totalAmount + deliveryFee;
            System.out.println("Order transitioned Successfully with total amount of " + totalAmount  );
        }
        else {

            System.out.println("Order doesnt meet requirements for transitioning");

        }
    }

    public void display() {
        System.out.println("Order No: " + orderNo);
        System.out.println("Customer Name: " + customerName);
        System.out.println("Order Status: " + orderStatus);
        System.out.println("Payment Status: " + paymentStatus);
        System.out.println("Delivery: " + delivery);
        System.out.println("Total Amount: " + totalAmount);
    }

}
