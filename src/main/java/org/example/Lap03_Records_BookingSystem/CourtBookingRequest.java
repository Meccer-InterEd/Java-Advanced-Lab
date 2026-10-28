package org.example.Lap03_Records_BookingSystem;

import java.time.LocalDate;
import java.time.LocalTime;

public record CourtBookingRequest(
        String customerId,
        int countNumber,
        LocalDate bookingDate,
        LocalTime startTime,
        int durationMinutes) {


}
