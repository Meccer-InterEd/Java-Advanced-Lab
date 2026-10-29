package org.example;

import java.time.LocalDate;
import java.time.LocalTime;

public record CourtBookingRequest(String customerId, int courtNumber, LocalDate bookingDate,
                                  LocalTime startTime, int durationMinutes) {
    public CourtBookingRequest{
        if  (customerId.isEmpty()) {
            throw new IllegalArgumentException("Customer Id cannot be empty");
        }
        if  (courtNumber==0) {
            throw new IllegalArgumentException("Court Number cannot be empty");
        }
        if  (bookingDate==null) {
            throw new IllegalArgumentException("Booking Date cannot be empty");
        }
        if  (startTime==null) {
            throw new IllegalArgumentException("Start Time cannot be empty");
        }
        if  (durationMinutes==0) {
            throw new IllegalArgumentException("Duration Minutes cannot be empty");
        }
    }
}
