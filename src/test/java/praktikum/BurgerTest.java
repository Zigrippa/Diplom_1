package praktikum;

import junit.framework.TestCase;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import tools.BurgerCreator;
import tools.BurgerGenerator;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest extends TestCase {

    @Mock
    Bun bun;

    @Mock
    Ingredient ingredient;

    @Test
    @DisplayName("Проверка установления значения Bun в объекту Burger")
    public void testSetBuns() {
        BurgerGenerator burgerGenerator = new BurgerGenerator();
        Burger burger = burgerGenerator.generateNewBurger();
        burger.setBuns(bun);
        Mockito.when(bun.getName()).thenReturn("white bun");

        assertEquals("", burger.bun.getName(), "white bun");
    }

    @Test
    @DisplayName("Проверка добавления ингредиента в объект Burger")
    public void testAddIngredient() {
        BurgerGenerator burgerGenerator = new BurgerGenerator();
        Burger burger = burgerGenerator.generateNewBurger();

        burger.addIngredient(ingredient);
        Mockito.when(ingredient.getName()).thenReturn("cheese sauce");
        Mockito.when(ingredient.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(ingredient.getPrice()).thenReturn(150.0F);

        assertTrue("", burger.getReceipt().contains("cheese sauce"));
    }

    @Test
    @DisplayName("Проверка удаления ингредиента из объекта Burger")
    public void testRemoveIngredient() {
        BurgerCreator burgerCreator = new BurgerCreator();
        Burger burger = burgerCreator.createBurger("white bun", "sour cream", "chili sauce",
                "cutlet");

        burger.removeIngredient(2);

        assertFalse("", burger.getReceipt().contains("cutlet"));
    }

    @Test
    @DisplayName("Проверка перемещения ингредиента внутри объекта Burger")
    public void testMoveIngredient() {
        BurgerCreator burgerCreator = new BurgerCreator();
        Burger burger = burgerCreator.createBurger("white bun", "sour cream", "chili sauce",
                "cutlet");

        burger.moveIngredient(2, 0);

        assertEquals("", burger.getReceipt(), burgerCreator.receiptCreator(
                burgerCreator.createBurger("white bun", "cutlet", "sour cream", "chili sauce")));
    }

}