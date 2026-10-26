package org.example;

public class Order {
    private int orderNum;
    private String customerName;
    private double totalAmount;
    private OrderStatus status;
    private PaymentStatus paymentStatus;
    private DeliveryMethod deliveryMethod;

    public Order(int orderNum, String customerName, double totalAmount, DeliveryMethod deliveryMethod) {

        if( totalAmount < 0 ){
            throw new IllegalArgumentException("Total amount  less than zero!!");
        }

        this.orderNum = orderNum;
        this.customerName = customerName;
        this.totalAmount = totalAmount;
        this.deliveryMethod = deliveryMethod;

        this.status = OrderStatus.PLACED;
        this.paymentStatus = PaymentStatus.PENDING;
    }

//    public PaymentStatus getPaymentStatus() {
//        return paymentStatus;
//    }

    public void setPaymentStatus(PaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public void confirmOrder(){
        if(paymentStatus != PaymentStatus.PAID){
            throw new IllegalArgumentException("Order cannot be confirmed until payment is successful");
        }

        if(status != OrderStatus.PLACED){
            throw  new IllegalArgumentException("Only a placed order can be confrimed.");
        }

        status = OrderStatus.CONFIRMED;
    }

    public double deliveryFee(){

        return switch (deliveryMethod){
            case COLLECTION -> 0.0;
            case STANDARD_DELIVERY -> 35.0;
            case EXPRESS_DELIVERY -> 65.0;
        };

    }

    public double grandTotal(){
        return totalAmount  + deliveryFee();
    }

    public void nextStatus(){
        if(status == OrderStatus.CANCELLED || status == OrderStatus.DELIVERED){
            throw new IllegalArgumentException("Order cannot be changed.");
        }

        switch(status){
            case PLACED: if(paymentStatus != PaymentStatus.PAID){
                throw new IllegalArgumentException("Payment must be paid first");
            }

            status = OrderStatus.CONFIRMED;
            break;

            case CONFIRMED:
                status = OrderStatus.PREPARING;
                break;

            case PREPARING:
                if(deliveryMethod == DeliveryMethod.COLLECTION){
                    status = OrderStatus.READY_FOR_COLLECTION;
                }
                else{
                    status = OrderStatus.OUT_FOR_DELIVERY;
                }
                break;

            case READY_FOR_COLLECTION:
            case OUT_FOR_DELIVERY:
                status = OrderStatus.DELIVERED;
                break;

            default:
                throw new IllegalArgumentException("Invalid status transition.");
        }
    }

    public void cancelOrder(){
        if(status == OrderStatus.DELIVERED || status == OrderStatus.CANCELLED){
            throw new IllegalArgumentException("Delivered or cancelled orders cannot be changed");
        }

        if(status == OrderStatus.OUT_FOR_DELIVERY){
            throw new IllegalArgumentException("Order cannot be cancelled after dispatch");
        }

        status = OrderStatus.CANCELLED;

        System.out.println("Order cancelled successfully");
    }

    public void displayDetails(){
        System.out.println("---ORDER SUMMARY---");
        System.out.println("Order number: " + orderNum);
        System.out.println("Customer Name: " + customerName);
        System.out.println("Status: " + status);
        System.out.println("Payment Status: " + paymentStatus);
        System.out.println("Delivery Method: " + deliveryMethod);
        System.out.println("Order Total: R" + totalAmount);
        System.out.println("Delivery Fee: R" + deliveryFee());
        System.out.println("Net Total: R" + grandTotal());
        System.out.println(" ");
    }
}
