package whiteboard;

import java.util.*;

public class TwoEdgeConnectedGraph {

    // O(v + e) time | O(v) space
    public boolean twoEdgeConnectedGraph(int[][] edges) {
        // Write your code here.
        if (edges.length == 0) {
            return true;
        }
        int[] arrivalTimes = new int[edges.length];
        Arrays.fill(arrivalTimes, -1);
        int startVertex = 0;
        if (getMinimumArrivalTimeOfAncestor(startVertex, -1, 0, arrivalTimes, edges) == -1) {
            return false;
        }
        return areAllVerticesVisited(arrivalTimes);
    }

    private boolean areAllVerticesVisited(int[] arrivalTimes) {
        for (int time : arrivalTimes) {
            if (time == -1) {
                return false;
            }
        }
        return true;
    }

    private int getMinimumArrivalTimeOfAncestor(int currentVertex, int parent, int currentTime,
                                                int[] arrivalTimes, int[][] edges) {
        arrivalTimes[currentVertex] = currentTime;

        int minimumArrivalTime = currentTime;

        for (int destination : edges[currentVertex]) {
            if (arrivalTimes[destination] == -1) {
                minimumArrivalTime = Math.min(minimumArrivalTime,
                        getMinimumArrivalTimeOfAncestor(destination, currentTime, currentTime + 1,
                                arrivalTimes, edges));
            } else if (destination != parent) {
                minimumArrivalTime = Math.min(minimumArrivalTime, arrivalTimes[destination]);
            }
        }

        if (minimumArrivalTime == currentTime && parent != -1) {
            return -1;
        }
        return minimumArrivalTime;
    }

    // O(e * (e+v)) time | O(e) space
    public boolean twoEdgeConnectedGraph2(int[][] edges) {
        // Write your code here.
        if (edges.length <= 1) {
            return true;
        }
        if (edges[0].length == 0) {
            return false;
        }
        Map<Integer, Node> graphMap = new HashMap<>();
        for (int i = 0; i < edges.length; i++) {
            graphMap.put(i, new Node(i));
        }

        for (int i = 0; i < edges.length; i++) {
            int[] edge = edges[i];
            Node currNode = graphMap.get(i);
            for (int e : edge) {
                currNode.addNeighbor(graphMap.get(e));
            }
        }

        for (int i = 0; i < graphMap.size(); i++) {
            Node currNode = graphMap.get(i);
            List<Node> neighbors = currNode.neighbors;
            int size = neighbors.size();
            if (size == 0 && graphMap.size() > 1) {
                return false;
            }
            for (int n = 0; n < size; n++) {
                Node removed = neighbors.remove(n); // remove neighbor from list
                if (neighbors.isEmpty()) {
                    return false;
                }
                explore(currNode, currNode);
                if (!currNode.visited) {
                    return false;
                }
                neighbors.add(removed); // add removed it back
                for (Node n1 : neighbors) {
                    if (!n1.visited) {
                        return false;
                    }
                }
                currNode.visited = false;// reset visiting
                for (Node n1 : neighbors) {
                    n1.visited = false;
                }
            }
        }

        return true;
    }

    private void explore(Node node, Node currNode) {
        if (node == null) {
            return;
        }
        if (node.visiting) {
            return;
        }
        node.visiting = true;

        List<Node> neighbors = node.neighbors;
        for (Node neighbor : neighbors) {
            explore(neighbor, currNode);
        }
        node.visited = true;
        node.visiting = false;
    }

    static class Node {
        int val;
        boolean visiting;
        boolean visited;
        List<Node> neighbors;

        public Node(int val) {
            this.val = val;
            this.neighbors = new ArrayList<>();
        }

        public void addNeighbor(Node n) {
            this.neighbors.add(n);
        }
    }
}
