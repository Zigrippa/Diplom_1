package tools;

import praktikum.Burger;

import java.util.Random;

/**
 * Инструмент для генерации рандомного бургера для проведения тестов.
 */
public class BurgerGenerator {

    private final Random random = new Random();
    private final FakeDatabase fakeDatabase = new FakeDatabase();

    public Burger generateNewBurger() {
        Burger burger = new Burger();
        burger.setBuns(fakeDatabase.availableBuns().get(random.nextInt(3)));
        for (int i = 0; i < random.nextInt(3) + 2; i++) {
            burger.addIngredient(fakeDatabase.availableIngredients().get(random.nextInt(6)));
        }

        return burger;

    }

}
