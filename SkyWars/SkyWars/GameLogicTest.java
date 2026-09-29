package grid01;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GameLogicTest {

    private SkyWarsGUI game;

    @BeforeEach
    public void setup() {
        game = new SkyWarsGUI();
    }

    @Test
    public void testWinCondition() {
        List<EnemySpaceShip> mockShips = new ArrayList<>();
        game.setEnemyShips(mockShips);  
        assertTrue(game.getEnemyShips().isEmpty(), "Game should detect win when enemy list is empty");
    }

    @Test
    public void testLoseConditionwithTwoEnemies() {
        SkyWarsGUI game = new SkyWarsGUI();

        
        game.getMasterShip().setPosition(1, 1);
        List<EnemySpaceShip> mockShips = new ArrayList<>();
        EnemySpaceShip enemy1 = new EnemySpaceShip("BattleStar");
        enemy1.setPosition(1, 1);
        EnemySpaceShip enemy2 = new EnemySpaceShip("BattleCruiser");
        enemy2.setPosition(1, 1);
        mockShips.add(enemy1);
        mockShips.add(enemy2);
        game.setEnemyShips(mockShips);
        assertTrue(game.isGameOver(1, 1), "Game should be over if two enemies are at the master ship's position");
    }



    @Test
    public void testNotLoseConditionWithOneEnemy() {
        List<EnemySpaceShip> mockShips = new ArrayList<>();
        mockShips.add(new EnemySpaceShip("BattleShooter"));
        game.setEnemyShips(mockShips);
        assertFalse(game.isGameOver(2, 2), "Game should not be over with only one enemy at the position");
    }
}
