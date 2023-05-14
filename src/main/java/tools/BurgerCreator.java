package tools;

import praktikum.Burger;
import praktikum.Ingredient;

/**
 * Инструмент для более удобного создания бургера для проведения тестов.
 * Два метода: Создание бургера, создание рецепта для бургера.
 */
public class BurgerCreator {

    private final FakeDatabase fakeDatabase = new FakeDatabase();

    public Burger createBurger(String bunName, String ... ingredientName) {

        Burger burger = new Burger();


        switch (bunName) {
            case ("black bun"):
                burger.setBuns(fakeDatabase.availableBuns().get(0));
                break;
            case ("white bun"):
                burger.setBuns(fakeDatabase.availableBuns().get(1));
                break;
            case ("red bun"):
                burger.setBuns(fakeDatabase.availableBuns().get(2));
                break;
        }

        for (String s : ingredientName) {
            switch (s) {
                case ("hot sauce"):
                    burger.addIngredient(fakeDatabase.availableIngredients().get(0));
                    break;
                case ("sour cream"):
                    burger.addIngredient(fakeDatabase.availableIngredients().get(1));
                    break;
                case ("chili sauce"):
                    burger.addIngredient(fakeDatabase.availableIngredients().get(2));
                    break;
                case ("cutlet"):
                    burger.addIngredient(fakeDatabase.availableIngredients().get(3));
                    break;
                case ("dinosaur"):
                    burger.addIngredient(fakeDatabase.availableIngredients().get(4));
                    break;
                case ("sausage"):
                    burger.addIngredient(fakeDatabase.availableIngredients().get(5));
                    break;
            }

        }

        return burger;

    }

    public String receiptCreator(Burger burger) {

        StringBuilder receipt = new StringBuilder(String.format("(==== %s ====)%n", burger.bun.getName()));

        for (Ingredient ingredient : burger.ingredients) {
            receipt.append(String.format("= %s %s =%n", ingredient.getType().toString().toLowerCase(),
                    ingredient.getName()));
        }

        receipt.append(String.format("(==== %s ====)%n", burger.bun.getName()));
        receipt.append(String.format("%nPrice: %f%n", burger.getPrice()));

        return receipt.toString();

    }

}
