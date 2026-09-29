package grid01;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class TestGrid {

    private Grid grid;
    private Ship testShip;

    @Before
    public void setUp() {
        grid = new Grid();
        testShip = new Ship("TestShip", 1);
    }

    @Test
    public void testSpawnShip() {
        grid.spawnShip(testShip, 2, 2);
        assertTrue(grid.aShipOn(2, 2));
    }

    @Test
    public void testAShipOn() {
    }

    @Test
    public void testClearShip() {
        grid.spawnShip(testShip, 1, 1);
        assertTrue(grid.aShipOn(1, 1));
        grid.clearShip(testShip);
        assertFalse(grid.aShipOn(1, 1));
    }
}
