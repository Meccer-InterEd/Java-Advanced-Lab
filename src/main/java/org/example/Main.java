package org.example;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static org.example.DeliveryMethod.*;
import static org.example.OrderStatus.*;
import static org.example.PaymentStatus.*;

public class Main {

    public static void main(String[] args) {

        System.out.println("LAB 1");
        Order order = new Order("0000000001", "Siyabonga", 180.22, PAID, COLLECTION, READY_FOR_COLLECTION);
        Order order1 = new Order("0000000002", "Makwa", 250.22, PENDING, STANDARD_DELIVERY, PLACED);
        Order order2 = new Order("0000000003", "Lorna", 5.22, FAILED, EXPRESS_DELIVERY, PLACED);
        Order order3 = new Order("0000000004", "Ntiyiso", 100.00, PAID, EXPRESS_DELIVERY, OUT_FOR_DELIVERY);

        Order[] orders = {order, order1, order2, order3};

        for (Order _orders : orders) {
            _orders.setCurrentStatus(_orders.getOrderStatus());
            _orders.assignStatus();
            System.out.println();
        }

        System.out.println("LAB 2");
        CheckoutService service = new CheckoutService();
        service.checkout(150.50, new CardPayment());
        service.checkout(200.00, new InstantEftPayment());
        service.checkout(50.00, new VoucherPayment());

        System.out.println("LAB 3");
        // creating objects of the class
        CustomerDetails c1 = new CustomerDetails("Siyabonga Ngobeni", "siyabonangobz@gmail.com", "0763452891");
        CustomerDetails c2 = new CustomerDetails("Lona Hans", "lonahans123@hotmail.com", "0822341069");
        CustomerDetails c3 = new CustomerDetails("Hishaam Kraft", "krafthishaam@yahoo.com", "0666783561");

        //objects of the CourtBookingRequest
        CourtBookingRequest r1 = new CourtBookingRequest("R001", 2,
                LocalDate.of(2026, 11, 18), LocalTime.of(10, 0), 60);
        CourtBookingRequest r2 = new CourtBookingRequest("R002", 4,
                LocalDate.of(2026, 5, 22), LocalTime.of(2, 45), 35);
        CourtBookingRequest r3 = new CourtBookingRequest("R003", 8,
                LocalDate.of(2026, 8, 15), LocalTime.of(13, 0), 25);


        Booking b1 = new Booking("B001", c1, r1);
        Booking b2 = new Booking("B002", c2, r2);
        Booking b3 = new Booking("B003", c3, r3);
        b1.confirmedBooking();
        b2.canceledBooking();
        b2.confirmedBooking(); // this will cause an error since the b2 has already been cancelled, it can not be confirmed after
        b1.getRequest().bookingDate();
        b1.getRequest().startTime();
        b2.getRequest().bookingDate();
        b2.getRequest().startTime();
        b3.getRequest().bookingDate();
        b3.getRequest().startTime();

        List<BookingSummary> summaries = new ArrayList<>();

        Booking[] bookings = {b1, b2, b3};

        for (Booking b : bookings) {
            BookingSummary summary = new BookingSummary(
                    b.getBookingId(),
                    b.getStatus(),
                    b.getRequest().bookingDate(),
                    b.getRequest().startTime()

            );

            summaries.add(summary);
        }

        summaries.sort(
                Comparator.comparing(BookingSummary::bookingDate).thenComparing(BookingSummary::startTime)
        );

        System.out.println("---DAILY BOOKING REPORT---");
        for (BookingSummary summary : summaries) {

            System.out.println("Booking ID: " + summary.bookingId());
            System.out.println("Booking Status: " + summary.status());
            System.out.println("Booking Date: " + summary.bookingDate());
            System.out.println("Start Time: " + summary.startTime());

            System.out.println();
        }

        int confirmed = 0;
        int requested = 0;
        int cancelled = 0;

        System.out.println("--- CUSTOMER DETAILS ---");

        for (Booking b : bookings) {

            System.out.println("Booking ID: " + b.getBookingId());
            System.out.println("Customer Details:");
            System.out.println(b.getDetails().fullName());
            System.out.println(b.getDetails().email());
            System.out.println(b.getDetails().phoneNumber());

            System.out.println();

            if (b.getStatus() == BookingStatus.REQUESTED) {
                requested++;
            } else if (b.getStatus() == BookingStatus.CONFIRMED) {
                confirmed++;
            } else {
                cancelled++;
            }
        }

        System.out.println("--- BOOKING STATISTICS ---");
        System.out.println("Number of requested bookings: " + requested);
        System.out.println("Number of confirmed bookings: " + confirmed);
        System.out.println("Number of cancelled bookings: " + cancelled);

    }
}