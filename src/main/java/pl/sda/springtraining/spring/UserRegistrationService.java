package pl.sda.springtraining.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserRegistrationService {

    private UserRegistrationDAO userRegistrationDAO;

    @Autowired
    public UserRegistrationService(UserRegistrationDAO userRegistrationDAO) {
        this.userRegistrationDAO = userRegistrationDAO;
    }
}
