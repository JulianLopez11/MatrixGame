package domain;

import java.util.*;

public class Board {

    private final int width;
    private final int height;
    private Neo neo;
    private Telephone telephone;
    private final List<Agent> agents = new ArrayList<>();
    private final List<Wall> walls = new ArrayList<>();
    


    public Board(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public synchronized void setNeo(Neo neo) {
        this.neo = neo;
    }

    public synchronized void setTelephone(Telephone telephone) {
        this.telephone = telephone;
    }

    public synchronized void addAgent(Agent agent) {
        agents.add(agent);
    }

    public synchronized void addWall(Wall wall) {
        walls.add(wall);
    }


    public synchronized boolean neoEscaped() {
        return neo.getxPosition() == telephone.getxPosition()
            && neo.getyPosition() == telephone.getyPosition();
    }

    public synchronized boolean neoCaptured() {
        for (Agent a : agents) {
            if (a.getxPosition() == neo.getxPosition()
             && a.getyPosition() == neo.getyPosition()) {
                return true;
            }
        }
        return false;
    }

    public synchronized boolean isGameOver() {
        return neoEscaped() || neoCaptured();
    }


    public synchronized boolean moveNeo(int newX, int newY) {
    if (!isValid(newX, newY) || isWall(newX, newY)) return false;

    for (Agent a : agents) {
        if (a.getxPosition() == newX && a.getyPosition() == newY) {
            return false;
        }
    }
    neo.setxPosition(newX);
    neo.setyPosition(newY);
    return true;
}


    public synchronized boolean moveAgent(Agent agent, int newX, int newY) {
    if (!isValid(newX, newY) || isWall(newX, newY)) return false;

    for (Agent a : agents) {
        if (a != agent &&
            a.getxPosition() == newX &&
            a.getyPosition() == newY) {
            return false;
        }
    }

    agent.setxPosition(newX);
    agent.setyPosition(newY);
    return true;
    }



    public int[] bfs(int sx, int sy, int gx, int gy) {

        boolean[][] visited = new boolean[height][width];
        int[][] parentX = new int[height][width];
        int[][] parentY = new int[height][width];

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{sx, sy});
        visited[sy][sx] = true;

        while (!queue.isEmpty()) {
            int[] c = queue.poll();
            int x = c[0], y = c[1];

            if (x == gx && y == gy) break;

            for (int[] n : neighbors(x, y)) {
                int nx = n[0], ny = n[1];
                if (!visited[ny][nx] && !isWall(nx, ny)) {
                    visited[ny][nx] = true;
                    parentX[ny][nx] = x;
                    parentY[ny][nx] = y;
                    queue.add(new int[]{nx, ny});
                }
            }
        }

        if (!visited[gy][gx]) return new int[]{sx, sy};

        int x = gx, y = gy;
        while (!(parentX[y][x] == sx && parentY[y][x] == sy)) {
            int px = parentX[y][x];
            int py = parentY[y][x];
            x = px;
            y = py;
        }

        return new int[]{x, y};
    }

    private List<int[]> neighbors(int x, int y) {
        int[][] d = {{1,0},{-1,0},{0,1},{0,-1}};
        List<int[]> list = new ArrayList<>();
        for (int[] v : d) {
            int nx = x + v[0];
            int ny = y + v[1];
            if (isValid(nx, ny)) list.add(new int[]{nx, ny});
        }
        return list;
    }


    public synchronized int getNeoX() { 
        return neo.getxPosition(); 
    }
    public synchronized int getNeoY() { 
        return neo.getyPosition(); 
    }
    public synchronized int getTelephoneX() { 
        return telephone.getxPosition(); 
    }
    public synchronized int getTelephoneY() { 
        return telephone.getyPosition(); 
    }

    private boolean isValid(int x, int y) {
        return x >= 0 && x < width && y >= 0 && y < height;
    }

    private boolean isWall(int x, int y) {
        for (Wall w : walls) {
            if (w.getxPosition() == x && w.getyPosition() == y) return true;
        }
        return false;
    }

    public synchronized List<Agent> getAgents() {
        return agents;
    }
    public synchronized void printBoard() {

        String[][] m = new String[height][width];
        for (int i = 0; i < height; i++) Arrays.fill(m[i], " ");

        for (Wall w : walls) m[w.getyPosition()][w.getxPosition()] = "W";
        m[telephone.getyPosition()][telephone.getxPosition()] = "T";

        for (Agent a : agents) m[a.getyPosition()][a.getxPosition()] = "A";

        if (neoCaptured()) m[neo.getyPosition()][neo.getxPosition()] = "X";
        else m[neo.getyPosition()][neo.getxPosition()] = "N";

        System.out.println();
        for (int i = 0; i < height; i++) {
            System.out.print("|");
            for (int j = 0; j < width; j++) {
                System.out.print(" " + m[i][j] + " |");
            }
            System.out.println();
        }

    }
}
