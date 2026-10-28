package org.example.Lap03_Records_BookingSystem;

public class Booking {
   private final String BookingId;
   private final CourtBookingRequest request;
    private BookingStatus status;

    public Booking(String bookingId, CourtBookingRequest request, BookingStatus status) {
        this.BookingId = bookingId;
        this.request = request;
        this.status = status;
    }

    public String getBookingId() {
        return BookingId;
    }

    public CourtBookingRequest getRequest() {
        return request;
    }

    public BookingStatus getStatus() {
        return status;
    }
     public String ConfirmingBooking(){
        if(status == BookingStatus.CONFIRMED){
            return "The booking cannot confirmed";
        }
        status = BookingStatus.CONFIRMED;
         return " Booking is confirmed";
     }
     public String ConcellingBooking(){
        if(status == BookingStatus.CONFIRMED){
            return " Booking can not cancel";
        }
        status = BookingStatus.CANCELLED;
        return " Booking is concelled sucessfully";
     }
}
