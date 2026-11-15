package org.example;
import java.time.LocalDate;
import java.time.LocalTime;
// contains what a daily report would need, which is a booking id and the status of the booking
public record BookingSummary(String bookingId, BookingStatus status, LocalDate bookingDate, LocalTime startTime) {
}
