package org.example.sport_center;

public class Booking {
    private int bookingId;
    private CourtBookingRequest bookingRequest;
    private BookingStatus status;

    public Booking(int bookingId, CourtBookingRequest bookingRequest){
        this.bookingId = bookingId;
        this.bookingRequest = bookingRequest;
        this.status = BookingStatus.REQUESTED;
    }


    public BookingStatus confirmBooking(){
        if(this.status.equals(BookingStatus.CANCELLED)){
            throw new IllegalArgumentException("Booking is cancelled");
        }

        if (this.status.equals(BookingStatus.CONFIRMED)){
            throw new IllegalArgumentException("Booking already confirmed");
        }
        this.status = BookingStatus.CONFIRMED;
        return status;
    }

    public BookingStatus cancelBooking(){
        if (this.status.equals(BookingStatus.CANCELLED)){
            throw new IllegalArgumentException("Booking already cancelled");
        }

        this.status = BookingStatus.CANCELLED;
        return status;
    }

}
