package org.example.sport_center;

import java.time.LocalDate;
import java.time.LocalTime;

public class Main {
    public static void main(String[] args) {
        CustomerDetails c1 = new CustomerDetails("1", "Lethabo", "Lethabo@", "07891");
        System.out.println(c1);
        CourtBookingRequest bookingRequirements = new CourtBookingRequest(c1.customerId(), 12,  LocalDate.of(2026, 11, 5), LocalTime.of(14, 30),60);
        Booking booking = new Booking(1, bookingRequirements);
        System.out.println("Booking: " + booking.confirmBooking());
        System.out.println("Booking: " + booking.cancelBooking());
    }
}
