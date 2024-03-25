import java.util.ArrayList;
import java.util.List;

// Класс для корзины, который может содержать фрукты и овощи.
public class Basket implements Component {
    private List<Component> items = new ArrayList<>();
    private String name;

    public Basket(String name) {
        this.name = name;
    }

    public void addItem(Component item) {
        items.add(item);
    }

    public void removeItem(Component item) {
        items.remove(item);
    }

    @Override
    public void printName() {
        System.out.println("Корзина: " + name);
        for (Component item : items) {
            item.printName();
        }
    }
    public int getItemsCount() {
        return items.size();
    }
}
