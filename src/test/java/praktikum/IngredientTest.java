package praktikum;


import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.Assert.assertEquals;

public class IngredientTest {

    @Test
    @DisplayName("Проверка верного возвращения цены класса Ingredient")
    public void testGetPrice() {
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "cheese sauce", 150.0F);
        assertEquals("", 150.0F, ingredient.getPrice(), 0.001);
    }

    @Test
    @DisplayName("Проверка верного возвращения имени класса Ingredient")
    public void testGetName() {
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "cheese sauce", 150.0F);
        assertEquals("", "cheese sauce", ingredient.getName());
    }

    @Test
    @DisplayName("Проверка верного возвращения типа ингредиента enum класса IngredientType класса Ingredient")
    public void testGetType() {
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "cheese sauce", 150.0F);
        assertEquals("", IngredientType.SAUCE, ingredient.getType());
    }
}