package pl.sda.springtraining.spring.user;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import pl.sda.springtraining.spring.Countries;

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
        user.getUserAddress().setZipCode(userRegistrationDto.getUserAddressDTO().getZipCode());
        user.getUserAddress().setCity(userRegistrationDto.getUserAddressDTO().getCity());
        user.getUserAddress().setCountry(Countries.findCountryByCountryCode(userRegistrationDto.getUserAddressDTO().getCountry()));
        user.getUserAddress().setStreet(userRegistrationDto.getUserAddressDTO().getStreet());
        user.setBirthDate(userRegistrationDto.getBirthDate());
        user.setPesel(userRegistrationDto.getPesel());
        user.setEmail(userRegistrationDto.getEmail());
        user.setPassword(passwordEncoder.encode(userRegistrationDto.getPassword()));
        user.setPhone(userRegistrationDto.getPhone());
        user.setPreferEmails(userRegistrationDto.isPreferEmails());
        return user;
    }
}
