package org.example;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;

public record BookingSummary() {

    public void display() {
        System.out.println("-----------------Report-----------------------");
        LocalTime time = LocalTime.from(LocalTime.of(15, 30));
        LocalTime time1 = LocalTime.from(LocalTime.of(20, 30));
        LocalTime time2 = LocalTime.from(LocalTime.of(23, 30));

        LocalDate date = LocalDate.from(LocalDate.of(2026, 11, 15));
        LocalDate date1 = LocalDate.from(LocalDate.of(2026, 12, 15));
        LocalDate date2 = LocalDate.from(LocalDate.of(2027, 1, 15));

        CourtBookingRequest courtBookingRequest = new CourtBookingRequest(UUID.randomUUID().toString(), 141, LocalDate.from(date), LocalTime.from(time), 1000);
        CourtBookingRequest courtBookingRequest1 = new CourtBookingRequest(UUID.randomUUID().toString(), 141, LocalDate.from(date1), LocalTime.from(time1), 2500);
        CourtBookingRequest courtBookingRequest2 = new CourtBookingRequest(UUID.randomUUID().toString(), 141, LocalDate.from(date2), LocalTime.from(time2), 480);

        CustomerDetails customerDetails = new CustomerDetails("Siyabonga", "sdeut291@gmail.com", "+27784105841");
        CustomerDetails customerDetails1 = new CustomerDetails("Makwa", "makwa@gmail.com", "+27657352631");
        CustomerDetails customerDetails2 = new CustomerDetails("Lona", "lona@gmail.com", "+27826154374");


        Booking booking = new Booking(UUID.randomUUID().toString(), "Pimville", BookingStatus.CONFIRMED, courtBookingRequest, customerDetails);
        Booking booking1 = new Booking(UUID.randomUUID().toString(), "Roodepoort", BookingStatus.CANCELLED, courtBookingRequest1, customerDetails1);
        Booking booking2 = new Booking(UUID.randomUUID().toString(), "Gold reef", BookingStatus.REQUESTED, courtBookingRequest2, customerDetails2);

        Booking[] bookings = {booking, booking1, booking2};

        for (Booking _bookings: bookings) {
            System.out.println("Booking ID         : " + _bookings.getBookingID());
            System.out.println("Customer ID        : " + _bookings.getCourtBookingRequest().customerId());
            System.out.println("Customer Name      : " + _bookings.getCustomerDetails().fullName());
            System.out.println("Customer Email     : " + _bookings.getCustomerDetails().email());
            System.out.println("Customer Number    : " + _bookings.getCustomerDetails().phoneNumber());
            System.out.println("Location           : " + _bookings.getBookingLocation());
            System.out.println("Court Number       : " + _bookings.getCourtBookingRequest().courtNumber());
            System.out.println("Booking Date From  : " + _bookings.getCourtBookingRequest().bookingDate());
            System.out.println("Booking Time       : " + _bookings.getCourtBookingRequest().startTime());
            System.out.println("Duration in Minutes: " + _bookings.getCourtBookingRequest().durationMinutes());
            System.out.println("Booking Status     : " + _bookings.getBookingStatus());
            System.out.println();
        }


    }
}
