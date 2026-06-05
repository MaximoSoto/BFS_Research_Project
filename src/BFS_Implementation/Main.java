package BFS_Implementation;

import java.util.*;

public class Main {
    public static void main(String[] args) {
/*
        BuildingGraphDataReader buildingGraphDataReader = new BuildingGraphDataReader();
        Map<String, Map<String, Double>> map = new HashMap<>();
        map = buildingGraphDataReader.readGraphData();
        HashMap<String, Node> nodeInfo = new HashMap<>(); //REUSE THIS LINE!!!
        nodeInfo = buildingGraphDataReader.getNodeInfo();
        System.out.println(nodeInfo);
        System.out.println("\n" + map);

        HashSet<String> exits;
        exits = buildingGraphDataReader.getExits();
        System.out.print(exits);


        Map<String, Map<String, Double>> map = new HashMap<>();

        //Node A connections
        map.put("A", new HashMap<>());
        map.get("A").put("B", 5.0);
        map.get("A").put("C", 3.0);

        //Node B Connections
        map.put("B", new HashMap<>());
        map.get("B").put("A", 5.0);
        map.get("B").put("E", 8.0);

        //Node C Connections
        map.put("C", new HashMap<>());
        map.get("C").put("A", 3.0);
        map.get("C").put("D", 7.0);

        //Node D Connections
        map.put("D", new HashMap<>());
        map.get("D").put("C", 7.0);
        map.get("D").put("E", 2.0);
        map.get("D").put("G", 10.0);

        //Node E Connections
        map.put("E", new HashMap<>());
        map.get("E").put("B", 8.0);
        map.get("E").put("D", 2.0);
        map.get("E").put("F", 4.0);

        //Node F Connections
        map.put("F", new HashMap<>());
        map.get("F").put("E", 4.0);
        map.get("F").put("G", 3.0);

        //Node G connections
        map.put("G", new HashMap<>());
        map.get("G").put("D", 10.0);
        map.get("G").put("F", 3.0);

        System.out.println(map);
        System.out.println('\n');
        */
        ArrayList<String> shortestPath;

        DijkstraAlg dijkstraAlg = new DijkstraAlg();
        shortestPath = dijkstraAlg.shortestPathDijkstra("F2J1" );

        if(shortestPath.isEmpty()){
            System.out.println("No path exists.");
        } else {

            for (int i = 0; i < shortestPath.size(); i++) {
                System.out.println(shortestPath.get(i));
            }

        }
    }
}
