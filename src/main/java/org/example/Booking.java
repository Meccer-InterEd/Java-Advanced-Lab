package org.example;

public class Booking {
    private final String bookingId;
    private final CourtBookingRequest request;
    private BookingStatus status;

    public Booking(String _bookingId, CourtBookingRequest _request) {
        this.request = _request;
        this.bookingId = _bookingId;

        if  (_bookingId==null || _bookingId.isEmpty()) {
            throw new IllegalArgumentException("Booking ID cannot be empty");
        }
        if (_request==null) {
            throw new IllegalArgumentException("Booking cannot be null");
        }
    }
}
