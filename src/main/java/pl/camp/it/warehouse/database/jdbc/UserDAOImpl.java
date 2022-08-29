package pl.camp.it.warehouse.database.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pl.camp.it.warehouse.database.IItemDAO;
import pl.camp.it.warehouse.database.IUserDAO;
import pl.camp.it.warehouse.model.Item;
import pl.camp.it.warehouse.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class UserDAOImpl implements IUserDAO {

    @Autowired
    Connection connection;

    @Override
    public List<User> getUsers() {
        List<User> users = new ArrayList<>();
        try {
            String sql = "SELECT * FROM tuser;";
            PreparedStatement ps = this.connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                users.add(new User(rs.getInt("id"),
                        rs.getString("login"),
                        rs.getString("password")));
            }

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        return users;
    }

    @Override
    public Optional<User> getUserByLogin(String login) {
        try {
            String sql = "SELECT * FROM tuser WHERE login = ?;";
            PreparedStatement ps = this.connection.prepareStatement(sql);
            ps.setString(1, login);
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                return Optional.of(new User(rs.getInt("id"),
                        rs.getString("login"),
                        rs.getString("password")));
            }else {
                return Optional.empty();
            }
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean isLoginExist(String login) {
        return false;
    }

    @Override
    public void addUser(User user) {

    }
}
