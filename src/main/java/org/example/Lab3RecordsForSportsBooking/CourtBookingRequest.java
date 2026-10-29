package org.example.Lab3RecordsForSportsBooking;

import java.time.LocalDate;
import java.time.LocalTime;

public record CourtBookingRequest(String customerId, int courtNumber, LocalDate bookingDate, LocalTime startTime,
                                  int durationMinutes) {
    public CourtBookingRequest {
        if (customerId == null || customerId.isBlank()) {
            throw new RuntimeException("Error, Customer ID cannot be empty");
        }

        if (courtNumber < 1) {
            throw new RuntimeException("Error, Court Number must be above zero");
        }
        if (bookingDate == null) {
            throw new RuntimeException("Error, Booking date cannot be null.");
        }
        if (bookingDate.isBefore(LocalDate.now())) {
            throw new RuntimeException("Booking can not be in the past");
        }
        if (startTime == null) {
            throw new RuntimeException("Error, Start time cannot be empty");
        }

        if (durationMinutes <= 0) {
            throw new RuntimeException("Error, Duration minutes can not be zero or a negative number");
        }

        if (durationMinutes < 30 || durationMinutes > 240) {
            throw new RuntimeException("Error, Booking should be at least 30minutes or more than 4 hours ");
        }
    }
}
