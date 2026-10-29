package org.example;

public class Booking {

    private String bookingID;
    CourtBookingRequest bookingRequest;
    BookingStatus bookingStatus;


    public Booking(String bookingID, CourtBookingRequest bookingRequest){

        this.bookingID = bookingID;
        this.bookingRequest = bookingRequest;
        this.bookingStatus = BookingStatus.REQUESTED;
    }

    void confirm(){

        if(bookingStatus == BookingStatus.CANCELLED){

            throw new RuntimeException("This  booking is already cancelled!");
        }
        bookingStatus = BookingStatus.CONFIRMED;
    }

    void cancel(){

        bookingStatus = BookingStatus.CANCELLED;
    }

}
