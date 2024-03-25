public class Fruit implements Component {
    private String name;

    public Fruit(String name) {
        this.name = name;
    }

    @Override
    public void printName() {
        System.out.println("Фрукт: " + name);
    }
}