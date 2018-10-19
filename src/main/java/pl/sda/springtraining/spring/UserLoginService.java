package pl.sda.springtraining.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserLoginService {
    //Field injection
    private final UserLoginDAO userLoginDAO;

    @Autowired
    public UserLoginService(UserLoginDAO userLoginDAO) {
        this.userLoginDAO = userLoginDAO;
    }
}
