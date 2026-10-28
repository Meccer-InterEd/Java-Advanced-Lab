package org.example;

public class Booking {
    private String bookingId;

    public void Booking(String bookingId){
       setBookingId(bookingId);
    }

    public String getBookingId(){ return bookingId;}

    public void setBookingId(String bookingId){
        this.bookingId = bookingId;
    }
}
