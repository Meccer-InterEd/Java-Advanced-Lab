package org.example;

import java.time.LocalDate;
import java.time.LocalTime;

public record BookingSummary(String bookingId, int courtNumber, LocalDate bookingDate, LocalTime startTime,int durationMinutes, BookingStatus status ) {
}
