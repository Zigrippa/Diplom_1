package praktikum;


import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import tools.BurgerCreator;
import tools.FakeDatabase;


import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BurgerParameterizedTest {

    private Burger burger;
    private float price;
    private String receipt;

    private static FakeDatabase fakeDatabase = new FakeDatabase();
    private static BurgerCreator burgerCreator = new BurgerCreator();

    public BurgerParameterizedTest(Burger burger, float price, String receipt) {
        this.burger = burger;
        this.price = price;
        this.receipt = receipt;
    }

    @Parameterized.Parameters
        public static Object[][] getSumData() {
            return new Object[][] {
                    {burgerCreator.createBurger("white bun", "sour cream", "dinosaur"), 800.0F,
                            burgerCreator.receiptCreator(
                                    burgerCreator.createBurger("white bun", "sour cream", "dinosaur"))},
                    {burgerCreator.createBurger("black bun", "hot sauce", "dinosaur"), 500.0F,
                            burgerCreator.receiptCreator(
                                    burgerCreator.createBurger("black bun", "hot sauce", "dinosaur"))},
                    {burgerCreator.createBurger("red bun", "chili sauce", "dinosaur"), 1100.0F,
                            burgerCreator.receiptCreator(
                                    burgerCreator.createBurger("red bun", "chili sauce", "dinosaur"))},
                    {burgerCreator.createBurger("white bun", "sour cream", "cutlet"), 700.0F,
                            burgerCreator.receiptCreator(
                                    burgerCreator.createBurger("white bun", "sour cream", "cutlet"))},
                    {burgerCreator.createBurger("black bun", "sour cream", "sausage"), 700.0F,
                            burgerCreator.receiptCreator(
                                    burgerCreator.createBurger("black bun", "sour cream", "sausage"))},
            };
    }

    @Test
    @DisplayName("Проверка цены разных бургеров")
    public void testGetPrice(){
        assertEquals("",
                burger.getPrice(), price, 0.0001);
    }

    @Test
    @DisplayName("Проверка верного написания рецепта разных бургеров")
    public void testGetReceipt(){
        assertEquals("",
                burger.getReceipt(), receipt);
    }

}
