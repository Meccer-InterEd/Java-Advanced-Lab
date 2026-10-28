package org.example;

import java.time.LocalDate;
import java.time.LocalTime;

public record CourtBookingRequest(String customerId, int courtNumber, LocalDate bookingDate, LocalTime startTime, int durationMinutes) {
    public CourtBookingRequest{
        if(customerId.equals(null)){
            throw new IllegalArgumentException("Customer ID can not be blank.");
        }
        if(courtNumber < 0 ){
            throw new IllegalArgumentException(courtNumber + "Invalid court number");
        }
        if(durationMinutes <=0 ){
            throw new IllegalArgumentException("Invalid duration");
        }
    }
}
