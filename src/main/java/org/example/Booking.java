package org.example;
/*
Create a normal `Booking` class with a
booking ID, a `CourtBookingRequest`, and a `BookingStatus` enum.
The booking can be confirmed or canceled, so its state changes over time.
 */
public class Booking {
    private String bookingId;
    private CourtBookingRequest bookingRequest;
    private BookingStatus bookingStatus;
    private static int bookingNumber = 0;

    public Booking(CourtBookingRequest bookingRequest){
        this.bookingRequest = bookingRequest;
        bookingStatus = BookingStatus.REQUESTED;
    }

    public void confirmBooking(){
        if (bookingStatus.equals(BookingStatus.REQUESTED) &&
                !BookingsRepository.foundDuplicateBooking(this))
        {
            bookingId = "Court" + bookingRequest.courtNumber() + "_" +
                    bookingRequest.bookingDate() + "_" +(Booking.bookingNumber+=1);
            bookingStatus = BookingStatus.CONFIRMED;
            System.out.println("\nYour court booking has been confirmed : (Booking ID -> "+bookingId+")");
        } else if (bookingStatus.equals(BookingStatus.CONFIRMED)){
            System.out.println("\nThis booking has already been confirmed!");
        } else {
            System.out.println("\nFailed to confirm booking because this booking has already gotten cancelled!");
        }
    }

    public void cancelBooking(){
        if (bookingStatus.equals(BookingStatus.CANCELLED)){
            System.out.println("\nThis booking has already gotten canceled!");
        } else {
            bookingStatus = BookingStatus.CANCELLED;
            BookingsRepository.removeBooking(this);
            System.out.println("\nYou have successfully canceled your booking!");
        }

    }

    public CourtBookingRequest getBookingRequest() {
        return bookingRequest;
    }
}
