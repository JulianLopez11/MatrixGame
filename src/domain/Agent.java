package domain;

public class Agent extends Thread {

    private int xPosition;
    private int yPosition;
    private final Board board;

    public Agent(Board board, int x, int y) {
        this.board = board;
        this.xPosition = x;
        this.yPosition = y;
    }

   
    @Override
    public void run() {
        try {
            while (!board.isGameOver()) {

                int oldX = xPosition;
                int oldY = yPosition;

                int[] next = board.bfs(
                    xPosition, yPosition,
                    board.getNeoX(), board.getNeoY()
                );

                if (board.moveAgent(this, next[0], next[1])) {
                    System.out.println(
                        "Agente: (" + oldX + "," + oldY +
                        ") -> (" + next[0] + "," + next[1] + ")"
                    );
                }

                Thread.sleep(750);
            }
        } catch (InterruptedException e) {}
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
