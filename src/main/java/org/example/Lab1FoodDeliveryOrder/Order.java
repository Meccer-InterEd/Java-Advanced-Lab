package org.example.Lab1FoodDeliveryOrder;

import java.math.BigDecimal;

public class Order {
    private String orderNum;
    private String custName;
    private BigDecimal totalAmount;
    private OrderStatus orderStatus;
    private PaymentStatus paymentStatus;
    private DeliveryMethod deliveryMethod;
    OrderStatus stat;



    public Order(String orderNum, String custName, BigDecimal totalAmount, DeliveryMethod deliveryMethod){

        if (totalAmount.doubleValue() <= 0)
        {
            throw new IllegalArgumentException("Enter a valid Amount");
        }

        this.orderNum = orderNum;
        this.custName = custName;

        this.deliveryMethod = deliveryMethod;
        this.orderStatus = OrderStatus.PLACED;
        this.paymentStatus = PaymentStatus.PENDING;

        this.totalAmount = totalAmount.add(deliveryMethod.determineDeliveryFee(deliveryMethod))  ;
    }

    Order(){

    }



    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public DeliveryMethod getDeliveryMethod() {
        return deliveryMethod;
    }

    public void setDeliveryMethod(DeliveryMethod deliveryMethod) {

        if( ! ( orderStatus == OrderStatus.PLACED || orderStatus == OrderStatus.CONFIRMED || orderStatus == OrderStatus.PREPARING )) {

            throw new IllegalArgumentException("Delivery cant be changed");
        }



        this.deliveryMethod = deliveryMethod;


    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {

        if( !( this.orderStatus == OrderStatus.PLACED || this.orderStatus == OrderStatus.CONFIRMED || this.orderStatus == OrderStatus.PREPARING) )
        {

           throw  new IllegalArgumentException("An order cant be changed");
        }
        else if(orderStatus == OrderStatus.PLACED)
        {
            setPaymentStatus(PaymentStatus.PENDING);
        }
        else if( orderStatus == OrderStatus.CANCELLED)
        {
            setPaymentStatus(PaymentStatus.REFUNDED);
        }
        else
        {
            setPaymentStatus(PaymentStatus.PAID);
        }

        this.orderStatus = orderStatus;


    }

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(PaymentStatus paymentStatus) {
         if(paymentStatus == PaymentStatus.PENDING)
         {
             setOrderStatus(OrderStatus.PLACED);
         }
         else if(paymentStatus == PaymentStatus.PAID)
         {
             setOrderStatus(OrderStatus.CONFIRMED);

         }
         else {
             setOrderStatus(OrderStatus.CANCELLED);
         }

        this.paymentStatus = paymentStatus;
    }





    public void confirmPayment(BigDecimal amount){
        totalAmount = totalAmount.add(deliveryMethod.determineDeliveryFee(deliveryMethod));
        if(amount.compareTo(totalAmount) >=0 ){
            paymentStatus = PaymentStatus.PAID;
            System.out.println("Payment is successful");
            orderStatus = OrderStatus.CONFIRMED;
            System.out.println("Order: " + orderNum + " is confirmed");
        }
        else {
            orderStatus = OrderStatus.PLACED;
            paymentStatus = PaymentStatus.FAILED;
            System.out.println("Payment has failed due to insufficient funds:  Required Amount R"+ totalAmount);
        }
    }



    void display()
    {
        System.out.println(orderStatus + " " + orderNum + " " + paymentStatus + " " + deliveryMethod  + " " + totalAmount);
    }







}
