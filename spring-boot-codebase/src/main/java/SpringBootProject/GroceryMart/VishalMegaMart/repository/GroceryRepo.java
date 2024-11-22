package SpringBootProject.GroceryMart.VishalMegaMart.repository;

import SpringBootProject.GroceryMart.VishalMegaMart.Utility.GroceryUtility;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/* Repository of Mongo Operations */
@Repository
public interface GroceryRepo extends MongoRepository<GroceryUtility,Integer> {
}
