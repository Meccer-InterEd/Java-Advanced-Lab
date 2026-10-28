package org.example.Lab3RecordsForSportsBooking;

import java.time.LocalDate;
import java.time.LocalTime;

public record CourtBookingRequest(String customerId, int courtNumber, LocalDate bookingDate, LocalTime startTime, int durationMinutes) {
    public CourtBookingRequest{
        if(customerId == null || customerId.isBlank()){
            throw new RuntimeException("Error, Customer ID cannot be empty");
        }

        if(courtNumber <=0){
            throw new RuntimeException("Error, Court Number must be above zero");
        }
        if (bookingDate == null) {
            throw new RuntimeException("Error, Booking date cannot be null.");
        }
        if(bookingDate().isBefore(LocalDate.now())){
            throw new RuntimeException("Booking can not be in the past");
        }
    }
}
