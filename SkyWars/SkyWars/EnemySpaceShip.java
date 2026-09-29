package grid01;
import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;


public class EnemySpaceShip extends Ship implements Serializable {
	
	
	private static List<EnemySpaceShip> enemyShips = new ArrayList<>();
	
	
	

    public EnemySpaceShip(String type) {
        super(type);
        setPosition(0, 0); 
    }

    // Move the enemy ship 
    public void moveRandomly(int gridSize) {
    	 enemyShips = new ArrayList<>(); 
        int[] dRow = {-1, 1, 0, 0};
        int[] dCol = {0, 0, -1, 1};
        int direction = (int) (Math.random() * 4);
        int newRow = getRow() + dRow[direction];
        int newCol = getCol() + dCol[direction];

        if (newRow >= 0 && newRow < gridSize && newCol >= 0 && newCol < gridSize) {
            setPosition(newRow, newCol);
        }
    }    
    public static void moveEnemyShips(List<EnemySpaceShip> enemyShips, int gridSize) {
        
        for (EnemySpaceShip ship : enemyShips) {
            ship.moveRandomly(gridSize); // Move each enemy ships
        }
    }
    
    public static List<EnemySpaceShip> spawnEnemyShips() {
                enemyShips.clear();
        
        enemyShips.add(new EnemySpaceShip("BattleStar"));
        enemyShips.add(new EnemySpaceShip("BattleCruiser"));
        enemyShips.add(new EnemySpaceShip("BattleShooter"));
        
        enemyShips.get(0).setPosition(0, 0); 
        enemyShips.get(1).setPosition(0, 0); 
        enemyShips.get(2).setPosition(0, 0); 
        
        return enemyShips;
    }
    public static List<EnemySpaceShip> getEnemyShips() {
        return enemyShips;
    }

	public void setRow(int i) {
		// TODO Auto-generated method stub
		
	}

	public void setCol(int i) {
		// TODO Auto-generated method stub
		
	}
}
