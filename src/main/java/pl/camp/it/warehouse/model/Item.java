package pl.camp.it.warehouse.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Item {

    private int id;
    private String name;
    private String producer;
    private int quantity;
    private String description;


}
