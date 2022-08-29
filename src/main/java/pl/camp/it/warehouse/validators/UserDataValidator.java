package pl.camp.it.warehouse.validators;

import pl.camp.it.warehouse.exeptions.ValidationExeption;

public class UserDataValidator {
    public static void validateLogin(String login) {
        if(login.length() < 5) {
            throw new ValidationExeption();
        }
    }

    public static void validatePassword(String password) {
        if(password.length() <5) {
            throw new ValidationExeption();
        }
    }

    public static void validatePasswordMatch(String password1, String password2) {
        if(!password1.equals(password2)) {
            throw new ValidationExeption();
        }
    }
}
