package org.example.Lap03_Records_BookingSystem;

import java.time.LocalDate;
import java.time.LocalTime;

public record BookingSummary(String bookingId,
                             String customerName,
                             int courtNumber,
                             LocalDate bookingDate,
                             LocalTime startTime,
                             int durationMinutes,
                             BookingStatus status) {


    }

