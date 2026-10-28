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
        Booking booking = new Booking(UUID.randomUUID().toString(), "Siyabonga", "Pimville", BookingStatus.CONFIRMED, courtBookingRequest);
        System.out.println("Customer Name      : " + booking.getFullName());
        System.out.println("Booking ID         : " + booking.getBookingID());
        System.out.println("Customer ID        : " + booking.getCourtBookingRequest().customerId());
        System.out.println("Location           : " + booking.getBookingLocation());
        System.out.println("Court Number       : " + booking.getCourtBookingRequest().courtNumber());
        System.out.println("Booking Date From  : " + booking.getCourtBookingRequest().bookingDate());
        System.out.println("Booking Time       : " + booking.getCourtBookingRequest().startTime());
        System.out.println("Duration in Minutes: " + booking.getCourtBookingRequest().durationMinutes());
        System.out.println("Booking Status     : " + booking.getBookingStatus());

    }
}
