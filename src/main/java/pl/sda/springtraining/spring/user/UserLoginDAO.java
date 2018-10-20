package pl.sda.springtraining.spring.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserLoginDAO {

    private UserRepository userRepository;
    //constructor injection
    @Autowired
    public UserLoginDAO(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}
