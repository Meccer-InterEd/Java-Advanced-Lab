package org.example;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

public record CourtBookingRequest (String customerId, int courtNumber, LocalDate bookingDate,
                                  LocalTime startTime, int durationMinutes) {
    public CourtBookingRequest{
        try{
            if (customerId == null || customerId.isBlank()){
                AlertService.inputValidationAlerts("\nCustomer Id value must be provided!!!");
            } else if (courtNumber <= 0){
                AlertService.inputValidationAlerts("\nCourt Number cannot be less than 1!!!");
            } else if (Objects.requireNonNull(bookingDate()).isBefore(LocalDate.now())){
                AlertService.inputValidationAlerts("\nBooking Date cannot be null or set in the past!!!");
            } else if (startTime.isBefore(LocalTime.now())){
                AlertService.inputValidationAlerts("\nStart Time cannot be set in the past!!!");
            } else if (durationMinutes < 10){
                AlertService.inputValidationAlerts("\nSession Duration cannot be less than 10 minutes");
            }
        } catch (InterruptedException e){
            System.out.println(e.getMessage());
        }
    }

}
