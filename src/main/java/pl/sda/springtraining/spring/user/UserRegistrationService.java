package pl.sda.springtraining.spring.user;

import com.google.common.collect.Sets;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserRegistrationService {

    private UserRegistrationDAO userRegistrationDAO;
    private UserRegistrationDtoToUserBuilder userRegistrationDtoToUserBuilder;
    private RoleRepository roleRepository;

    @Autowired
    public UserRegistrationService(UserRegistrationDAO userRegistrationDAO, UserRegistrationDtoToUserBuilder userRegistrationDtoToUserBuilder, RoleRepository roleRepository) {
        this.userRegistrationDAO = userRegistrationDAO;
        this.userRegistrationDtoToUserBuilder = userRegistrationDtoToUserBuilder;
        this.roleRepository = roleRepository;
    }

    public void registerUser(UserRegistrationDto userRegistrationDto) {
        User user = userRegistrationDtoToUserBuilder.rewriteDtoToUser(userRegistrationDto);
        Role userRole = roleRepository.findRoleByRoleName("USER");
        if (userRole == null) {
            userRole = new Role("USER");
            roleRepository.save(userRole);
        }
        user.setRoles(Sets.newHashSet(userRole));

        userRegistrationDAO.saveNewUser(user);
    }
}
