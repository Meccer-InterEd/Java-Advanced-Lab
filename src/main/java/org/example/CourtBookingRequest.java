package org.example;

import java.time.LocalDate;
import java.time.LocalTime;

public record CourtBookingRequest(String customerId, int courtNumber, LocalDate bookingDate, LocalTime startTime, int durationMinutes) {
    public CourtBookingRequest{
        if(customerId == null && customerId.isEmpty()){
            throw new IllegalArgumentException("Customer ID can not be blank.");
        }
        if(courtNumber < 0 || courtNumber > 100){
            throw new IllegalArgumentException(courtNumber + "Invalid court number");
        }
        if(durationMinutes <=0 ){
            throw new IllegalArgumentException("Invalid duration");
        }
    }
}
