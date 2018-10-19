package pl.sda.springtraining.spring;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Setter
@Getter
public class User {

    @Id
    @GeneratedValue
    private Long id;
    private String firstName;
    private String lastName;
    @Embedded
    private UserAddress userAddress;
    private String birthDate;
    private String pesel;
    private String email;
    private String password;
    private String phone;
    private boolean preferEmails;

}
