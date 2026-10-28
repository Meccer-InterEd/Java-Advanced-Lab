package org.example;

public class Booking {
    String bookingId;
    CourtBookingRequest request;
    BookingStatus status;

    public Booking(String bookingId, CourtBookingRequest request) {


        this.bookingId = bookingId;
        this.request = request;
        this.status = BookingStatus.REQUESTED;
    }

    public void confirm(){
        if(status != BookingStatus.REQUESTED){
            throw new IllegalArgumentException("Only bookings that are requested can be confirmed.");
        }

        status = BookingStatus.CONFIRMED;
    }

    public void cancel(){
        if(status == BookingStatus.CANCELLED){
            throw new IllegalArgumentException("Booking is already cancelled!!");
        }

        status = BookingStatus.CANCELLED;
    }

    public String getBookingId() {
        return bookingId;
    }

    public BookingStatus getStatus() {
        return status;
    }

    public CourtBookingRequest getRequest() {
        return request;
    }
}
