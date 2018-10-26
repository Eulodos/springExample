package pl.sda.springtraining.spring;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Profile("dev")
@Controller
public class DevMainController {

    @RequestMapping(value = "/")
    public String home(Model model) {
        model.addAttribute("msg", "devik");
        return "index";
    }
}
