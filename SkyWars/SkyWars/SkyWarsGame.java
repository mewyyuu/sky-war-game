package grid01;

import java.io.Serializable;
import java.util.List;

public class SkyWarsGame implements Serializable {
    private MasterSpaceShip masterShip;
    private List<EnemySpaceShip> enemyShips;
    private Grid grid;

    public SkyWarsGame(MasterSpaceShip masterShip, List<EnemySpaceShip> enemyShips, Grid grid) {
        this.masterShip = masterShip;
        this.enemyShips = enemyShips;
        this.grid = grid;
    }

    public MasterSpaceShip getMasterShip() {
        return masterShip;
    }

    public List<EnemySpaceShip> getEnemyShips() {
        return enemyShips;
    }

    public Grid getGrid() {
        return grid;
    }
}
