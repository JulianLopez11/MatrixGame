package domain;

public class Agent extends Thread {
    private int xPosition, yPosition;
    private final Board board;

    public Agent(Board board, int x, int y) {
        this.board = board;
        this.xPosition = x;
        this.yPosition = y;
    }

    @Override
    public void run() {
        int oldX = xPosition;
        int oldY = yPosition;

        int[] next = board.bfs(xPosition, yPosition, board.getNeoX(), board.getNeoY());

        if (board.moveAgent(this, next[0], next[1])) {
            this.xPosition = next[0];
            this.yPosition = next[1];
            System.out.println("Agente " + " se movió: (" + oldX + "," + oldY + ") -> (" + xPosition + "," + yPosition + ")");
        }
    }

    public int getxPosition() { 
        return xPosition; 
    }
    public int getyPosition() { 
        return yPosition; 
    }
    public void setxPosition(int x) { 
        xPosition = x; 
    }
    public void setyPosition(int y) { 
        yPosition = y; 
    }
}