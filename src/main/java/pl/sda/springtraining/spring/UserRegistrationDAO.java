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

    public void saveNewUser(User user) {
        if (userExists(user.getEmail())) {
            throw new UserExistsException("Użytkownik " + user.getEmail() + " już istnieje");
        }
        userRepository.save(user);
    }

    public boolean userExists(String email){
        if (userRepository.findUserByEmail(email) != null) {

        }
        return false;
    }
}
