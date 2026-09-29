package grid01;
import java.io.Serializable;

public class MasterSpaceShip  extends Ship implements Serializable{

    private int row; 
    private int col; 

    public MasterSpaceShip() {
        super("MasterSpaceShip"); 
        this.row = 3; 
        this.col = 3;
    }

    
    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    
    public void setPosition(int row, int col) {
        this.row = row;
        this.col = col;
    }
}
