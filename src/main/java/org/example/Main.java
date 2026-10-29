package org.example;

import java.time.LocalDate;
import java.time.LocalTime;

public class Main {
    public static void main(String[] args) {

        CourtBookingRequest courtBookingRequest = new CourtBookingRequest("111", 2, LocalDate.of(2026, 12, 26), LocalTime.of(9, 30), 60);
        Booking booking = new Booking("123", courtBookingRequest);
        booking.confirm();
        //booking.cancel();
        BookingSummary summary = new BookingSummary("Thami", courtBookingRequest.customerId(), courtBookingRequest.courtNumber(), courtBookingRequest.bookingDate(), booking.bookingStatus);
        summary.displayBooking();

    }
}