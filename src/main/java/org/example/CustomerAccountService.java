package org.example;

public class CustomerAccountService {

    @Audited(reason = "Updating customer contact details")
    @RequireRole("ADMIN")
    public void updateContactDetails(){
        System.out.println("Contact details have been updated");

    }

    @Audited(reason = "Closing customer account")
    @RequireRole("MANAGER")
    public void closeAccount(){
        System.out.println("Account closed");

    }
    public void viewAccount(){
        System.out.println("Viewing account");

    }
}
