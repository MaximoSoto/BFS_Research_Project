package Dijkstra_Implementation;

import java.io.FileReader;
import java.io.BufferedReader;
import java.util.HashMap;
import java.io.IOException;
import java.util.HashSet;
import java.util.Map;

public class BuildingGraphDataReader {

    HashMap<String, Node> nodeInfo = new HashMap<>();
    HashSet<String> exits = new HashSet<>();

    public Map<String, Map<String, Double>> readGraphData() {
        Map<String, Map<String, Double>> map = new HashMap<>();
        Map<String, Double> edges = new HashMap<>();
        String id = "";
        boolean isExit = false;
        double x = 0;
        double y = 0;
        double z = 0;
        String edgeID = "";
        Double weight = 0.0;

        try {
            FileReader fileReader = new FileReader("src/BFS_Implementation/Building9.json");

            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line = "";
            while((line = bufferedReader.readLine()) != null) {
                String trimmedLine = line.trim();
                if(trimmedLine.contains("\"id\": ")) {
                    trimmedLine = trimmedLine.substring(
                            trimmedLine.indexOf(' ') + 2, trimmedLine.indexOf(',') - 1);
                    id = trimmedLine;
                }

                if(trimmedLine.contains("\"isExit\": ")) {
                    trimmedLine = trimmedLine.substring(
                            trimmedLine.indexOf(' ') + 1, trimmedLine.indexOf(','));

                    if(trimmedLine.equalsIgnoreCase("true")) {
                        isExit = true;
                    } else if(trimmedLine.equalsIgnoreCase("false")) {
                        isExit = false;
                    }

                }

                if(trimmedLine.contains("\"x\": ")) {
                    trimmedLine = trimmedLine.substring(
                            trimmedLine.indexOf(' ') + 1, trimmedLine.indexOf(','));
                    x = Double.parseDouble(trimmedLine);
                }

                if(trimmedLine.contains("\"y\": ")) {
                    trimmedLine = trimmedLine.substring(
                            trimmedLine.indexOf(' ') + 1, trimmedLine.indexOf(','));
                    y = Double.parseDouble(trimmedLine);
                }

                if(trimmedLine.contains("\"z\": ")) {
                    trimmedLine = trimmedLine.substring(
                            trimmedLine.indexOf(' ') + 1, trimmedLine.indexOf(','));
                    z = Double.parseDouble(trimmedLine);
                }

                if(trimmedLine.contains("\"edges\": ")) {
                    while((line = bufferedReader.readLine()) != null && !line.contains("]")) {
                        trimmedLine = line.trim();

                        if(trimmedLine.contains("\"nodeID\": ")) {
                            trimmedLine = trimmedLine.substring(
                                    trimmedLine.indexOf(' ') + 2, trimmedLine.indexOf(',') - 1);
                            edgeID = trimmedLine;
                        }

                        if(trimmedLine.contains("\"weight\": ")) {
                            trimmedLine = trimmedLine.substring(
                                    trimmedLine.indexOf(' ') + 1, trimmedLine.length() - 1);
                            weight = Double.parseDouble(trimmedLine);
                            edges.put(edgeID, weight);
                        }
                    }

                    Node node = new Node(id, isExit, x, y, z);
                    nodeInfo.put(node.getID(), node);
                    if(isExit) {exits.add(id);}
                    map.put(node.getID(), new HashMap<>(edges));
                    edges.clear();
                }

            }

        } catch(IOException e) {
            throw new RuntimeException(e);
        }

        return map;
    }

    public HashMap<String, Node> getNodeInfo() {
        return nodeInfo;
    }

    public HashSet<String> getExits() {
        return exits;
    }
}
