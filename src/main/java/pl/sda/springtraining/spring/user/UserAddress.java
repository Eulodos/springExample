package pl.sda.springtraining.spring.user;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;

@Setter
@Getter
@Embeddable
public class UserAddress {

    private String zipCode;
    private String city;
    private String country;
    private String street;
}
