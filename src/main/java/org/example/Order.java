package org.example;

import java.math.BigDecimal;

public class Order {
    private String orderNum;
    private String name;
    private BigDecimal totamt;

    DeliveryMethod deliveryMethod ;
    PaymentStatus paymentStatus;
    OrderStatus orderStatus;

    Order(String orderNum, String customerName, String totalAmnt, OrderStatus status, PaymentStatus paymentStatus, DeliveryMethod deliveryMethod){
        this.name = customerName;
        this.orderNum = orderNum;
        this.totamt = Money.of(totalAmnt);
        this.paymentStatus = paymentStatus;
        this.orderStatus = status;
        this.deliveryMethod = deliveryMethod;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOrderNum() {
        return orderNum;
    }

    public BigDecimal getTotamt() {
        return totamt;
    }

    void confirmOrder(){
        if(paymentStatus == PaymentStatus.PAID){
            orderStatus = OrderStatus.CONFIRMED;
            System.out.println("Your Order has been confirmed");
        }else {
            System.out.println("Please Make Payment to confirm Order");
        }
    }
    void cancelOrder(){
        if(orderStatus != OrderStatus.OUT_FOR_DELIVERY){
            orderStatus = OrderStatus.CANCELLED;
        }else {
            System.out.println("Your order cannot be canceled when out for delivery");
        }
    }

    void displayStatus(){
        System.out.println("Customer Name: " + name +
                " Order number: "+ orderNum +
                " Order Status: " + orderStatus +
                " Payment Status: "+ paymentStatus);
    }


    





    //void switch_status(){

   // switch (orderStatus) {
       // case PLACED -> OrderStatus.CONFIRMED;
       // case CONFIRMED -> OrderStatus.PREPARING;
       // case PREPARING -> DeliveryMethod.COLLECTION ? OrderStatus.READY_FOR_COLLECTION : OrderStatus.OUT_FOR_DELIVERY;
     //   case OUT_FOR_DELIVERY -> null;
       // case DELIVERED -> null;

        public void switch_status() {
            switch (orderStatus) {
                case PLACED ->
                        orderStatus = OrderStatus.CONFIRMED;

                case CONFIRMED ->
                        orderStatus = OrderStatus.PREPARING;

                case PREPARING -> {
                    if (deliveryMethod == DeliveryMethod.COLLECTION) {
                        orderStatus = OrderStatus.READY_FOR_COLLECTION;
                    } else {
                        orderStatus = OrderStatus.OUT_FOR_DELIVERY;
                    }
                }

                case OUT_FOR_DELIVERY ->
                        orderStatus = OrderStatus.DELIVERED;

                case READY_FOR_COLLECTION ->
                        orderStatus = OrderStatus.DELIVERED;

                case DELIVERED ->
                        System.out.println("Order has already been delivered.");
            }
        }


    
    public BigDecimal deliveryPrice(){
        switch (this.deliveryMethod){
            case COLLECTION: return new BigDecimal(0.0);
            case STANDARD_DELIVERY: return new BigDecimal(35.00); 
            case EXPRESS_DELIVERY: return new BigDecimal(65.00);
        }
        return null;
    }


}
