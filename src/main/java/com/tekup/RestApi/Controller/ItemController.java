package com.tekup.RestApi.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.tags.Tag;
import com.tekup.RestApi.Model.Item;
import com.tekup.RestApi.Repository.ItemRepository;

@Tag(name = "ItemController", description = "the Rest API for service web project")
@RestController
@RequestMapping("Items")

public class ItemController {

    @Autowired
    private ItemRepository repository;

    // Get All Items

    @GetMapping()
    ResponseEntity<List<Item>> selectAllItems() {
        return ResponseEntity.ok(repository.selectAll());
    }

    // Add Item
    @PostMapping()
    ResponseEntity<String> newItem(@RequestBody Item newItem) {
        if (repository.addItem(newItem)==2) {
                return ResponseEntity.ok().body("Created!"); 
        } else if(repository.addItem(newItem)==1) {
                return ResponseEntity.badRequest().body("Item with the same name already exists");
        } else{
                return ResponseEntity.badRequest().body("Verify your Item details");
        }
    }

    // Fetch Item by Name

    @GetMapping("/{name}")
    ResponseEntity<Item> findItemByName(@PathVariable String name) {
        if (repository.recherche(name) != null) {
                return ResponseEntity.ok(repository.recherche(name)); 
            } else {
                return ResponseEntity.notFound().build(); 
            }
    }

    // Delete Item by Name

    @DeleteMapping("/{name}")
    ResponseEntity<String> deleteItem(@PathVariable String name) {
        if (repository.supprimer(name)) {
                return ResponseEntity.ok().body("Deleted!"); 
            } else {
                return ((BodyBuilder) ResponseEntity.notFound()).body("Not Found"); 
            }
    }

}
