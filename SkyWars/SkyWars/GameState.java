package grid01;

import java.io.*;
import java.util.List;

public class GameState {

    public static void saveGame(MasterSpaceShip masterShip, List<EnemySpaceShip> enemyShips, String filename) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename))) {
            out.writeObject(masterShip);
            out.writeObject(enemyShips);
            System.out.println("Game saved successfully.");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Failed to save game.");
        }
    }

    public static Object loadGame(String filename) {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename))) {
            MasterSpaceShip masterShip = (MasterSpaceShip) in.readObject();
            List<EnemySpaceShip> enemyShips = (List<EnemySpaceShip>) in.readObject();
            System.out.println("Game loaded successfully.");
            return new Object[] { masterShip, enemyShips }; 
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("Failed to load game.");
            return null;
        }
    }
}
