package BFS_Implementation;

import java.io.FileReader;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.io.IOException;
import java.util.HashSet;

public class BuildingGraphDataReader {

    HashMap<String, Node> nodeInfo = new HashMap<>();
    HashSet<String> exits = new HashSet<>();

    public HashMap<String, ArrayList<String>> readGraphData() {
        HashMap<String, ArrayList<String>> map = new HashMap<>();
        ArrayList<String> edges = new ArrayList<>();
        String id = "";
        boolean isExit = false;
        int x = 0;
        int y = 0;
        int idNum = 1;

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
                    x = Integer.parseInt(trimmedLine);
                }

                if(trimmedLine.contains("\"y\": ")) {
                    trimmedLine = trimmedLine.substring(
                            trimmedLine.indexOf(' ') + 1, trimmedLine.indexOf(','));
                    y = Integer.parseInt(trimmedLine);
                }

                if(trimmedLine.contains("\"edges\": ")) {
                    while((line = bufferedReader.readLine()) != null && !line.contains("]")) {
                        trimmedLine = line.trim();

                        if(trimmedLine.contains("\"nodeID\": ")) {
                            trimmedLine = trimmedLine.substring(
                                    trimmedLine.indexOf(' ') + 2, trimmedLine.length() - 1);
                            edges.add(trimmedLine);
                        }
                    }

                    Node node = new Node(id, isExit, x, y);
                    nodeInfo.put(node.getID(), node);
                    if(isExit) {exits.add(id);}
                    map.put(node.getID(), new ArrayList<>(edges));
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
