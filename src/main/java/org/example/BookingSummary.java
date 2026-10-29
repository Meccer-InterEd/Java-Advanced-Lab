package org.example;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

public record BookingSummary() {

    public void display() {
        System.out.println("-----------------Report-----------------------");
        LocalTime time = LocalTime.from(LocalTime.of(15, 30));
        LocalDate date = LocalDate.from(LocalDate.of(2026, 11, 15));
        CourtBookingRequest courtBookingRequest = new CourtBookingRequest(UUID.randomUUID().toString(), 141, LocalDate.from(date), LocalTime.from(time), 4320);
        CustomerDetails customerDetails = new CustomerDetails("Siyabonga Ngobeni", "sdeut291@gmail.com", "+27784105841");
        Booking booking = new Booking(UUID.randomUUID().toString(), "Pimville", BookingStatus.CONFIRMED, courtBookingRequest, customerDetails);
        System.out.println("Booking ID         : " + booking.getBookingID());
        System.out.println("Customer ID        : " + booking.getCourtBookingRequest().customerId());
        System.out.println("Customer Name      : " + booking.getCustomerDetails().fullName());
        System.out.println("Customer Email     : " + booking.getCustomerDetails().email());
        System.out.println("Customer Number    : " + booking.getCustomerDetails().phoneNumber());
        System.out.println("Location           : " + booking.getBookingLocation());
        System.out.println("Court Number       : " + booking.getCourtBookingRequest().courtNumber());
        System.out.println("Booking Date From  : " + booking.getCourtBookingRequest().bookingDate());
        System.out.println("Booking Time       : " + booking.getCourtBookingRequest().startTime());
        System.out.println("Duration in Minutes: " + booking.getCourtBookingRequest().durationMinutes());
        System.out.println("Booking Status     : " + booking.getBookingStatus());
    }
}
