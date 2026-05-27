package BFS_Implementation;

import java.util.ArrayList;

public class Node {
    private String id;
    private boolean isExit;
    private int x;
    private int y;

    public Node(String id, boolean isExit, int x, int y) {
        this.id = id;
        this.isExit = isExit;
        this.x = x;
        this.y = y;
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

}
