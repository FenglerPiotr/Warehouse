package pl.camp.it.warehouse.session;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;
import pl.camp.it.warehouse.model.User;


@Component
@SessionScope
public class SessionObject {
    private User user = null;

    private String pattern = null;

    public boolean isLogged() { return this.user != null; }

    public User getUser(){
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getPattern() {
        return pattern;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }
}
