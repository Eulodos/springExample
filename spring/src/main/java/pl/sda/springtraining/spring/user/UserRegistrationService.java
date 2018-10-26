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
    public UserRegistrationService(RoleRepository roleRepository, UserRegistrationDAO userRegistrationDAO, UserRegistrationDtoToUserBuilder userRegistrationDtoToUserBuilder) {
        this.roleRepository = roleRepository;
        this.userRegistrationDAO = userRegistrationDAO;
        this.userRegistrationDtoToUserBuilder = userRegistrationDtoToUserBuilder;
    }

    public void registerUser(UserRegistrationDto userRegistrationDto) {
        User user = userRegistrationDtoToUserBuilder.rewriteDtoToUser(userRegistrationDto);
        Role userRole = roleRepository.findRoleByRoleName("ROLE_USER");
        if (userRole == null) {
            userRole = new Role("ROLE_USER");
            roleRepository.save(userRole);
        }
        user.setRoles(Sets.newHashSet(userRole));

        userRegistrationDAO.saveNewUser(user);
    }
}
