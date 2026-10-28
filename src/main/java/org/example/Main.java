package org.example;


//import jdk.swing.interop.SwingInterOpUtils;

import java.time.LocalDate;
import java.time.LocalTime;

public class Main {
    public static void main(String[] args) {
        System.out.println("Do good and be productive!!");

        Order order = new Order(001, "Lerato", 249.99, DeliveryMethod.STANDARD_DELIVERY);

        Order order1 = new Order(111,"Lona",199.99, DeliveryMethod.COLLECTION);
        Order order2 = new Order(112,"Siya",1000, DeliveryMethod.EXPRESS_DELIVERY);

        order.displayDetails();

        order1.setPaymentStatus(PaymentStatus.PAID);
        order1.nextStatus();
        order1.nextStatus();
        order1.nextStatus();
        order1.displayDetails();

        order2.cancelOrder();
        order2.setPaymentStatus(PaymentStatus.FAILED);
        order2.displayDetails();


        CheckoutService service = new CheckoutService();
        service.checkout(150.50, new CardPayment());
        service.checkout(200.00, new InstantEftPayment());
        service.checkout(10.00, new VoucherPayment());


        CustomerDetails customer = new CustomerDetails(
                "Sam Smith",
                "sam@example.com",
                "0712345678"
        );

        CourtBookingRequest request =
                new CourtBookingRequest(
                        "C101",
                        2,
                        LocalDate.of(2026, 11, 5),
                        LocalTime.of(10, 0),
                        60
                );

        Booking booking = new Booking("B001", request);

        System.out.println(booking.getStatus());


        booking.confirm();

        System.out.println(booking.getStatus());

        BookingSummary summary = new BookingSummary(
                booking.getBookingId(),
                request.courtNumber(),
                request.bookingDate(),
                request.startTime(),
                request.durationMinutes(),
                booking.getStatus()
        );

        System.out.println(summary);






        }
    }
