package BFS_Implementation;

public class Node {
    private String id;
    private boolean isExit;
    private int x;
    private int y;
    private String[] edges;

    public Node(String id, boolean isExit, int x, int y, String[] edges) {
        this.id = id;
        this.isExit = isExit;
        this.x = x;
        this.y = y;
        this.edges = edges;
    }

    public String getID() {
        return id;
    }

    public boolean getIsExit() {
        return isExit;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String[] getEdges() {
        return edges;
    }
}
