package pl.sda.springtraining.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
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
