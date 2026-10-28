package org.example.Lab3;

public class Booking {
    private final String bookingId;
    private final CourtBookingRequest request;
    private BookingStatus status;

    public Booking(String bookingId, CourtBookingRequest request) {

        if (bookingId == null || bookingId.isBlank()) {
            throw new IllegalArgumentException("ID cannot be blank.");
        }

        if (request == null) {
            throw new IllegalArgumentException("Booking request required.");
        }

        this.bookingId = bookingId;
        this.request = request;
        this.status = BookingStatus.REQUESTED;
    }

    public void confirm() {
        if (status != BookingStatus.REQUESTED) {
            throw new IllegalStateException("Only requested bookings"
            );
        }

        status = BookingStatus.CONFIRMED;
    }

    public void cancel() {
        if (status == BookingStatus.CANCELLED) {
            throw new IllegalStateException("Booking is already cancelled.");
        }

        status = BookingStatus.CANCELLED;
    }

    public String getBookingId() {
        return bookingId;
    }

    public CourtBookingRequest getRequest() {
        return request;
    }

    public BookingStatus getStatus() {
        return status;
    }
}
