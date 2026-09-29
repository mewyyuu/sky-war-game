package grid01;

public class Square {

    private int number;
    private boolean firedAt;
    private Ship theShip;

    public Square(int number) {
        setNumber(number);
        this.firedAt = false; 
        this.theShip = null; 
    }

        public boolean isThereAShip() {
        return this.theShip != null;
    }

    
    public void setShip(Ship ship) {
        this.theShip = ship;
    }

    public Ship getShip() {
        return this.theShip;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getNumber() {
        return this.number;
    }

   
    public boolean isFiredAt() {
        return firedAt;
    }

    public void fireAt() {
        this.firedAt = true;
    }
}
