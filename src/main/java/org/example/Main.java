package org.example;

import static org.example.DeliveryMethod.*;
import static org.example.OrderStatus.*;
import static org.example.PaymentStatus.*;

public class Main {

    public static void main(String[] args) {

        Order order = new Order("0000000001", "Siyabonga", 180.22, PAID, COLLECTION, READY_FOR_COLLECTION);
        Order order1 = new Order("0000000002", "Makwa", 250.22, PENDING, STANDARD_DELIVERY, PLACED);
        Order order2 = new Order("0000000003", "Lorna", 5.22, FAILED, EXPRESS_DELIVERY, PLACED);
        Order order3 = new Order ("0000000004" , "Ntiyiso" , 100.00, PAID, EXPRESS_DELIVERY , OUT_FOR_DELIVERY);

        Order[] orders = {order, order1, order2, order3};

        for (Order _orders : orders) {
            _orders.setCurrentStatus(_orders.getOrderStatus());
            _orders.assignStatus();
            System.out.println();
        }

        CheckoutService service = new CheckoutService();
        service.checkout(150.50, new CardPayment());
        service.checkout(200.00, new InstantEftPayment());
        service.checkout(50.00, new VoucherPayment());


    }
}