package pl.sda.springtraining.spring.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserRegistrationDAO {

    private UserRepository userRepository;

    @Autowired
    public UserRegistrationDAO(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void saveNewUser(User user) {
        //sprawdzamy czy istnieje
        if (userExists(user.getEmail())) {
            throw new UserExistsException("Użytkownik o emailu " + user.getEmail() + " istnieje!");
        }
        userRepository.save(user);
    }

    public boolean userExists(String email) {
        if (userRepository.findUserByEmail(email) != null) {
            return true;
        }
        return false;
    }
}
