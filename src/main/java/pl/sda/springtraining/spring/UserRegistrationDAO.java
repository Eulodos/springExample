package pl.sda.springtraining.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserRegistrationDAO {

    private UserRepository userRepository;

    @Autowired
    public UserRegistrationDAO(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}
