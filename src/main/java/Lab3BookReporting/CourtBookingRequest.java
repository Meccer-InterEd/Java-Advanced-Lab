package Lab3BookReporting;
import java.time.LocalDate;
import java.time.LocalTime;

public record CourtBookingRequest(String customerId, int courtNumber, LocalDate bookingDate, LocalTime startTime, int durationMinutes) {

    public CourtBookingRequest(String customerId, int courtNumber, LocalDate bookingDate, LocalTime startTime, int durationMinutes){
        this.customerId = customerId;
        this.courtNumber = courtNumber;
        this.bookingDate = bookingDate;
        this.startTime = startTime;
        this.durationMinutes = durationMinutes;

        if (courtNumber < 1 )
        {
            throw new IllegalArgumentException("Court number must be greater than 1");
        } else if (durationMinutes <= 0) {
            throw new IllegalArgumentException("Duration cannot be negative");
        }else if(bookingDate == null){
            throw new IllegalArgumentException("Booking date is needed");

        } else if (startTime == null) {
            throw new IllegalArgumentException("We need a valid start time");
        } else if (customerId == null) {
            throw new IllegalArgumentException("Customer ID cannot be empty");
            
        }
    }
}
