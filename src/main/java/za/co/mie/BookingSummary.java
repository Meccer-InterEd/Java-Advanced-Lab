package za.co.mie;

import java.time.LocalDate;
import java.time.LocalTime;

public record BookingSummary(String booking_id, int court_number, LocalDate booking_date, LocalTime start_time) {

}
