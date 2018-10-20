package pl.sda.springtraining.spring.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserRegistrationService {

    private UserRegistrationDAO userRegistrationDAO;
    private UserRegistrationDtoToUserBuilder userRegistrationDtoToUserBuilder;

    @Autowired
    public UserRegistrationService(UserRegistrationDAO userRegistrationDAO, UserRegistrationDtoToUserBuilder userRegistrationDtoToUserBuilder) {
        this.userRegistrationDAO = userRegistrationDAO;
        this.userRegistrationDtoToUserBuilder = userRegistrationDtoToUserBuilder;
    }

    public void registerUser(UserRegistrationDto userRegistrationDto) {
        User user = userRegistrationDtoToUserBuilder.rewriteDtoToUser(userRegistrationDto);
        userRegistrationDAO.saveNewUser(user);
    }
}
