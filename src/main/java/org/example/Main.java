package org.example;

import static org.example.DeliveryMethod.*;
import static org.example.OrderStatus.*;
import static org.example.PaymentStatus.*;

public class Main {
    public static void main(String[] args) {

        Order order = new Order("0000000001", "Siyabonga", 180.22, PAID, COLLECTION);
        Order order1 = new Order("0000000002", "Makwa", 250.22, PENDING, STANDARD_DELIVERY);
        Order order2 = new Order("0000000003", "Lona", 5.05, FAILED, EXPRESS_DELIVERY);

        Order[] orders = {order, order1, order2};


        for (Order _orders : orders) {
            double deliveryFee = switch (_orders.getDeliveryMethod()) {
                case EXPRESS_DELIVERY -> 65.00;
                case STANDARD_DELIVERY -> 35.00;
                case COLLECTION -> 0.0;
            };

            if (_orders.getStatus() == PENDING) {
                System.out.println("\nAwaiting Payment");
                _orders.nextStatus(CONFIRMED);

            } else if (_orders.getStatus() == PAID) {
                System.out.println("\nPayment Successful");
                _orders.nextStatus(CONFIRMED);

            } else if (_orders.getStatus() == FAILED) {
                System.out.println("\nPayment Failed");
                _orders.nextStatus(CANCELLED);

            } else {
                throw new IllegalArgumentException("Invalid Payment Status Match");
            }

            System.out.println("Customer Name: " + _orders.getCustomerName());
            System.out.println("Order status: " + _orders.getOrderStatus());
            System.out.printf("Total Amount is: R%.2f\n", _orders.getTotalAmount());
            System.out.printf("Delivery fee is: R%.2f\n", deliveryFee);
            System.out.printf("Grand Total Amount: R%.2f\n", (_orders.getTotalAmount() + deliveryFee));
        }
    }

}
