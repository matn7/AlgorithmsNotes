package whiteboard;

import java.util.*;

public class AStarAlgorithmMy2 {

    public static void main(String[] args) {
        AStarAlgorithmMy2 aStarAlgorithmRand = new AStarAlgorithmMy2();
        int[][] graph = {
                {0, 0, 0, 0, 0},
                {0, 1, 1, 1, 0},
                {0, 0, 0, 0, 0},
                {1, 0, 1, 1, 1},
                {0, 0, 0, 0, 0}
        };
        aStarAlgorithmRand.aStarAlgorithm(0, 1, 4, 3, graph);
    }

    // O(w*h*low(w*h)) time | O(w*h) space
    // (do not delete)
    public int[][] aStarAlgorithm(int startRow, int startCol, int endRow, int endCol, int[][] graph) {
        // Write your code here.
        Map<String, Node> graphMap = new HashMap<>();
        for (int row = 0; row < graph.length; row++) {
            for (int col = 0; col < graph[row].length; col++) {
                String key = row + ":" + col;
                graphMap.put(key, new Node(key, new int[] {row, col}, calculateManhattanDistance(row, col, endRow, endCol)));
            }
        }
        String startKey = startRow + ":" + startCol;
        String endKey = endRow + ":" + endCol;
        Node startNode = graphMap.get(startKey);

        startNode.distanceFromStart = 0;
        startNode.recalculateHeuristic();

        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.add(startNode);

        while (!queue.isEmpty()) {
            Node currentNode = queue.poll();
            if (currentNode.visited) {
                continue;
            }
            currentNode.visited = true;
            if (currentNode.key.equals(endKey)) {
                break;
            }
            List<Node> neighbors = getNeighbors(currentNode, graph, graphMap);
            for (Node neighbor : neighbors) {
                Node curr = neighbor;
                int newDistance = currentNode.distanceFromStart + 1;
                curr.distanceFromStart =  Math.min(curr.distanceFromStart, newDistance);
                curr.recalculateHeuristic();
                curr.cameFrom = currentNode;
                queue.add(curr);
            }
        }
        Node endNode = graphMap.get(endKey);
        if (endNode.cameFrom == null) {
            return new int[][] {};
        }

        List<Integer[]> path = new ArrayList<>();
        Node current = endNode;
        while (current.cameFrom != null) {
            path.add(new Integer[]{current.coord[0], current.coord[1]});
            current = current.cameFrom;
        }
        path.add(new Integer[]{startNode.coord[0], startNode.coord[1]});
        Collections.reverse(path);

        int[][] result = new int[path.size()][2];
        int counter = 0;
        for (Integer[] element : path) {
            result[counter][0] = element[0];
            result[counter][1] = element[1];
            counter++;
        }

        return result;
    }

    private List<Node> getNeighbors(Node currentNode, int[][] graph, Map<String, Node> graphMap) {
        List<Node> result = new ArrayList<>();
        int row = currentNode.coord[0];
        int col = currentNode.coord[1];

        if (row > 0) {
            String key = (row - 1) + ":" + col;
            if (graph[row - 1][col] == 0 && !graphMap.get(key).visited) {
                result.add(graphMap.get(key));
            }
        }
        if (row < graph.length - 1) {
            String key = (row + 1) + ":" + col;
            if (graph[row + 1][col] == 0 && !graphMap.get(key).visited) {
                result.add(graphMap.get(key));
            }
        }
        if (col > 0) {
            String key = row + ":" + (col - 1);
            if (graph[row][col - 1] == 0 && !graphMap.get(key).visited) {
                result.add(graphMap.get(key));
            }
        }
        if (col < graph[row].length - 1) {
            String key = row + ":" + (col + 1);
            if (graph[row][col + 1] == 0 && !graphMap.get(key).visited) {
                result.add(graphMap.get(key));
            }
        }
        return result;
    }

    private int calculateManhattanDistance(int startRow, int startCol, int endRow, int endCol) {
        return Math.abs(endRow - startRow) + Math.abs(endCol - startCol);
    }

    class Node implements Comparable<Node> {
        String key;
        boolean visited;
        int[] coord;
        int distanceFromStart = 99999;
        int distanceToEnd;
        int heuristic;
        Node cameFrom;

        public Node(String key, int[] coord, int distanceToEnd) {
            this.key = key;
            this.distanceToEnd = distanceToEnd;
            this.coord = coord;
            this.cameFrom = null;
        }

        public void recalculateHeuristic() {
            this.heuristic = distanceFromStart + distanceToEnd;
        }


        @Override
        public int compareTo(Node o) {
            return this.heuristic - o.heuristic;
        }
    }

}
