package domain;

public class MatrixGame {

    public static void main(String[] args) throws InterruptedException {

        Board board = new Board(8, 8);

        Neo neo = new Neo(board, 0,1);
        board.setNeo(neo);
        board.setTelephone(new Telephone(7, 7));

        Agent a1 = new Agent(board, 2, 2);
        Agent a2 = new Agent(board, 4, 3);
        Agent a3 = new Agent(board, 5, 5);

        board.addAgent(a1);
        board.addAgent(a2);
        board.addAgent(a3);

        board.addWall(new Wall(3, 3));
        board.addWall(new Wall(6, 5));
        board.addWall(new Wall(7, 5));

        neo.start();
        a1.start();
        a2.start();
        a3.start();

        while (!board.isGameOver()) {
            board.printBoard();
            Thread.sleep(800);
        }

        if (board.neoEscaped()) {
            System.out.println("\nNeo escapó de Matrix");
        } else {
            System.out.println("\nNeo fue capturado");
        }
    }
}
