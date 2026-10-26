package org.example.FoodDeliveryOrder;

import java.util.Scanner;

public class Order {
  private int orderNumber;
  private String customerName;
  private double totalAmount;
  private OrderStatus status;
  private PaymentStatus paymentStatus;
  private DeliveryMethod deliveryMethod;

    Order(){

    }

    Order(String customerName, int orderNumber, double totalAmount, DeliveryMethod deliveryMethod){
        this.customerName = customerName;
        this.orderNumber = orderNumber;
        this.totalAmount = totalAmount;
        this.deliveryMethod = deliveryMethod;

    }

    Order(int orderNumber, String customerName, double totalAmount, OrderStatus status, PaymentStatus paymentStatus, DeliveryMethod deliveryMethod ){
        this.orderNumber = orderNumber;
        this.customerName = customerName;
        this.totalAmount = totalAmount;
        this.status = status;
        this.paymentStatus = paymentStatus;
        this.deliveryMethod = deliveryMethod;

    }

    //Getters
    public DeliveryMethod getDeliveryMethod() {
        return deliveryMethod;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    public String getCustomerName() {
        return customerName;
    }

    //Setters

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setDeliveryMethod(DeliveryMethod deliveryMethod) {
        this.deliveryMethod = deliveryMethod;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public void setPaymentStatus(PaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    void confirmOrder(double amount, Order order) {
        if(amount < getTotalAmount()){
          //  order.setStatus(OrderStatus.PLACED);
            order.setPaymentStatus(PaymentStatus.PENDING);

            System.out.println("Amount entered lower than required order amount");
        }else if( amount > getTotalAmount()){
            order.setPaymentStatus(PaymentStatus.PAID);
            System.out.println("Order Confirmed");
            order.setStatus(OrderStatus.CONFIRMED);

        }
    }


   /* void moveStatus(Order order){
        Scanner sc = new Scanner(System.in);
        String stat = "";

       if(order.getStatus() == OrderStatus.CONFIRMED){
           order.setStatus(OrderStatus.PREPARING);
       }

       while(order.getStatus() == OrderStatus.PREPARING){
           System.out.println("Preparing order");

           //Chef to change status when prompted
           stat = sc.nextLine();

           if(stat.equalsIgnoreCase("done")){
               order.setStatus(OrderStatus.READY_FOR_COLLECTION);

               System.out.println("Order Ready For Collection");

           }else if(stat.equalsIgnoreCase("cancel")){

               order.setStatus(OrderStatus.CANCELLED);
               System.out.println("Order Cancelled");

       }


       while(order.getStatus() == OrderStatus.READY_FOR_COLLECTION){
           stat = sc.nextLine();

           if(stat.equalsIgnoreCase("fetched")){

               order.setStatus(OrderStatus.OUT_FOR_DELIVERY);
               System.out.println("Customer Can no longer cancel order");

           }else if(stat.equalsIgnoreCase("cancel")){

               order.setStatus(OrderStatus.CANCELLED);
               System.out.println("Order cancelled");
           }
       }

       while(order.getStatus() == OrderStatus.OUT_FOR_DELIVERY){

           stat = sc.nextLine();

           if(stat.equalsIgnoreCase("delivered")){

                order.setStatus(OrderStatus.DELIVERED);
               System.out.println("Order delivered");
           }
       }*/

        double deliveryFee(DeliveryMethod method){
            if(method ==  DeliveryMethod.STANDARD_DELIVERY){
                return 35.00;
            }else if(method ==  DeliveryMethod.EXPRESS_DELIVERY){
                return 65.00;
            }else{
                return 0.00;
            }
        }

        double TotalAmount(DeliveryMethod method){
            double total = 0.00;

            total = this.totalAmount + deliveryFee(method);

            return total;
        }

        void statusChange(OrderStatus status, double amount, Order order){
            switch(status){
                case PLACED :
                    System.out.println("Order Placed Awaiting Payment");
                    confirmOrder(amount, order);

                case CONFIRMED:
                    System.out.println("Order Confirmed");
                    order.setStatus(OrderStatus.PREPARING);

                case PREPARING:
                    System.out.println("Preparing order");
                    order.setStatus(OrderStatus.READY_FOR_COLLECTION);

                case READY_FOR_COLLECTION:
                    System.out.println("Ready for collection");
                    order.setStatus(OrderStatus.OUT_FOR_DELIVERY);

                case OUT_FOR_DELIVERY:
                    System.out.println("Order out for delivery");
                    order.setStatus(OrderStatus.DELIVERED);

                case DELIVERED:
                    System.out.println("Order has been delivered");

               // default: order.setStatus(OrderStatus.CANCELLED);
                    //System.out.println("Cancelled");


            }

        }
       }

