// Класс для овощей.
public class Vegetable implements Component {
    private String name;

    public Vegetable(String name) {
        this.name = name;
    }

    @Override
    public void printName() {
        System.out.println("Овощ: " + name);
    }
}