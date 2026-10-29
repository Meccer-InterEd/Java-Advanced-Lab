package za.co.mie;

public record CustomerDetails(String full_name, String email, String phone_number) {
    public CustomerDetails {
        if (full_name == null || full_name.isBlank()) throw new IllegalArgumentException("Full name must not be blank");
        if (email == null || !email.contains("@") || !email.contains(".")) throw new IllegalArgumentException("Invalid email: " + email);
        if (phone_number == null || phone_number.isBlank()) throw new IllegalArgumentException("Phone number must not be blank");
    }
}
