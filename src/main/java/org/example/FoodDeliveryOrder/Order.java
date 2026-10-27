package org.example.FoodDeliveryOrder;

import java.math.BigDecimal;
import java.util.Scanner;

public class Order extends Thread{
    private String orderNumber;
    private String customerName;
    private BigDecimal totalAmount;
    private OrderStatus orderStatus;
    private PaymentStatus paymentStatus;
    private DeliveryMethod deliveryMethod;

    Order(){

    }

    Order(String orderNumber, String customerName, BigDecimal totalAmount, DeliveryMethod deliveryMethod){


        this.orderNumber = orderNumber;
        this.customerName = customerName;
        this.deliveryMethod = deliveryMethod;
        this.totalAmount = totalAmount;

        //Default order status and payment status when order is created through this constructor
        this.paymentStatus = PaymentStatus.PENDING;
        this.orderStatus = OrderStatus.PLACED;
    }

    //Getters
    public DeliveryMethod getDeliveryMethod() {
        return deliveryMethod;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public String getOrderNumber() {
        return orderNumber ;
    }

    public OrderStatus getStatus() {
        return orderStatus;
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

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public void setPaymentStatus(PaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    BigDecimal deliveryFee(Order order){
        DeliveryMethod d = DeliveryMethod.COLLECTION;
        switch(d){
            case STANDARD_DELIVERY -> {return new BigDecimal("35.00");}
            case EXPRESS_DELIVERY -> {return new BigDecimal("65.00");}
            default -> {return new BigDecimal("0.00");}
        }
    }
    //synchronized method that waits for payment Thread to complete then updates payment status and order is then  confirmed
    synchronized void confirmOrder(Order order) throws InterruptedException {
        while(order.paymentStatus != PaymentStatus.PAID){
            System.out.println("Pending Payment.....");
            this.wait();

        }

        if(order.paymentStatus == PaymentStatus.PAID){
            System.out.println("Order Confirmed...");
            order.orderStatus = OrderStatus.CONFIRMED;
            System.out.println("Order Status: " + orderStatus);
        }else{
            System.out.println("Payment was not sucessful");
        }
    }

    synchronized boolean makePayment(BigDecimal amountToPay){

        //check if amount given is enough to pay for order amount if so it continues to confirm order method
        if(amountToPay.compareTo(this.totalAmount) < 0){

            System.out.println("Amount less than required amount for order");
            System.out.println("Enter new Amount");
            this.paymentStatus = PaymentStatus.FAILED;
            this.notifyAll();

            //returns false for unsuccessful payment
            return false;

        }else{
            System.out.println("Payment successful");

            this.paymentStatus = PaymentStatus.PAID;
            this.notifyAll();

            //returns true for a successful payment and changes payment status to Paid
            return true;
        }
    }

    void changeStatus(Order order) throws InterruptedException{
        Scanner sc = new Scanner(System.in);
        String orderJourney = "preparing";
        String option = "";

        //get current order status
        OrderStatus status = order.getStatus();

        //loop through while preparing order
        while(orderJourney.equalsIgnoreCase("preparing"))
        { switch (status){
            case CONFIRMED -> {
                System.out.println("Chef Preparing: ");
                System.out.println("Would you like to cancel order");
                option = sc.nextLine();

                if(option.equalsIgnoreCase("no")){
                    order.setOrderStatus(OrderStatus.PREPARING);
                    displayOrder(order);
                    Thread.sleep(5000);

                } else if(option.equalsIgnoreCase("yes")){
                    orderStatus = OrderStatus.CANCELLED;
                    order.setOrderStatus(OrderStatus.CANCELLED);
                    displayOrder(order);
                    break;
                }
                //cahnge status
                status = OrderStatus.PREPARING;

                break;
            }
            case PREPARING -> {
                System.out.println("Order almost Ready " + "\nWould you like to cancel order");

                option = sc.nextLine();

                if(option.equalsIgnoreCase("no")){
                    Thread.sleep(5000);
                    order.setOrderStatus(OrderStatus.READY_FOR_COLLECTION);
                    displayOrder(order);

                } else if(option.equalsIgnoreCase("yes")){
                    orderStatus = OrderStatus.CANCELLED;
                    order.setOrderStatus(OrderStatus.CANCELLED);
                    displayOrder(order);
                    break;
                }

                status = OrderStatus.READY_FOR_COLLECTION;

                break;
            }
            case READY_FOR_COLLECTION -> {


                System.out.println("Would you like to cancel order?");
                option = sc.nextLine();

                if(option.equalsIgnoreCase("no")){
                    Thread.sleep(5000);
                    order.setOrderStatus(OrderStatus.OUT_FOR_DELIVERY);
                    displayOrder(order);

                } else if(option.equalsIgnoreCase("yes")){
                    orderStatus = OrderStatus.CANCELLED;
                    order.setOrderStatus(OrderStatus.CANCELLED);
                    displayOrder(order);
                    break;
                }

                status = OrderStatus.OUT_FOR_DELIVERY;
                orderJourney = "Done";

            }
            case OUT_FOR_DELIVERY -> {
                displayOrder(order);

            }
        }
        }
    }

    void displayOrder(Order order){
        BigDecimal grandTotal = order.totalAmount;
        //if still preparing print without price
        if(order.getStatus() == OrderStatus.CONFIRMED || order.getStatus() == OrderStatus.PREPARING){

            System.out.println("\nOrder NO: " + order.getOrderNumber() +
                            "\nCustomer Name: " + order.getCustomerName()
                    //"\nStatus: " + order.getStatus()
            );

        }else if(order.getStatus() == OrderStatus.READY_FOR_COLLECTION){

            System.out.println("\nOrder NO: " + order.getOrderNumber() +
                    "\nCustomer Name: " + order.getCustomerName() +
                    "\nStatus: " + order.getStatus() +
                    "\nAwaiting Driver");
        }else if(order.getStatus() == OrderStatus.OUT_FOR_DELIVERY){
            System.out.println("Order NO: " + order.getOrderNumber() +
                    "\nCustomer Name: " + order.getCustomerName() +
                    "\nStatus: " + order.getStatus() +
                    "\nPrice: " + grandTotal.add(deliveryFee(order)) +
                    ("\nDelivery fee: " + deliveryFee(order)));
        }else{
            System.out.println("Order Cancelled");
        }
    }

}
