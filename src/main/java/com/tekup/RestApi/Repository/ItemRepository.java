package com.tekup.RestApi.Repository;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import org.springframework.stereotype.Component;
import com.tekup.RestApi.Model.Item;
import java.util.Optional;
@Component
public class ItemRepository {

    private static final List<Item> Items = new ArrayList<Item>();

    @PostConstruct
    public void initData() {
        Item Item = new Item();
        Item.setName("Item1");
        Item.setDescription("Toy");
        Item.setPrice(300);
        Items.add(Item);
        Item = new Item();
        Item.setName("Item2");
        Item.setDescription("Tv");
        Item.setPrice(1300);
        Items.add(Item);
        Item = new Item();
        Item.setName("Item3");
        Item.setDescription("Phone");
        Item.setPrice(700);
        Items.add(Item);
        Item = new Item();
        Item.setName("Item4");
        Item.setDescription("Laptop");
        Item.setPrice(3500);
        Items.add(Item);
    }

    public List<Item> selectAll() {
        return Items;
    }

    public int addItem(Item newItem) {
        if (newItem.getName() == null || newItem.getName().isEmpty() ||
        newItem.getDescription() == null || newItem.getDescription().isEmpty()|| newItem.getPrice()==0) {
            return 0;
        }else{
   
        boolean itemExists = Items.stream()
                .anyMatch(item -> item.getName().equalsIgnoreCase(newItem.getName()));
    
        if (itemExists) {
            return 1;
        } else {
            Items.add(newItem);
            return 2;
        }
    }
    }

    public Item recherche (String name){
        Optional<Item> itemOptional = Items.stream()
                .filter(x -> x.getName().equalsIgnoreCase(name))
                .findFirst();

        if (itemOptional.isPresent()) {
            return itemOptional.get();
        } else {
            return null;
        }
    }

    public boolean supprimer(String name) {
        return Items.removeIf(x -> x.getName().equalsIgnoreCase(name));
    }
    

}
