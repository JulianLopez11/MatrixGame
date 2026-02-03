package domain;

public class MatrixGame {
    public static void main(String[] args) throws InterruptedException {
        Board board = new Board(8, 8);

        Neo neo = new Neo(board, 0,0);
        board.setNeo(neo);
        board.setTelephone(new Telephone(7, 7));

        Agent agent1 = new Agent(board, 2, 2);
        Agent agent2 = new Agent(board, 4, 3);
        Agent agent3 = new Agent(board, 5, 5);

        board.addAgent(agent1);
        board.addAgent(agent2);
        board.addAgent(agent3);

        board.addWall(new Wall(3, 3));
        board.addWall(new Wall(6, 5));
        board.addWall(new Wall(7, 5));

        System.out.println("Matrix");
        board.printBoard();

        while (!board.isGameOver()) {
            neo.run();  
            if (board.isGameOver()) break;

            for (Agent a : board.getAgents()) {
                a.run(); 
            }

            board.printBoard();
            Thread.sleep(800);
        }

        if (board.neoEscaped()) System.out.println("\nNeo escapó de Matrix");
        else System.out.println("\nNeo fue capturado");
    }
}
