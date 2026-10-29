package org.example;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

import static org.example.DeliveryMethod.*;
import static org.example.OrderStatus.*;
import static org.example.PaymentStatus.*;

public class Main {

    public static void main(String[] args) {

        System.out.println("LAB 1");
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

        System.out.println("LAB 2");
        CheckoutService service = new CheckoutService();
        service.checkout(150.50, new CardPayment());
        service.checkout(200.00, new InstantEftPayment());
        service.checkout(50.00, new VoucherPayment());

        System.out.println("LAB 3");
        // creating an objects of the record
        CustomerDetails c1 = new CustomerDetails("Siyabonga Ngobeni", "siyabonangobz@gmail.com", "0763452891");
        CustomerDetails c2 = new CustomerDetails("Lona Hans", "lonahans123@hotmail.com", "0822341069");
        CustomerDetails c3 = new CustomerDetails("Hishaam Kraft", "krafthishaam@yahoo.com", "0666783561");
        // creating objects of the class

        LocalDate date = LocalDate.from(LocalDate.of(2026, 11, 22));
        LocalTime time = LocalTime.from(LocalTime.of(13, 45, 12));
        CourtBookingRequest d1 = new CourtBookingRequest(UUID.randomUUID().toString(), 4, date, time, 35);
        CourtBookingRequest d2 = new CourtBookingRequest(UUID.randomUUID().toString(), 2 , date, time, 12);
        CourtBookingRequest d3 = new CourtBookingRequest(UUID.randomUUID().toString(), 10, date, time, 55);

        Booking b1 = new Booking("B001", c1, d1);
        Booking b2 = new Booking("B002", c2, d2);
        Booking b3 = new Booking("B003", c3, d3);
        b1.confirmedBooking();
        b2.canceledBooking();
        b2.confirmedBooking(); // this will cause an error since the b2 has already been cancelled, it can not be confirmed after



        Booking[] bookings = {b1, b2, b3};
        int confirmed = 0;
        int requested = 0;
        int cancelled = 0;

        System.out.println("---DAILY BOOKING REPORT---");
        for(Booking b : bookings){
            // create an object for the BookingSummary record
            System.out.println("Booking Id: " + b.getBookingId());
            System.out.println("Booking Status: " + b.getStatus());
            System.out.println("Customer Details: ");
            System.out.println("Name: " + b.getDetails().fullName());
            System.out.println("Email: " + b.getDetails().email());
            System.out.println("Phone number: " + b.getDetails().phoneNumber());
            System.out.println("Customer Id: " + b.getRequest().customerId());
            System.out.println("Court Number: " + b.getRequest().courtNumber());
            System.out.println("Booking date: " + b.getRequest().bookingDate());
            System.out.println("Start time:" + b.getRequest().startTime());
            System.out.println("Duration: " + b.getRequest().durationMinutes());

            System.out.println();

            if(b.getStatus() == BookingStatus.REQUESTED){
                requested ++;
            } else if(b.getStatus() == BookingStatus.CONFIRMED){
                confirmed ++;
            } else {
                cancelled ++;
            }
        }

        System.out.println("Number of requested booking: " + requested);
        System.out.println("Number of confirmed booking: " + confirmed);
        System.out.println("Number of cancelled bookings: " + cancelled);





    }
}