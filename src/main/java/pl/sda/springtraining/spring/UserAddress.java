package pl.sda.springtraining.spring;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserAddress {

    private String zipCode;
    private String city;
    private String country;
    private String street;
}
