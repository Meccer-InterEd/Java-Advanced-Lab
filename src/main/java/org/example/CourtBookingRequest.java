package org.example;

import java.time.LocalDate;
import java.time.LocalTime;

public record CourtBookingRequest(String customerId, int courtNumber, LocalDate bookingDate, LocalTime startTime, int durationMinutes) {
    public CourtBookingRequest {
        if (customerId == null || customerId.isEmpty()) {
            throw new IllegalArgumentException("Customer ID cannot be left empty");
        } else if (courtNumber <= 0) {
            throw new IllegalArgumentException("Number cannot be below 1");
        } else if (durationMinutes < 0) {
            throw new IllegalArgumentException("Duration in minutes cannot be negative");
        }
    }
}
