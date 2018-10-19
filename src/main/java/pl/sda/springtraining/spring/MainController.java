package pl.sda.springtraining.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {

    private UserRegistrationService userRegistrationService;
    private UserLoginService userLoginService;

    @Autowired
    public MainController(UserRegistrationService userRegistrationService, UserLoginService userLoginService) {

        this.userRegistrationService = userRegistrationService;
        this.userLoginService = userLoginService;
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(@ModelAttribute UserRegistrationDto userRegistrationDto) {

        return "registerForm";
    }


    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String register(Model model) {
        model.addAttribute("userRegistrationDto", new UserRegistrationDto());
        return "registerForm";
    }
}

