package org.example;

import java.time.LocalDate;
import java.time.LocalTime;

public record CourtBookingRequest(String customerId, int courtNumber, LocalDate bookingDate, LocalTime startTime,
                                  int durationMinutes) {
    public CourtBookingRequest {
        if (courtNumber < 1) {
            throw new IllegalArgumentException("Court numbers must be 1 or greater");
        }

        if (durationMinutes <= 0) {
            throw new IllegalArgumentException("Duration time must be greater than 0 minutes");
        }
    }
}
