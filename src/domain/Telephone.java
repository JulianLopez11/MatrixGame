package domain;

public class Telephone {
    private final int xPosition;
    private final int yPosition;

    public Telephone(int x, int y) {
        this.xPosition = x;
        this.yPosition = y;
    }

    public int getxPosition() { 
        return xPosition; 
    }
    public int getyPosition() { 
        return yPosition; 
    }
}
