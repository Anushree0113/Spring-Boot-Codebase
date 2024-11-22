package SpringBootProject.GroceryMart.VishalMegaMart.service;

import SpringBootProject.GroceryMart.VishalMegaMart.Utility.GroceryUtility;
import SpringBootProject.GroceryMart.VishalMegaMart.repository.GroceryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class GroceryServiceUtility {

    @Autowired
    GroceryRepo groceryRepo;

    //getGrocery Item by Id
    public Optional<GroceryUtility> getDocumentById(int productId) {
        return groceryRepo.findById(productId);
    }

    public void insertDocument(GroceryUtility groceryUtility) {
        groceryRepo.save(groceryUtility);
    }

    public void deleteDocumentById(int productId) {
        groceryRepo.deleteById(productId);
    }

    public void updateDocument(GroceryUtility newDoc) {
        groceryRepo.save(newDoc);
    }
}
