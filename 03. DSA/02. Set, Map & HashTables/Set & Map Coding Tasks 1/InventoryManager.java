import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class InventoryManager {
    private List<Item> inventory;

    public InventoryManager() {
        inventory = new ArrayList<>();
    }

//TODO
//    public void addItem(String name, double price, String type) {
//
//    }
//
//    public List<Item> filterByType(String itemType) {
//
//    }
//
//    public List<Item> filterByPriceRange(double minPrice, double maxPrice) {
//
//    }
//
//    public List<Item> filterByMinPrice(double minPrice) {
//
//    }
//
//    public List<Item> filterByMaxPrice(double maxPrice) {
//
//    }

}

class Item {
    private String name;
    private double price;
    private String type;

    public Item(String name, double price, String type) {
        this.name = name;
        this.price = price;
        this.type = type;
    }
}