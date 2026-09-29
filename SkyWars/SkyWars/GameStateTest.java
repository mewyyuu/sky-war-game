package grid01;

import org.junit.jupiter.api.*;
import java.io.File;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class GameStateTest {

    private final String testFile = "testGameState.ser";

    @AfterEach
    public void cleanUp() {
        File file = new File(testFile);
        if (file.exists()) {
            file.delete();
        }
    }

    @Test
    public void testSaveAndLoadGame() {
     
        MasterSpaceShip master = new MasterSpaceShip();
        master.setPosition(2, 2);


        List<EnemySpaceShip> enemies = new ArrayList<>();
        EnemySpaceShip e1 = new EnemySpaceShip("BattleStar");
        e1.setPosition(0, 0);
        EnemySpaceShip e2 = new EnemySpaceShip("BattleCruiser");
        e2.setPosition(1, 1);
        enemies.add(e1);
        enemies.add(e2);

  
        GameState.saveGame(master, enemies, testFile);
        Object[] loaded = (Object[]) GameState.loadGame(testFile);

        assertNotNull(loaded);
        MasterSpaceShip loadedMaster = (MasterSpaceShip) loaded[0];
        List<EnemySpaceShip> loadedEnemies = (List<EnemySpaceShip>) loaded[1];
        assertEquals(2, loadedMaster.getRow());
        assertEquals(2, loadedMaster.getCol());

        assertEquals(2, loadedEnemies.size());
        assertEquals("BattleStar", loadedEnemies.get(0).getType());
        assertEquals(0, loadedEnemies.get(0).getRow());
        assertEquals(0, loadedEnemies.get(0).getCol());

        assertEquals("BattleCruiser", loadedEnemies.get(1).getType());
        assertEquals(1, loadedEnemies.get(1).getRow());
        assertEquals(1, loadedEnemies.get(1).getCol());
    }
}
