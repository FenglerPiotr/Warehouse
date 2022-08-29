package pl.camp.it.warehouse.database.memory;

import lombok.Data;
import org.springframework.stereotype.Component;
import pl.camp.it.warehouse.database.IItemDAO;
import pl.camp.it.warehouse.model.Item;

import java.util.ArrayList;
import java.util.List;
@Data

public class ItemDatabase implements IItemDAO {

    private List<Item> items = new ArrayList<>();

    public ItemDatabase() {
        items.add(new Item(1, "Long_drink", "IKEA", 60, "IKEA VARDAGEN 310ml"));
        items.add(new Item(2, "Short_drink", "IKEA", 60, "IKEA POKAL 270ml"));
        items.add(new Item(3, "Coupe", "APS", 36, "Nicea Coupe Economy Line 230ml"));
        items.add(new Item(4, "Short_JD", "Brown-Forman", 120, "JACK DANIELS short 330ml"));
        items.add(new Item(5, "Shot_JD", "Brown-Forman", 60, "JACK DANIELS shot 60ml"));
    }
}
