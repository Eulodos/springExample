package pl.sda.springtraining.spring.user;

import lombok.Getter;
import lombok.Setter;
import pl.sda.springtraining.spring.BaseEntity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Setter
@Getter
public class User extends BaseEntity {

    private String firstName;
    private String lastName;
    @Embedded // zawierajace sie w
    private UserAddress userAddress;
    private String birthDate;
    private String pesel;
    private String email;
    private String password;
    private String phone;
    private boolean preferEmails;
    @ManyToMany
    @JoinTable(name = "user_role")
    private Set<Role> roles;

}
