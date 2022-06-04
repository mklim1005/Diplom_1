package praktikum;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestBun {

    @Test
    public void testBunGetName() {
        Bun bun = new Bun("SomeBun", 50);
        assertEquals("SomeBun", bun.getName());
    }

    @Test
    public void testBunGetPrice() {
        Bun bun = new Bun("SomeBun", 60.11f);
        assertEquals(60.11f, bun.getPrice(), 0.0f);
    }

    @Test
    public void testBunGetPrice_NegativePriceAllowed() {
        Bun bun = new Bun("SomeBun", -0.11f);
        assertEquals(-0.11f, bun.getPrice(), 0.0f);
    }
}
