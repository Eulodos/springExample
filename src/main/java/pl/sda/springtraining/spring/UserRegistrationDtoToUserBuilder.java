package pl.sda.springtraining.spring;


import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Component;

@Component
public class UserRegistrationDtoToUserBuilder {

    public User rewriteDtoToUser(UserRegistrationDto userRegistrationDto) {
        User user = new User();
        user.setFirstName(userRegistrationDto.getFirstName());
        user.setLastName(userRegistrationDto.getLastName());
        user.getUserAddress().setZipCode(userRegistrationDto.getUserAddress().getZipCode());
        user.getUserAddress().setCity(userRegistrationDto.getUserAddress().getCity());
        user.getUserAddress().setCountry(userRegistrationDto.getUserAddress().getCountry());
        user.getUserAddress().setStreet(userRegistrationDto.getUserAddress().getStreet());
        user.setBirthDate(userRegistrationDto.getBirthDate());
        user.setPesel(userRegistrationDto.getPesel());
        user.setEmail(userRegistrationDto.getEmail());
        user.setPassword(DigestUtils.sha512Hex(userRegistrationDto.getPassword()));
        user.setPhone(userRegistrationDto.getPhone());
        user.setPreferEmails(userRegistrationDto.isPreferEmails());
        return user;
    }
}
