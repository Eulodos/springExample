package pl.sda.springtraining.spring.user;

import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
public class Role {

    @Id
    @GeneratedValue
    private Integer id;
    private String roleName;


    public Role(String roleName) {
        this.roleName=roleName;
    }


}
