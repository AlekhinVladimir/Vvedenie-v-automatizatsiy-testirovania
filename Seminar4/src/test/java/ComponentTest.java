import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class ComponentTest {
    static Component apple;
    static Component carrot;
    static Basket fruitBasket;
    static Basket mixedBasket;

    @BeforeAll
    static void init() {
        apple = new Fruit("Яблоко");
        carrot = new Vegetable("Морковь");
        fruitBasket = new Basket("Фруктовая корзина");
        mixedBasket = new Basket("Смешанная корзина");

        fruitBasket.addItem(apple);
        mixedBasket.addItem(carrot);
        mixedBasket.addItem(fruitBasket);
    }

    @Test
    void testFruitBasketItemsCount() {
        Assertions.assertEquals(1, fruitBasket.getItemsCount());
    }

    @Test
    void testMixedBasketItemsCount() {
        Assertions.assertEquals(2, mixedBasket.getItemsCount());
    }

    @Test
    void testAddAndRemoveItem() {
        Component banana = new Fruit("Банан");
        int initialCount = mixedBasket.getItemsCount();

        mixedBasket.addItem(banana);
        Assertions.assertEquals(initialCount + 1, mixedBasket.getItemsCount());

        mixedBasket.removeItem(banana);
        Assertions.assertEquals(initialCount, mixedBasket.getItemsCount());
    }
}