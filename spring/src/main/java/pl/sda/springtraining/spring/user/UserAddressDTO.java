package pl.sda.springtraining.spring.user;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserAddressDTO {

    private String zipCode;
    private String city;
    private String country;
    private String street;
}
