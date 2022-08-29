package pl.camp.it.warehouse.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.camp.it.warehouse.database.IItemDAO;
import pl.camp.it.warehouse.model.Item;
import pl.camp.it.warehouse.services.IItemService;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Service
public class ItemService implements IItemService {

    @Autowired
    IItemDAO itemDAO;

    public List<Item> getAllItems(){

        return this.itemDAO.getItems();
    }

    @Override
    public List<Item> getFilteredItems(String pattern) {
        List<Item> allItems = this.itemDAO.getItems();
        List<Item> result = new ArrayList<>();
        for (Item item : allItems) {
            if(item.getName().toLowerCase().contains(pattern.toLowerCase())
                    || item.getProducer().toLowerCase().contains(pattern.toLowerCase())) {
                result.add(item);
            }
        }
        return result;
    }
}
