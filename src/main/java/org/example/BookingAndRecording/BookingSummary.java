package org.example.BookingAndRecording;

import java.time.LocalDate;
import java.time.LocalTime;

public record BookingSummary(int courtNumber, LocalDate date, LocalTime time, CustomerDetails customerDetails) {

}
