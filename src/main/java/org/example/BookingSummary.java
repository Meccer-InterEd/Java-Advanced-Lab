package org.example;

import java.time.LocalDate;

public record BookingSummary(String fullName, String customerID, int courtNumber, LocalDate bookingDate, BookingStatus bookingStatus) {

    void displayBooking(){

        System.out.println("Customer Name : " + fullName);
        System.out.println("Customer ID   : " + customerID);
        System.out.println("Court Number  : " + courtNumber);
        System.out.println("Booking Date  : " + fullName);
        System.out.println("Status        : " + bookingStatus);
    }
}
