import java.util.ArrayList;
import java.util.List;

//separate class to implement these public methods
public class Order {
    private String name;
    private Time orderTime;
    private List<String> items;

    public Order(String name) {
        this.name = name;
        this.items = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public Time getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Time orderTime) {
        this.orderTime = orderTime;
    }

    public void addItem(String item) {
        items.add(item.toLowerCase());
    }

    public List<String> getItems() {
        return items;
    }

    public String toString() {
        return String.join("\n", items) + "\n";
    }
}