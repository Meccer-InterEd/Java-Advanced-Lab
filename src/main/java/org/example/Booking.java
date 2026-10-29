package org.example;

public class Booking {
    private final String bookingId;
    private final CourtBookingRequest request;
    private BookingStatus status;

    Booking(String bookingId, CourtBookingRequest request, BookingStatus status) {
        this.bookingId = bookingId;
        this.request = request;
        this.status = BookingStatus.REQUESTED;
        if (bookingId == null) {
            throw new IllegalArgumentException(
                    "Booking ID can not be blank"
            );
        }

        if (request == null) {
            throw new IllegalArgumentException(
                    "Booking request can not be null"
            );
        }
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

    void confirm() {
        if (status == BookingStatus.CANCELLED) {
            throw new IllegalArgumentException(
                    "Booking Cancelled and can not be confirmed");
        } else if (status == BookingStatus.CONFIRMED) {
            System.out.println("Booking Confirmed, Booking ID: " + bookingId);
        }


    }

    void cancel() {
        if (status == BookingStatus.CANCELLED) {
            throw new IllegalArgumentException(
                    "Booking already cancelled");
        } status = BookingStatus.CANCELLED; {
            System.out.println("Booking Cancelled");

        }
    }
CustomerDetails customerDetails;



    void displayBooking(){
        System.out.println("Customer ID: " + request.customerId() +
                        "\nBooking ID: " + bookingId +
                "\nCourt Number: " + request.courtNumber() +
                "\nBooking Date: " + request.bookingDate() +
                "\n Start Time: " + request.startTime() +
                "\n Duration In Minutes: " + request.durationMinutes()
        );
    }
}

