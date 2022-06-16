package praktikum;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class TestDatabase {

    @Test
    public void testAvailableBuns() {
        Database database = new Database();

        List<Bun> actual = database.availableBuns();

        assertEquals(3, actual.size());
        assertSame("black bun", actual.get(0).name);
        assertEquals(100, actual.get(0).price, 0.0);
        assertSame("white bun", actual.get(1).name);
        assertEquals(200, actual.get(1).price, 0.0);
        assertSame("red bun", actual.get(2).name);
        assertEquals(300, actual.get(2).price, 0.0);
    }
}
