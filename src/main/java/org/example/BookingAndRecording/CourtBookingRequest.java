package org.example.BookingAndRecording;

import java.time.LocalDate;
import java.time.LocalTime;

public record CourtBookingRequest(String customerId, int courtNumber, LocalDate bookingDate, LocalTime startTime, int durationMinutes) {
    public CourtBookingRequest{
        if(courtNumber <= 0 || durationMinutes <= 0){
            throw new IllegalArgumentException();
        }
    }
}
