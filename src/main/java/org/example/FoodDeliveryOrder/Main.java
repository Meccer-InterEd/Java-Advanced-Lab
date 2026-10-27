package org.example.FoodDeliveryOrder;

import java.math.BigDecimal;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        Order o = new Order();
        Order order = new Order(
                "ORD-1001",
                "Lerato",
                new BigDecimal("249.99"),
                DeliveryMethod.STANDARD_DELIVERY
        );

        Thread confirmPaymentThread = new Thread(() -> {

            try{
                order.confirmOrder(order);
            }catch (InterruptedException e){

            }

        }); //closing of confirmPaymentThread

        //start thread to confirm payment made if valid
        confirmPaymentThread.start();

        //Main thread loops asking for payment

        boolean paymentApproval = false; // variable to run loop for payment

        while(!paymentApproval){
            String input = "";
            System.out.println("Enter amount to pay Below: ");
            input = sc.nextLine();
            BigDecimal amountPaid = new BigDecimal(input);

            //test if amount paid is valid using makePayment in order class which returns boolean
            paymentApproval = order.makePayment(amountPaid);

            //if not approved ask for correct amount
            if(!paymentApproval){
                System.out.println("Amount Due is: " + order.getTotalAmount());

                //reset order status using synchronized (safegaurd incase confirmOrder wakes up the payment status will still be pending)
                synchronized (order){
                    order.setPaymentStatus(PaymentStatus.PENDING);
                }
            }

        }

        o.changeStatus(order);


    }
}