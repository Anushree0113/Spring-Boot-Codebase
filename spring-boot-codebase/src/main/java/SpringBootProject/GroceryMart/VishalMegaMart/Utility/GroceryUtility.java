package SpringBootProject.GroceryMart.VishalMegaMart.Utility;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "grocery-items")
public class GroceryUtility {
    public int getId() {
        return id;
    }

    public void setId(int productId) {
        this.id = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Id
    private int id;
    private String name;
    private String description;
    private int price;
    private int quantity;

}
