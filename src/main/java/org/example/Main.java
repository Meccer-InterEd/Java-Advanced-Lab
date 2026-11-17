package org.example;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.example.DeliveryMethod.*;
import static org.example.OrderStatus.*;
import static org.example.PaymentStatus.*;

public class Main {
    public static void main(String[] args) {

        Order order = new Order("0000000001", "Siyabonga", 180.22, PAID, COLLECTION, READY_FOR_COLLECTION);
        Order order1 = new Order("0000000002", "Makwa", 250.22, PENDING, STANDARD_DELIVERY, IN_PROGRESS);
        Order order2 = new Order("0000000003", "Lona", 5.15, FAILED, EXPRESS_DELIVERY, PLACED);
        Order order3 = new Order("0000000004", "Ntiyiso", 100.00, PAID, EXPRESS_DELIVERY, OUT_FOR_DELIVERY);

        Order[] orders = {order, order1, order2, order3};
        for (Order _orders : orders) {
            _orders.setCurrentStatus(_orders.getOrderStatus());
            _orders.assignStatus();
            System.out.println();
        }

        CheckoutService checkoutService = new CheckoutService();

        PaymentMethod card = new CardPayment();
        PaymentMethod eft = new InstantEftPayment();
        PaymentMethod voucher = new VoucherPayment();


        processTransaction(checkoutService, card, 20);

        processTransaction(checkoutService, eft, 1670);

        processTransaction(checkoutService, voucher, 200);

        processTransaction(checkoutService, voucher, 150);

        System.out.println("\n-LAB 2-----------Challenge-----------------");
        PaymentMethodFactory paymentMethodFactory = new PaymentMethodFactory();
        paymentMethodFactory.display();

        BookingSummary bookingSummary = new BookingSummary();
        bookingSummary.display();

        AnnotationScanner.scan(CustomerAccountService.class);
        System.out.println("----------------------------------------");
        RoleAnnotationScanner.scan(AccountService.class);
        System.out.println("----------------------------------------");

        List<Vehicle> vehicles = new ArrayList<>();
        vehicles.add(new RentalCar("KK 22 WM GP", "Mercedes Benz", new BigDecimal("500.00")));
        vehicles.add(new RentalMotorcycle("CA 98 DD L", "Yamaha MT-07", new BigDecimal("300.00")));

        for (Vehicle vehicle : vehicles) {
            vehicle.displayDetails();
            System.out.println("2-Day Rental Cost: R" + vehicle.calculateRentalCost(2));
            System.out.println("7-Day Rental Cost: R" + vehicle.calculateRentalCost(7));
            System.out.println();
        }
    }

    private static void processTransaction (CheckoutService service, PaymentMethod method, double amount){
        PaymentResult result = service.checkout(method, amount);

        System.out.println("------------------------------------------------");
        System.out.println("Payment Method : " + method.getDisplayName());
        System.out.println("Result         : " + (result.successful() ? "SUCCESSFUL" : "FAILED"));
        System.out.println("Reference      : " + result.reference());
    }
}
