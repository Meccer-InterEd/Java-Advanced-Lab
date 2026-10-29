package org.example;

import java.time.LocalDate;
import java.time.LocalTime;

public record CourtBookingRequest(String customerId, int courtNumber, LocalDate bookingDate,
                                  LocalTime startTime, int durationMinutes) {
}
