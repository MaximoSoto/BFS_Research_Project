package BFS_Implementation;

import java.util.ArrayList;

public class Node {
    private String id;
    private boolean isExit;
    private double x;
    private double y;
    private double z;

    public Node(String id, boolean isExit, double x, double y, double z) {
        this.id = id;
        this.isExit = isExit;
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public String getID() {
        return id;
    }

    public boolean getIsExit() {
        return isExit;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getZ() {return z;}

}
