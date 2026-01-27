package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Board {

    private int width;
    private int height;
    private Neo neo;
    private Telephone telephone;
    private List<Agent> agents;
    private List<Wall> walls;
    private Random random = new Random();

    public Board(int width, int height) {
        this.width = width;
        this.height = height;
        this.agents = new ArrayList<>();
        this.walls = new ArrayList<>();
    }

    public void setNeo(Neo neo) {
        this.neo = neo;
    }

    public void setTelephone(Telephone telephone) {
        this.telephone = telephone;
    }

    public void addAgent(Agent agent) {
        agents.add(agent);
    }

    public void addWall(Wall wall) {
        walls.add(wall);
    }

    public synchronized void moveNeo() {
        int[] move = randomMoves();
        int newX = neo.getxPosition() + move[0];
        int newY = neo.getyPosition() + move[1];

        if (isValidPosition(newX, newY) && !isWallAt(newX, newY)) {
            neo.setxPosition(newX);
            neo.setyPosition(newY);
            System.out.println("Neo se movió a (" + newX + "," + newY + ")");
        }
    }

    public synchronized void moveAgent(Agent agent) {
        int[] move = randomMoves();
        int newX = agent.getxPosition() + move[0];
        int newY = agent.getyPosition() + move[1];

        if (isValidPosition(newX, newY) && !isWallAt(newX, newY)) {
            agent.setxPosition(newX);
            agent.setyPosition(newY);
            System.out.println("Agente se movió a (" + newX + "," + newY + ")");
        }
    }

    private int[] randomMoves() {
        return switch (random.nextInt(4)) {
            case 0 -> new int[]{0, -1};
            case 1 -> new int[]{1, 0};
            case 2 -> new int[]{0, 1};
            default -> new int[]{-1, 0};
        };
    }

    public synchronized boolean neoEscaped() {
        return neo.getxPosition() == telephone.getxPosition()
                && neo.getyPosition() == telephone.getyPosition();
    }

    public synchronized boolean neoCaptured() {
        for (Agent agent : agents) {
            if (agent.getxPosition() == neo.getxPosition()
                    && agent.getyPosition() == neo.getyPosition()) {
                return true;
            }
        }
        return false;
    }


    private boolean isValidPosition(int x, int y) {
        return x >= 0 && x < width && y >= 0 && y < height;
    }

    private boolean isWallAt(int x, int y) {
        for (Wall wall : walls) {
            if (wall.getxPosition() == x && wall.getyPosition() == y) {
                return true;
            }
        }
        return false;
    }

    public synchronized void printBoard() {
        String[][] matrixBoard = new String[height][width];

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                matrixBoard[i][j] = " ";
            }
        }

        for (Wall wall : walls) {
            matrixBoard[wall.getyPosition()][wall.getxPosition()] = "W";
        }

        for (Agent agent : agents) {
            matrixBoard[agent.getyPosition()][agent.getxPosition()] = "A";
        }

        matrixBoard[telephone.getyPosition()][telephone.getxPosition()] = "T";
        matrixBoard[neo.getyPosition()][neo.getxPosition()] = "N";

        System.out.println();
        for (int i = 0; i < height; i++) {
            System.out.print("|");
            for (int j = 0; j < width; j++) {
                System.out.print(" " + matrixBoard[i][j] + " |");
            }
            System.out.println();
        }
    }
}
