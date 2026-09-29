package grid01;

import static org.junit.Assert.*;
import org.junit.Test;
import java.util.*;

public class EnemySpaceShipTest {

    @Test
    public void testEnemyShipType() {
        EnemySpaceShip ship = new EnemySpaceShip("BattleCruiser");
        assertEquals("BattleCruiser", ship.getType());
    }

    @Test
    public void testEnemyShipRandomMovement() {
        EnemySpaceShip ship = new EnemySpaceShip("BattleStar");
        List<EnemySpaceShip> enemyList = new ArrayList<>();
        enemyList.add(ship);

        // Move ship
        EnemySpaceShip.moveEnemyShips(enemyList, 4);

        
        int newRow = ship.getRow();
        int newCol = ship.getCol();

        assertTrue("Row out of bounds", newRow >= 0 && newRow < 4);
        assertTrue("Column out of bounds", newCol >= 0 && newCol < 4);
    }
}
