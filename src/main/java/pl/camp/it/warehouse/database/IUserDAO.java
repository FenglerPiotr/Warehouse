package pl.camp.it.warehouse.database;

import pl.camp.it.warehouse.model.User;

import java.util.List;
import java.util.Optional;

public interface IUserDAO {
    List<User> getUsers();
    Optional<User> getUserByLogin(String login);
    boolean isLoginExist(String login);
    void addUser(User user);
}
