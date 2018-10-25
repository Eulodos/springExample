package pl.sda.springtraining.spring.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.sda.springtraining.spring.Countries;

import javax.validation.Valid;

@Controller
public class UserController {

    private UserRegistrationService userRegistrationService;
    private UserLoginService userLoginService;

    @Autowired
    public UserController(UserRegistrationService userRegistrationService, UserLoginService userLoginService) {

        this.userRegistrationService = userRegistrationService;
        this.userLoginService = userLoginService;
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(@ModelAttribute @Valid UserRegistrationDto userRegistrationDto, BindingResult validationResult, Model model) {
        if (validationResult.hasErrors()) {
            return "registerForm";
        }
        userRegistrationService.registerUser(userRegistrationDto);
        model.addAttribute("userEmail", userRegistrationDto.getEmail());
        return "registerResult";
    }


    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String register(Model model) {
        model.addAttribute("userRegistrationDto", new UserRegistrationDto());
        model.addAttribute("countries", Countries.values());
        return "registerForm";
    }

    @GetMapping(value ="/login")
    public String loginForm() {
        return "loginForm";
    }
}

