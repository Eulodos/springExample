package pl.sda.springtraining.spring;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRegistrationDto {

    private String firstName;
    private String lastName;
    private UserAddress userAddress;
    private String birthDate;
    private String pesel;
    private String email;
    private String password;
    private String phone;
    private boolean preferEmails;
}
