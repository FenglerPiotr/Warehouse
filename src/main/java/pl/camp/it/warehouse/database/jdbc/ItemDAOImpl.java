package pl.camp.it.warehouse.database.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import pl.camp.it.warehouse.database.IItemDAO;
import pl.camp.it.warehouse.model.Item;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ItemDAOImpl implements IItemDAO {

    @Autowired
    Connection connection;
    @Override
    public List<Item> getItems() {
        List<Item> items = new ArrayList<>();
        try {
            String sql = "SELECT * FROM titem;";
            PreparedStatement ps = this.connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                items.add(new Item(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("producer"),
                        rs.getInt("quantity"),
                        rs.getString("description")));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return items;
    }
}
