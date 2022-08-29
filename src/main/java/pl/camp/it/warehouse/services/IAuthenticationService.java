package pl.camp.it.warehouse.services;

import org.springframework.ui.Model;
import pl.camp.it.warehouse.model.User;

public interface IAuthenticationService {
    void authenticate(User user);
    void register(User user);
    void logout();
    void addCommonInfoToModel(Model model);
}
