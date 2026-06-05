package BFS_Implementation;

import java.util.*;

public class DijkstraAlg {
    private double suspectX = 0;
    private double suspectY = 5;
    private double suspectZ = 0;

    public ArrayList<String> shortestPathDijkstra(String start) {

        BuildingGraphDataReader buildingGraphDataReader = new BuildingGraphDataReader();

        Map<String, Map<String, Double>> map = buildingGraphDataReader.readGraphData();

        HashMap<String, Node> nodeInfo = buildingGraphDataReader.getNodeInfo();

        String foundExit = "";

        ArrayList<String> path = new ArrayList<>();
        Map<String, Double> distances = new HashMap<>();
        Map<String, String> previous = new HashMap<>();
        PriorityQueue<String> queue = new PriorityQueue<>(
                Comparator.comparingDouble(node -> distances.get(node)));
        ArrayList<String> blockedNodes = new ArrayList<>();

        for(String node : map.keySet()) {
            distances.put(node, Double.POSITIVE_INFINITY);
            Node nodeCurrent = nodeInfo.get(node); //Find nodeInfo in main

            if((nodeCurrent.getX() == suspectX && nodeCurrent.getZ() == suspectZ) ||
                    (nodeCurrent.getY() == suspectY && nodeCurrent.getZ() == suspectZ)) {
                blockedNodes.add(nodeCurrent.getID());
            }
        }
        distances.put(start, 0.0);

        queue.add(start);

        while(!queue.isEmpty()) {
            Node currentNode = nodeInfo.get(queue.poll());

            if(currentNode.getIsExit()) {
                foundExit = currentNode.getID();
                break;
            }

            //Creates a HashMap that contains keys of the neighboring node IDs and the weight of that edge from
            //current node to neighbor node
            Map<String, Double> neighbors = map.getOrDefault(currentNode.getID(), new HashMap<>());

            //Runs the body for each neighbor Node ID (given by neighbors.keySet())
            for(String adjacentNode : neighbors.keySet()) {
                if(!nodeInfo.containsKey(adjacentNode)) {
                    continue;
                }

                if(blockedNodes.contains(adjacentNode)) {
                    continue; // Passes the specific round of the loop (break passes whole loop)
                }

                //Edge weight between parent node and neighbor
                double edgeWeight = neighbors.get(adjacentNode);
                //The total distance from start node to neighbor node
                double newDistance = distances.get(currentNode.getID()) + edgeWeight;

                //If stored distance to adjacent node is greater than the stored distance of the
                //parent node + edge weight to the adjacent node, execute body
                if(distances.getOrDefault(adjacentNode, Double.POSITIVE_INFINITY) > newDistance) {
                    //Updates distance from start to the adjacent node, making it equal to the distance
                    //of the parent node to the start node + the distance from parent to adjacent node
                    distances.put(adjacentNode, newDistance);

                    //Updates the HashMap that will be used to find path, setting the key to the neighbor so you can
                    //find its parent, stored by current
                    previous.put(adjacentNode, currentNode.getID());

                    //Updates the priorityQueue with the neighbor
                    queue.add(adjacentNode);
                }
            }

        }

        String current = foundExit;
        ArrayList<String> reversePath = new ArrayList<>();

        while(current != null) {
            reversePath.add(current);
            current = previous.get(current);
        }

        //Placed in case a path from start to destination does not exist
        if(!reversePath.getLast().equals(start)) {
            return new ArrayList<>();
        }

        for(int i = 0; i < reversePath.size(); i++) {
            path.addFirst(reversePath.get(i));
        }

        return path;
    }
}
