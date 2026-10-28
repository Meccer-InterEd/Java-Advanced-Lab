package lab3.record;

public record CustomerDetails(String id, String fullName,String email,String phoneNumber)
{
     public CustomerDetails{

         if( id == null && id.isBlank() && fullName == null && fullName.isBlank() && email == null && email.isBlank() && phoneNumber == null && phoneNumber.isBlank() )
         {
             throw new IllegalArgumentException("Full name or email address cannot be null or blank");
         }

     }

}
