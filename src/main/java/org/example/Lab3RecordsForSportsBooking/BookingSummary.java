package org.example.Lab3RecordsForSportsBooking;

import java.time.LocalTime;

public record BookingSummary(CustomerDetails cd, CourtBookingRequest bk) {

    void summary() {
        System.out.println("=========BOOKING SUMMARY=======");

        System.out.println("Customer Details:");
        System.out.println("Name: " + cd.fullName() + "\nPhone Number:" + cd.phoneNumber() + "\nEmail:" + cd.email());
        System.out.println("===============================");
        System.out.println("Booking Details:");
        System.out.println("Booking Date:" + bk.bookingDate() + "\nCourt Number:" + bk.courtNumber() + "\nStart Time:  " + bk.startTime() + "\nDuration:" + bk.durationMinutes() + "minutes, \nand this was booked by customerID:" + bk.customerId());
        System.out.println("===============================");
    }
}
