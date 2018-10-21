package pl.sda.springtraining.spring.user;

import lombok.Getter;
import lombok.Setter;
import pl.sda.springtraining.spring.Countries;

import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Setter
@Getter
@Embeddable
public class UserAddress {

    private String zipCode;
    private String city;
    @Enumerated(EnumType.STRING)//domyślnie jest ordinal, który weźmie numer enuma
    private Countries country;
    private String street;
}
