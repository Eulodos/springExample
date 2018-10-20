package pl.sda.springtraining.spring.user;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class UserRegistrationDtoToUserBuilder {

    private PasswordEncoder passwordEncoder;

    @Autowired
    public UserRegistrationDtoToUserBuilder(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    public User rewriteDtoToUser(UserRegistrationDto userRegistrationDto) {
        User user = new User();
        UserAddress userAddress = new UserAddress();
        user.setUserAddress(userAddress);

        user.setFirstName(userRegistrationDto.getFirstName());
        user.setLastName(userRegistrationDto.getLastName());
        user.getUserAddress().setZipCode(userRegistrationDto.getUserAddress().getZipCode());
        user.getUserAddress().setCity(userRegistrationDto.getUserAddress().getCity());
        user.getUserAddress().setCountry(userRegistrationDto.getUserAddress().getCountry());
        user.getUserAddress().setStreet(userRegistrationDto.getUserAddress().getStreet());
        user.setBirthDate(userRegistrationDto.getBirthDate());
        user.setPesel(userRegistrationDto.getPesel());
        user.setEmail(userRegistrationDto.getEmail());
        user.setPassword(passwordEncoder.encode(userRegistrationDto.getPassword()));
        user.setPhone(userRegistrationDto.getPhone());
        user.setPreferEmails(userRegistrationDto.isPreferEmails());
        return user;
    }
}
