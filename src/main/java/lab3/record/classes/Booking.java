package lab3.record.classes;

import lab3.record.BookingSummary;
import lab3.record.CourtBookingRequest;
import lab3.record.CustomerDetails;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Booking {

   public enum BookingStatus{
        REQUESTED,CONFIRMED,CANCELLED,COMPLETED
    }

    private CustomerDetails customerDetails;
    private String bookingId;
    private CourtBookingRequest courtBookingRequest;
    private BookingStatus status;

    public Booking() {
        customerDetails = null;
        bookingId = "";
        courtBookingRequest = null;
        status = BookingStatus.REQUESTED;
    }

    public Booking(CustomerDetails customerDetails , String bookingId, CourtBookingRequest courtBookingRequest, BookingStatus status) {

        if ( bookingId.isBlank() || bookingId != null)
        {
            throw new IllegalArgumentException("bookingId is null or blank");
        }

        this.customerDetails = customerDetails;
        this.bookingId = bookingId;
        this.courtBookingRequest = courtBookingRequest;
        this.status = BookingStatus.REQUESTED;
    }

    public CustomerDetails getCustomerDetails() {
        return customerDetails;
    }

    public void setCustomerDetails(CustomerDetails customerDetails) {
        this.customerDetails = customerDetails;
    }

    public String getBookingId() {
        return bookingId;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

    public CourtBookingRequest getCourtBookingRequest() {
        return courtBookingRequest;
    }

    public void setCourtBookingRequest(CourtBookingRequest courtBookingRequest) {
        this.courtBookingRequest = courtBookingRequest;
    }

    public BookingStatus getStatus() {
        return status;
    }

    public void setStatus(BookingStatus status) {
        this.status = status;
    }

    public void behavior()
    {

        if (courtBookingRequest.bookingDate().equals(LocalDate.now().plusDays(1)))
        {
            status = BookingStatus.CONFIRMED;
        }
        LocalDateTime startTime = LocalDateTime.of (courtBookingRequest.bookingDate() , courtBookingRequest.startTime());
        LocalDateTime endTime = startTime.plusMinutes(courtBookingRequest.durationMinutes());
        if (endTime.isAfter(LocalDateTime.now()))
        {
            status = BookingStatus.COMPLETED;
        }
    }

    public BookingSummary summary ()
    {

        return new BookingSummary(customerDetails,courtBookingRequest, status , bookingId);

    }

}
