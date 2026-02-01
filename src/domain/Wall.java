package domain;

public class Wall {
    private final int xPosition;
    private final int yPosition;

    public Wall(int x, int y) {
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
