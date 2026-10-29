package za.co.mie;

import java.time.LocalDate;
import java.time.LocalTime;

public record CourtBookingRequest(String customer_id, int court_number, LocalDate booking_date, LocalTime start_time, int duration_minutes) {
    public CourtBookingRequest {
        if (customer_id == null || customer_id.isBlank()) throw new IllegalArgumentException("Customer id must not be blank");
        if (court_number < 1) throw new IllegalArgumentException("Court number must be 1 or more");
        if (booking_date == null || start_time == null) throw new IllegalArgumentException("Date and start time are required");
        if (duration_minutes <= 0) throw new IllegalArgumentException("Duration must be greater than zero");
    }
}
