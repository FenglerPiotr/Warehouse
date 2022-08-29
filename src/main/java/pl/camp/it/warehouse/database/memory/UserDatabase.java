package pl.camp.it.warehouse.database.memory;

import org.springframework.stereotype.Component;
import pl.camp.it.warehouse.database.IUserDAO;
import pl.camp.it.warehouse.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class UserDatabase implements IUserDAO {

    private List<User> users = new ArrayList<>();

    public UserDatabase() {
        users.add(new User(1, "admin", "21232f297a57a5a743894a0e4a801fc3"));
        users.add(new User(2, "janusz", "087d9c5e13bdd64a82bef8e013625c32"));
    }

    public List<User> getUsers() {
        return users;
    }

    public Optional<User> getUserByLogin(String login) {
        for(User user : this.users) {
            if(user.getLogin().equals(login)) {
                return Optional.of(user);
            }
        }
        return Optional.empty();
    }

    public boolean isLoginExist(String login) {
        return getUserByLogin(login).isPresent();
    }

    public void addUser(User user) {
        this.users.add(user);
    }
}
