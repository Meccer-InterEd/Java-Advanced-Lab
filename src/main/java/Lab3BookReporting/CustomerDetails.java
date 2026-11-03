package Lab3BookReporting;

public record CustomerDetails(String fullName, String email, String phoneNumber) {

    public CustomerDetails(String fullName, String email, String phoneNumber){
        this.fullName = fullName;
        this.email = email;
        this.phoneNumber = phoneNumber;

        if (email == null || email.equals(" "))
        {
            throw new IllegalArgumentException("Email you have entered is empty or invalid");
        } else if (fullName == null || fullName.equals(" ")) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
    }


}
