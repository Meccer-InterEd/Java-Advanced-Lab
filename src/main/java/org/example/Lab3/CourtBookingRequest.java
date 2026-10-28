package org.example.Lab3;

import java.time.LocalDate;
import java.time.LocalTime;

public record CourtBookingRequest(
        String customerId,
        int courtNumber,
        LocalDate bookingDate,
        LocalTime startTime,
        int durationMinutes
) {
    public CourtBookingRequest {
        if (customerId == null || customerId.isBlank()) {
            throw new IllegalArgumentException("ID cannot be blank.");
        }

        if (courtNumber < 1) {
            throw new IllegalArgumentException("Court number must be at least 1.");
        }

        if (bookingDate == null) {
            throw new IllegalArgumentException("Booking date is required.");
        }

        if (startTime == null) {
            throw new IllegalArgumentException("Start time is required.");
        }

        if (durationMinutes <= 0) {
            throw new IllegalArgumentException("Duration must be greater than zero.");
        }
    }
}
