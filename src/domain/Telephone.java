package domain;

public class Telephone {
    private int xPosition;
    private int yPosition;
    
    public Telephone(int posX, int posY) {
        this.xPosition = posX;
        this.yPosition = posY;
    }
    
    public int getxPosition() {
        return xPosition;
    }
    
    public void setxPosition(int xPosition) {
        this.xPosition = xPosition;
    }
    
    public int getyPosition() {
        return yPosition;
    }
    
    public void setyPosition(int yPosition) {
        this.yPosition = yPosition;
    }
}
