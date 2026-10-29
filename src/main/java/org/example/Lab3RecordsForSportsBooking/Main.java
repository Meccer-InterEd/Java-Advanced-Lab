package org.example.Lab3RecordsForSportsBooking;

import java.time.LocalDate;
import java.time.LocalTime;

public class Main {
    public static void main(String[] args) {

        try {
            CustomerDetails customer1 = new CustomerDetails("Thabang", "Thabang@gmail.com", "0817830230");

            CourtBookingRequest bookRequest1 = new CourtBookingRequest("Cust 911", 3, LocalDate.now().plusDays(5), LocalTime.of(15, 30), 60);

            BookingSummary summary1 = new BookingSummary(customer1, bookRequest1);
            summary1.summary();
        } catch (Exception e) {
            System.out.println("Unexpected Error: " + e.getMessage());
        }

        try {
            CustomerDetails customer2 = new CustomerDetails("Motsei", "Motseiatgmail.com", "081783");

            CourtBookingRequest bookRequest2 = new CourtBookingRequest("Customer-912", 3, LocalDate.now().minusDays(2), LocalTime.of(12, 45), 10);

            BookingSummary summary2 = new BookingSummary(customer2, bookRequest2);
            summary2.summary();
        } catch (Exception e) {
            System.out.println("Unexpected Error: " + e.getMessage());
        }
    }
}
