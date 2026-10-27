package lab2.records;

public record PaymentResult(boolean succesful, String reference, String message) {

    public PaymentResult {
        if( reference == null || reference.isBlank() || message == null || message.isBlank() )
        {
            throw new IllegalArgumentException("No null or blank messages allowed");
        }
    }


}
