package org.example;

import static org.example.DeliveryMethod.*;
import static org.example.OrderStatus.*;
import static org.example.PaymentStatus.*;

public class Main {

    public static void main(String[] args) {

        Order order = new Order("0000000001", "Siyabonga", 180.22, PAID, COLLECTION);
        Order order1 = new Order("0000000002", "Makwa", 250.22, PENDING, STANDARD_DELIVERY);
        Order order2 = new Order("0000000003", "Lorna", 5.22, FAILED, EXPRESS_DELIVERY);

        Order[] orders = {order, order1, order2};
        for (Order _orders : orders) {
            _orders.orderDetails();
        }
    }
}