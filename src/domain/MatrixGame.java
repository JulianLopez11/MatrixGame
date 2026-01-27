package domain;

public class MatrixGame {

    private static final int WIDTH = 8;
    private static final int HEIGHT = 8;

    private Board board;
    private Neo neo;
    private Agent[] agents;

    public MatrixGame() {

        board = new Board(WIDTH, HEIGHT);

        neo = new Neo(6, 6);
        Telephone telephone = new Telephone(7, 7);

        Agent smith = new Agent(2, 2);
        Agent brown = new Agent(4, 3);
        Agent jones = new Agent(5, 5);

        agents = new Agent[] { smith, brown, jones };

        board.setNeo(neo);
        board.setTelephone(telephone);

        for (Agent agent : agents) {
            board.addAgent(agent);
        }

        board.addWall(new Wall(3, 3));
        board.addWall(new Wall(6, 6));
        board.addWall(new Wall(7, 5));
    }


    private void startGame(Neo neo, Agent[] agents) {

        neo.start();
        for (Agent agent : agents) agent.start();

        try {
            while (true) {
                Thread.sleep(1500);

                board.moveNeo();
                for (Agent agent : agents) {
                    board.moveAgent(agent);
                }

                board.printBoard();

                if (board.neoEscaped()) {
                    System.out.println("\n Neo escapó de Matrix");
                    break;
                }

                if (board.neoCaptured()) {
                    System.out.println("\n Un agente capturó a Neo");
                    break;
                }
            }
        } catch (InterruptedException e) {
            System.out.println("Juego terminado");
        } finally {
            neo.interrupt();
            for (Agent agent : agents) agent.interrupt();
        }
    }

    public void start() {
        startGame(neo, agents);
    }

    public static void main(String[] args) {
        MatrixGame game = new MatrixGame();
        game.start(); 
    }
}
