package pl.camp.it.warehouse.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import pl.camp.it.warehouse.exeptions.LoginAlreadyExistException;
import pl.camp.it.warehouse.exeptions.ValidationExeption;
import pl.camp.it.warehouse.model.User;
import pl.camp.it.warehouse.services.IAuthenticationService;
import pl.camp.it.warehouse.session.SessionObject;
import pl.camp.it.warehouse.validators.UserDataValidator;

import javax.annotation.Resource;

@Controller
public class AuthenticationController {

    @Autowired
    IAuthenticationService authenticationService;

    @Resource
    SessionObject sessionObject;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model) {
        model.addAttribute("userModel", new User());
        this.authenticationService.addCommonInfoToModel(model);
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@ModelAttribute User user) {
        try {
            UserDataValidator.validateLogin(user.getLogin());
            UserDataValidator.validatePassword(user.getPassword());
        } catch (ValidationExeption e) {
            return "redirect:/login";
        }
        authenticationService.authenticate(user);
        if(this.sessionObject.isLogged()) {
            return "redirect:/main";
        }
        return "redirect:/login";
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String register(Model model) {
        model.addAttribute("userModel", new User());
        this.authenticationService.addCommonInfoToModel(model);
        return "register";

    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register2(@ModelAttribute User user, @RequestParam String password2) {
        try {
            UserDataValidator.validateLogin(user.getLogin());
            UserDataValidator.validatePassword(user.getPassword());
            UserDataValidator.validatePasswordMatch(user.getPassword(), password2);
            this.authenticationService.register(user);
        } catch (ValidationExeption | LoginAlreadyExistException e) {
            return "redirect:/register";
        }
        return  "redirect:/main";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout() {
        this.authenticationService.logout();
        return "redirect:/main";
    }
}

