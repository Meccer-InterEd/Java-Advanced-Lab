package lab3.record;

import java.time.LocalDate;
import java.time.LocalTime;

public record CourtBookingRequest(
        String customerId,
        int courtNumber,
        LocalDate bookingDate,
        LocalTime startTime,
        int durationMinutes
) {
    public CourtBookingRequest {

       if ( (customerId == null || customerId.isBlank()) || (courtNumber <= 0) || (bookingDate == null || !bookingDate.isBefore( LocalDate.now().plusDays(2) ) ) || ( startTime == null || durationMinutes <= 0) )
       {
        throw new IllegalArgumentException("Please check ur god damn details");
       }
   }
}
