package pl.sda.springtraining.spring;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorPageController {

    @ExceptionHandler(value = Exception.class)
    public String exceptionHandler(Exception e, Model model) {
        model.addAttribute("exception",e.getMessage());
        return "errorPage";
    }
}
