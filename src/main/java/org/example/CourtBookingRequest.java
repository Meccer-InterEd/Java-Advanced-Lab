package org.example;

import java.time.LocalDate;
import java.time.LocalTime;

public record CourtBookingRequest(
        String customerId,
        int courtNumber,
        LocalDate bookingDate,
        LocalTime startTime,
        int durationMinutes
) {
   public CourtBookingRequest{
       if(courtNumber < 1 ){
           throw new IllegalArgumentException(
                   "Please Enter a valid Court number"
           );
       }

       if(customerId == null || customerId.isBlank()){
           throw new IllegalArgumentException(
                   "Customer ID can not be blank"
           );
       }
       if(bookingDate == null){
           throw new IllegalArgumentException(
                   "Booking date is required"
           );
       }

       if (startTime == null){
           throw new IllegalArgumentException(
                   "Start time is required"
           );
       }

       if (durationMinutes <= 0){
           throw new IllegalArgumentException(
                   "Duration must be 1 minute or more"
           );
       }
   }
}
