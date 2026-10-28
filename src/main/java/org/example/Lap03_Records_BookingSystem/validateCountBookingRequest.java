package org.example.Lap03_Records_BookingSystem;

import java.time.LocalDate;
import java.time.LocalTime;

public class validateCountBookingRequest {
    public String validate(CourtBookingRequest request) {
        if (request == null) {
            return "Booking request is required";
        }
        if (request.customerId() == null) {
            return "Customer Id are required";

        }
        if (request.countNumber() < 1) {
            return " Count number can not be less than 1";
        }
        if (request.bookingDate() == null) {
            return "Booking date is required";
        }
        if (request.startTime() == null) {
            return "Booking time is required";
        }
        if (request.durationMinutes()<= 0) {
            return "duration munutes cannot be the past";
        }

        if (request.bookingDate().isBefore(LocalDate.now()) && request.startTime().isBefore(LocalTime.now())) {
            return "You cannot use the passed date and time";
        }
        return " booking request is required";
    }
}
