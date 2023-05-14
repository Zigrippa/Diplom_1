package praktikum;

import junit.framework.TestCase;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.Assert.assertEquals;

public class BunTest {

    @Test
    @DisplayName("Проверка верного возвращения имени класса Bun")
    public void testGetName() {
        Bun bun = new Bun("white bun", 120.0F);
        assertEquals("Ошибка. Имя не соответствует ожидаемому", "white bun", bun.getName());
    }

    @Test
    @DisplayName("Проверка верного возвращения цены класса Bun")
    public void testGetPrice() {
        Bun bun = new Bun("red bun", 130.0F);
        assertEquals("Ошибка. Цена не соответствует ожидаемому", 130.0F, bun.getPrice(), 0.001);
    }

}