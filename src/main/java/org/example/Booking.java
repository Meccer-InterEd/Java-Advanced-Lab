package org.example;

import jdk.swing.interop.SwingInterOpUtils;

public class Booking {
    private String bookingId;

    public void Booking(String bookingId){
       setBookingId(bookingId);
    }

    public String getBookingId(){ return bookingId;}

    public void setBookingId(String bookingId){
        this.bookingId = bookingId;
    }

    // store what is in the CustomerDetails record so that I can use it call the parameters
    // only methods inside the same class can have access to it
    private CustomerDetails details;

    void confirmedBooking(BookingStatus booking){
        if (booking == BookingStatus.CONFIRMED){
            System.out.println("Your boodking has been cofirmed");
            System.out.println("Name: " + details.fullName());
            System.out.println("Email: " + details.email());
        } else if (booking == BookingStatus.REQUESTED){
            System.out.println("Your booking has been requestd: ");
            System.out.println("Pending booking details: ");
            System.out.println();
        } else {
            System.out.println("Your booking has been cancelled");
        }
    }
}
