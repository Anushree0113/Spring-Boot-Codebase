package SpringBootProject.GroceryMart.VishalMegaMart.controller;

import SpringBootProject.GroceryMart.VishalMegaMart.GroceryUtility;
import SpringBootProject.GroceryMart.VishalMegaMart.service.GroceryServiceUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/grocery")
public class GroceryAPIController {

    @Autowired
    GroceryServiceUtility groceryServiceUtility;


    @GetMapping("/get-item/{productId}")
    public Optional<GroceryUtility> getItemById(@PathVariable int productId) {
        return groceryServiceUtility.getDocumentById(productId);
    }

    @PostMapping("/add-item")
    public boolean addItem(@RequestBody GroceryUtility groceryUtility) {
        groceryServiceUtility.insertDocument(groceryUtility);
        return true;
    }

    @DeleteMapping("/delete-item/{productId}")
    public boolean deleteItem(@PathVariable int productId) {
        groceryServiceUtility.deleteDocumentById(productId);
        return true;
    }

    @PutMapping("/update-item/{productId}")
    public boolean updateDocument(@RequestBody GroceryUtility newDoc, @PathVariable int productId) {
        GroceryUtility oldDoc = groceryServiceUtility.getDocumentById(productId).orElse(null);
        if (oldDoc != null) {
            oldDoc.setPrice(newDoc.getPrice());
        }
        groceryServiceUtility.updateDocument(newDoc);
        return true;
    }

}
