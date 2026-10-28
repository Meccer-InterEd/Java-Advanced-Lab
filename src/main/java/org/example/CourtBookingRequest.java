package org.example;

import java.time.LocalDate;
import java.time.LocalTime;

public record CourtBookingRequest(String customerId, int courtNumber, LocalDate bookingDate, LocalTime startTime, int durationMinutes) {

    public CourtBookingRequest{
        if(courtNumber <1){
            throw new IllegalArgumentException("Court numbers must be above 1");
        }

        if(durationMinutes <0 ){
            throw new IllegalArgumentException("Booking duration must be a positive time");
        }

        if(customerId == null || customerId.isBlank()){
            throw new IllegalArgumentException("Provide an customer id!!");
        }

        if(startTime == null ){
            throw new IllegalArgumentException("Provide a valid start time!!");
        }

        if(bookingDate == null){
            throw new IllegalArgumentException("Provide a valid booking date!!");
        }
    }
}
