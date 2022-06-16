package praktikum;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class TestBun {

    @Test
    public void testBunGetName() {
        Bun bun = new Bun("SomeBun", 50);
        assertEquals("SomeBun", bun.getName());
    }

    @Test
    public void testBunGetNullName() {
        Bun bun = new Bun(null, 50);
        assertNull(bun.getName());
    }

    @Test
    public void testBunGetEmptyName() {
        Bun bun = new Bun("", 50);
        assertEquals("", bun.getName());
    }

    @Test
    public void testBunGetOneSymbolName() {
        Bun bun = new Bun("h", 50);
        assertEquals("h", bun.getName());
    }

    @Test
    public void testBunGetLongName() {
        String longString = "Very long string Very long string Very long string Very long string Very long string Very long string ";
        Bun bun = new Bun(longString, 50);
        assertEquals(longString, bun.getName());
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

    @Test
    public void testBunGetZeroPrice() {
        Bun bun = new Bun("SomeBun", 0);
        assertEquals(0, bun.getPrice(), 0.0f);
    }

    @Test
    public void testBunGetMaxPrice() {
        Bun bun = new Bun("SomeBun", Float.MAX_VALUE);
        assertEquals(Float.MAX_VALUE, bun.getPrice(), 0.0f);
    }

    @Test
    public void testBunGetMinPrice() {
        Bun bun = new Bun("SomeBun", Float.MIN_VALUE);
        assertEquals(Float.MIN_VALUE, bun.getPrice(), 0.0f);
    }
}
