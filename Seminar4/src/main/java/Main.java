public class Main {
    public static void main(String[] args) {
        Component apple = new Fruit("Яблоко");
        Component carrot = new Vegetable("Морковь");
        Basket basket = new Basket("Моя корзина");

        basket.addItem(apple);
        basket.addItem(carrot);

        basket.printName(); // Выведет названия корзины и всех ее содержимых элементов
    }
}