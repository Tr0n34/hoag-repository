package fr.hoag.validators;

import fr.hoag.models.users.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.annotation.Resource;

@Resource
public class UserValidator implements Validator {

    @Value("${user.email.regex}")
    String regexEmail;

    @Value("${user.login.regex}")
    String regexLogin;

    @Value("${user.password.regex}")
    String regexPassword;

    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {

    }

}
