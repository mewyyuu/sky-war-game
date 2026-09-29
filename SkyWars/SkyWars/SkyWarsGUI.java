package grid01;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import grid01.EnemySpaceShip; 
import java.util.Random;


public class SkyWarsGUI {
    private JFrame frame;
    private JPanel gridPanel;
    private JButton[][] buttons; 
    private Grid theGrid;
    private MasterSpaceShip masterShip;
    List<EnemySpaceShip> enemyShips; 
    private Random random = new Random();
    
    public List<EnemySpaceShip> getEnemyShips() {
        return enemyShips;
    }



    public SkyWarsGUI() {
        theGrid = new Grid(); 
        masterShip = new MasterSpaceShip(); 
        enemyShips = new ArrayList<>(); 
        buttons = new JButton[4][4]; 
        
        
        
        
        // Spawn enemy ships
        enemyShips = EnemySpaceShip.spawnEnemyShips();


        frame = new JFrame("Sky Wars");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);

        gridPanel = new JPanel(new GridLayout(4, 4)); // 4x4 grid
        frame.add(gridPanel, BorderLayout.CENTER);

        for (int row = 0; row < 4; row++) {
            for (int col = 0; col < 4; col++) {
                JButton button = new JButton("");
                button.setPreferredSize(new Dimension(100, 100));
                button.setFont(new Font("Arial", Font.PLAIN, 24));
                final int r = row;
                final int c = col;
                button.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                      
                    }
                });
                buttons[row][col] = button;
                gridPanel.add(button);
            }
        }

    
        JPanel controlPanel = new JPanel();

        // Move button
        JButton moveButton = new JButton("Move Master Ship");
        moveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                moveMasterShip(); 
            }
        });
        controlPanel.add(moveButton);

        // Save button
        JButton saveButton = new JButton("Save Game");
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GameState.saveGame(masterShip, enemyShips, "gameState.ser");  
                JOptionPane.showMessageDialog(frame, "Game saved successfully!");
            }
        });
        controlPanel.add(saveButton);

        JButton loadButton = new JButton("Load Game");
        loadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object[] loadedGame = (Object[]) GameState.loadGame("gameState.ser");
                if (loadedGame != null) {              
                    masterShip = (MasterSpaceShip) loadedGame[0];  
                    enemyShips = (List<EnemySpaceShip>) loadedGame[1];  
                    updateGrid(); 
                } else {
                    System.out.println("Failed to load game.");
                }
            }
        });

        controlPanel.add(saveButton);
        controlPanel.add(loadButton);
        frame.add(controlPanel, BorderLayout.SOUTH);

    }

    // Display the game window
    public void show() {
        frame.setVisible(true);
        updateGrid(); 
    }

   
    
 
    public boolean isGameOver(int newRow, int newCol) {
        int enemyCount = 0;
        for (EnemySpaceShip ship : enemyShips) {
            if (ship.getRow() == newRow && ship.getCol() == newCol) {
                enemyCount++;
            }
        }
        return enemyCount >= 2;
    }

    // Move the Master SpaceShip
    private void moveMasterShip() {
      
        int row = masterShip.getRow();
        int col = masterShip.getCol();
        int[] dRow = {-1, 1, 0, 0};
        int[] dCol = {0, 0, -1, 1};
        int direction = random.nextInt(4); // gives 0, 1, 2, or 3
        int newRow = row + dRow[direction];
        int newCol = col + dCol[direction];
        if (newRow >= 0 && newRow < 4 && newCol >= 0 && newCol < 4) {
            
            theGrid.clearShip(masterShip);
          
            masterShip.setPosition(newRow, newCol);
            theGrid.spawnShip(masterShip, newRow, newCol);
            destroyedEnemyShips(newRow, newCol);          
            updateGrid();
            destroyedEnemyShips(newRow, newCol);

            
            EnemySpaceShip.moveEnemyShips(enemyShips, 4); 
           // win condition 
            if (enemyShips.isEmpty()) {
            	JOptionPane.showMessageDialog(frame, "Congratulations! The Master SpaceShip has destroyed all the enemy ships! You win!");
            	System.exit(0); // End the game
                        }           
            
         // lose condition
            if (isGameOver(newRow, newCol)) {
                JOptionPane.showMessageDialog(frame, "Game Over! The enemy ships have destroyed the Master SpaceShip!");
                System.exit(0);
            }



            
         
            
        }
    }



    
    

    
 //  Destroys enemy ships
    private void destroyedEnemyShips(int newRow, int newCol) {
        for (EnemySpaceShip ship : enemyShips) {
            if (ship.getRow() == newRow && ship.getCol() == newCol) {
                enemyShips.remove(ship);
                System.out.println("Enemy ship destroyed!");                
                JOptionPane.showMessageDialog(frame, "An enemy ship has been destroyed!");

                break; 
            }
        }
    }


  


    private void updateGrid() {
        for (int row = 0; row < 4; row++) {
            for (int col = 0; col < 4; col++) {
                buttons[row][col].setText(""); // Reset the text on each button
            }
        }

        int masterRow = masterShip.getRow();
        int masterCol = masterShip.getCol();
        buttons[masterRow][masterCol].setText("M"); 

       
        for (EnemySpaceShip ship : enemyShips) {
            int row = ship.getRow();
            int col = ship.getCol();

           
            if (buttons[row][col].getText().equals("")) {
                switch (ship.getType()) {
                    case "BattleStar":
                        buttons[row][col].setText("S"); 
                        break;
                    case "BattleCruiser":
                        buttons[row][col].setText("C"); 
                        break;
                    case "BattleShooter":
                        buttons[row][col].setText("X"); 
                        break;
                    default:
                        buttons[row][col].setText("");
                        break;
                }
            }
        }
    }

  


    public void setEnemyShips(List<EnemySpaceShip> ships) {
        this.enemyShips = ships;
    }

	
	public MasterSpaceShip getMasterShip() {
	    return masterShip;
	}


   
}
