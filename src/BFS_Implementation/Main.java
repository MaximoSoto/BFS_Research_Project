package BFS_Implementation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        BuildingGraphDataReader buildingGraphDataReader = new BuildingGraphDataReader();
        HashMap<String, ArrayList<String>> map = new HashMap<>();
        map = buildingGraphDataReader.readGraphData();
        HashMap<String, Node> nodeInfo = new HashMap<>();
        nodeInfo = buildingGraphDataReader.getNodeInfo();
        System.out.println(nodeInfo);

        HashSet<String> exits;
        exits = buildingGraphDataReader.getExits();
        System.out.print(exits);
    }
}
