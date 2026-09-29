package grid01;
import java.io.Serializable;

public class Ship implements Serializable {

    private int length;
    private String type;
    private int health;
    private int row;  
    private int col;  

    public Ship() {
        this.length = 3;  
        this.type = "Destroyer";
        this.health = length;  
        this.row = -1; 
        this.col = -1; 
    }

    
    public Ship(String type) {
        this.type = type;
        this.length = 3;  
        this.health = length;  
        this.row = -1;
        this.col = -1; 
    }

    
    public Ship(String type, int length) {
        this.type = type;
        this.length = length;
        this.health = length;  
        this.row = -1; 
        this.col = -1; 
    }

    
    public Ship(String type, int length, int health) {
        this.type = type;
        this.length = length;
        this.health = health;
        this.row = -1; 
        this.col = -1; 
    }

   
    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    
    public void setPosition(int row, int col) {
        this.row = row;
        this.col = col;
    }

    
    public void hit() {
        if (health > 0) {
            health--;
        }
    }

    
    public boolean isSunk() {
        return health <= 0;
    }

    
    public int getLength() {
        return length;
    }


    public String getType() {
        return type;
    }


    @Override
    public String toString() {
        return "Ship [type=" + type + ", health=" + health + ", position=(" + row + ", " + col + ")]";
    }
}
