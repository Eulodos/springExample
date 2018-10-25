package pl.sda.springtraining.spring.user;

public class UserExistsException extends RuntimeException {


    public UserExistsException(String message) {
        super(message);
    }
}
