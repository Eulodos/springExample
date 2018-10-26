package pl.sda.springtraining.spring.user;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.sda.springtraining.spring.Countries;

@Service
public class UserRegistrationDtoToUserBuilder {

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User rewriteDtoToUser(UserRegistrationDto userRegistrationDTO) {
        User user = new User();
        UserAddress userAddress = new UserAddress();
        user.setUserAddress(userAddress);
        user.setFirstName(userRegistrationDTO.getFirstName());
        user.setLastName(userRegistrationDTO.getLastName());
        user.getUserAddress().setZipCode(userRegistrationDTO.getUserAddressDTO().getZipCode());
        user.getUserAddress().setCity(userRegistrationDTO.getUserAddressDTO().getCity());
        user.getUserAddress().setCountry(Countries.findCountryBySymbol(userRegistrationDTO.getUserAddressDTO().getCountry()));
        user.getUserAddress().setStreet(userRegistrationDTO.getUserAddressDTO().getStreet());
        user.setBirthDate(userRegistrationDTO.getBirthDate());
        user.setPesel(userRegistrationDTO.getPesel());
        user.setEmail(userRegistrationDTO.getEmail());
        user.setPassword(passwordEncoder.encode(userRegistrationDTO.getPassword()));
        user.setPhone(userRegistrationDTO.getPhone());
        user.setPreferEmails(userRegistrationDTO.isPreferEmails());
        return user;
    }
}
