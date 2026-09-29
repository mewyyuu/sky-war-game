package grid01;

import java.util.ArrayList;

public class Grid {

    private ArrayList<Row> theRows;
    private final int NUMBER_OF_ROWS = 4;
    private final int NUMBER_OF_SQUARES = 4;


    public Grid() {
    	this.theRows = new ArrayList<Row>(); 
    	Row tempRow;
    	for(int loop =1; loop <= this.NUMBER_OF_ROWS; loop++) {
    		tempRow = new Row(loop);
    		this.theRows.add(tempRow);
    	}
    	
    }
    
    public boolean aShipOn(int row, int square) {
    	for(Row tempRow : this.theRows) {
			if(tempRow.getNumber() == row) {
				for(Square tempSquare : tempRow.getTheSquares()) {
					if(tempSquare.getNumber() == square) {
						return tempSquare.isThereAShip();
					}
				}
			}
		}
		return false;
    }
    
    public void spawnShip(Ship ship, int row, int square) {
		for(Row tempRow : this.theRows) {
			if(tempRow.getNumber() == row) {
				for(Square tempSquare : tempRow.getTheSquares()) {
					if(tempSquare.getNumber() == square) {
						tempSquare.setShip(ship);
					}
				}
			}
		}
	}
    
    public void clearShip(Ship ship) {
        for (Row tempRow : this.theRows) {
            for (Square tempSquare : tempRow.getTheSquares()) {
                if (tempSquare.isThereAShip() && tempSquare.getShip() == ship) {
                    tempSquare.setShip(null); 
                }
            }
        }
    }
}
