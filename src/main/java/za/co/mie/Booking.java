package za.co.mie;

public class Booking {
    private final String booking_id;
    private final CourtBookingRequest request;
    private BookingStatus status = BookingStatus.REQUESTED;

    public Booking(String booking_id, CourtBookingRequest request) {
        if (booking_id == null || booking_id.isBlank()) throw new IllegalArgumentException("Booking id must not be blank");
        if (request == null) throw new IllegalArgumentException("Booking request is required");
        this.booking_id = booking_id;
        this.request = request;
    }

    public void confirm() {
        if (status != BookingStatus.REQUESTED) throw new IllegalStateException("Booking is " + status + ", cannot confirm");
        status = BookingStatus.CONFIRMED;
    }

    public void cancel() {
        if (status == BookingStatus.CANCELLED) throw new IllegalStateException("Booking already cancelled");
        status = BookingStatus.CANCELLED;
    }

    public BookingSummary summary() {
        return new BookingSummary(booking_id, request.court_number(), request.booking_date(), request.start_time());
    }

    public void display_results() {
        System.out.println("Booking " + booking_id + " | court " + request.court_number() + " | " + request.booking_date() + " " + request.start_time() + " | " + request.duration_minutes() + " min | " + status);
    }
}
