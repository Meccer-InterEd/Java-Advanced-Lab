package org.example.Lab3RecordsForSportsBooking;

public class Booking {
    private String bookingId;
    private CourtBookingRequest request;
    private BookingStatus status;

    Booking(String bookingId, CourtBookingRequest request, BookingStatus status) {
        this.bookingId = bookingId;
        this.request = request;
        this.status = status;
    }

    void confirmBooking() {
        if (this.status == BookingStatus.CANCELLED) {
            throw new IllegalArgumentException("BookingId:" + this.bookingId + " can not be confirmed as it has been cancelled");
        }
        this.status = BookingStatus.CONFIRMED;
        System.out.println("BookingId:" + this.bookingId + " has been Confirmed successfully");
    }

    void cancelBooking() {
        if (this.status == BookingStatus.CANCELLED) {
            System.out.println("BookingId:" + this.bookingId + " has already been Cancelled");
            return;
        }
        this.status = BookingStatus.CANCELLED;
        System.out.println("BookingId:" + this.bookingId + " has been Cancelled");
    }


}
