package pl.camp.it.warehouse.database;

import pl.camp.it.warehouse.model.Item;

import java.util.List;

public interface IItemDAO {
    List<Item> getItems();
}
