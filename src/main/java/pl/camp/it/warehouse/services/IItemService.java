package pl.camp.it.warehouse.services;

import pl.camp.it.warehouse.model.Item;

import java.util.List;

public interface IItemService {
    List<Item> getAllItems();
    List<Item> getFilteredItems(String pattern);
}


