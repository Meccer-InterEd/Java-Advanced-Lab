package org.example.sport_center;

import java.time.*;

public record CourtBookingRequest(String customerId,
                                  int courtNumber,
                                  LocalDate bookingDate,
                                  LocalTime startTime,
                                  int durationMinutes) {
    public CourtBookingRequest {
        if (courtNumber < 1 && durationMinutes <= 0){
            throw new IllegalArgumentException("Invalid input");
        }
    }
}
