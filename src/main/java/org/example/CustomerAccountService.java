package org.example;

public class CustomerAccountService {

    @Audited
    public void updateContactDetails() {
        System.out.println("Contact details updated successfully");
    }

    @Audited
    public void closeAccount() {
        System.out.println("Account Closed");
    }

    public void viewAccount() {
        System.out.println("Viewing Account");
    }
}
