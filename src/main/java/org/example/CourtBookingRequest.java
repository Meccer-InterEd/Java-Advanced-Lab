package org.example;

import java.time.LocalDate;
import java.time.LocalTime;

public record CourtBookingRequest(String customerId, int courtNumber, LocalDate bookingDate, LocalTime startTime, int durationMinutes)
{

    public CourtBookingRequest{

        if(customerId.isBlank()){

            throw new IllegalArgumentException("Customer ID cannot be blank!");
        }
        if(courtNumber <= 0){

            throw new IllegalArgumentException("We dont have court 0 or beyond that!");
        }
        if(durationMinutes < 1){
            throw new IllegalArgumentException("Minutes cannot be zero or negative");
        }
    }
}
