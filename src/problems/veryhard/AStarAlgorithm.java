package problems.veryhard;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class AStarAlgorithm {

    public static void main(String[] args) {
        AStarAlgorithm aStarAlgorithm = new AStarAlgorithm();
//        int[][] graph = {
//                {0, 0, 0, 0, 0},
//                {0, 1, 1, 1, 0},
//                {0, 0, 0, 0, 0},
//                {1, 0, 1, 1, 1},
//                {0, 0, 0, 0, 0}
//        };
        
        int[][] graph = {
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                {1, 1, 0, 1, 1, 1, 1, 1, 0, 1},
                {1, 1, 0, 0, 0, 1, 0, 1, 0, 1},
                {1, 1, 0, 0, 0, 1, 0, 1, 0, 1},
                {1, 1, 0, 0, 0, 1, 0, 1, 0, 1},
                {1, 1, 0, 0, 0, 1, 0, 1, 0, 1},
                {1, 1, 0, 0, 0, 1, 0, 1, 0, 1},
                {1, 1, 1, 1, 1, 1, 0, 0, 0, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
        };
        aStarAlgorithm.aStarAlgorithm(1, 1, 8, 8, graph);
    }

    // O(w*h*low(w*h)) time | O(w*h) space
    public int[][] aStarAlgorithm(int startRow, int startCol, int endRow, int endCol, int[][] graph) {
        // Write your code here.
        // H: heuristic value
        // G: current shortest distance
        // F: G + H
        List<List<Node>> nodes = initializeNodes(graph);

        Node startNode = nodes.get(startRow).get(startCol);
        Node endNode = nodes.get(endRow).get(endCol);

        startNode.distanceFromStart = 0;
        startNode.estimatedDistanceToEnd = calculateManhattanDistance(startNode, endNode);

        PriorityQueue<Node> nodesToVisit = new PriorityQueue<>();
        nodesToVisit.add(startNode);

        while (!nodesToVisit.isEmpty()) {
            Node currentMinDistanceNode = nodesToVisit.remove();
            if (currentMinDistanceNode == endNode) {
                break;
            }

            List<Node> neighbors = getNeighboringNodes(currentMinDistanceNode, nodes);

            for (Node neighbor : neighbors) {
                if (neighbor.value == 1) {
                    continue;
                }

                int tenativeDistanceToNeighbor = currentMinDistanceNode.distanceFromStart + 1;

                if (tenativeDistanceToNeighbor >= neighbor.distanceFromStart) {
                    continue;
                }

                neighbor.cameFrom = currentMinDistanceNode;
                neighbor.distanceFromStart = tenativeDistanceToNeighbor;
                neighbor.estimatedDistanceToEnd = tenativeDistanceToNeighbor + calculateManhattanDistance(neighbor, endNode);

                if (!nodesToVisit.contains(neighbor)) {
                    System.out.println(neighbor.row + " " + neighbor.col);
                    nodesToVisit.add(neighbor);
                } else {
                    nodesToVisit.remove();
                    nodesToVisit.add(neighbor);
                    // update
                }
            }
        }
        return reconstructPath(endNode);
    }

    private int[][] reconstructPath(Node endNode) {
        if (endNode.cameFrom == null) {
            return new int[][] {};
        }

        Node currentNode = endNode;
        List<List<Integer>> path = new ArrayList<>();

        while (currentNode != null) {
            List<Integer> step = new ArrayList<>();
            step.add(currentNode.row);
            step.add(currentNode.col);
            path.add(step);
            currentNode = currentNode.cameFrom;
        }

        int[][] result = new int[path.size()][2];
        int counter = path.size() - 1;

        for (int i = 0; i < path.size(); i++) {
            List<Integer> element = path.get(counter);
            result[i][0] = element.get(0);
            result[i][1] = element.get(1);
            counter--;
        }

        return result;
    }

    private List<Node> getNeighboringNodes(Node node, List<List<Node>> nodes) {
        List<Node> neighbors = new ArrayList<>();

        int numRow = nodes.size();
        int numCols = nodes.get(0).size();

        int row = node.row;
        int col = node.col;

        if (row < numRow - 1) { // down
            neighbors.add(nodes.get(row + 1).get(col));
        }

        if (row > 0) { // up
            neighbors.add(nodes.get(row - 1).get(col));
        }

        if (col < numCols - 1) { // right
            neighbors.add(nodes.get(row).get(col + 1));
        }

        if (col > 0) { // left
            neighbors.add(nodes.get(row).get(col - 1));
        }

        return neighbors;
    }

    private int calculateManhattanDistance(Node currentNode, Node endNode) {
        int currentRow = currentNode.row;
        int currentCol = currentNode.col;
        int endRow = endNode.row;
        int endCol = endNode.col;

        return Math.abs(currentRow - endRow) + Math.abs(currentCol - endCol);
    }

    private List<List<Node>> initializeNodes(int[][] graph) {
        List<List<Node>> nodes = new ArrayList<>();
        for (int i = 0; i < graph.length; i++) {
            int[] row = graph[i];
            nodes.add(new ArrayList<>());
            for (int j = 0; j < row.length; j++) {
                int value = row[j];
                nodes.get(i).add(new Node(i, j, value));
            }
        }
        return nodes;
    }

    static class Node implements Comparable<Node> {
        String id;
        int row;
        int col;
        int value;
        int distanceFromStart;
        int estimatedDistanceToEnd;
        Node cameFrom;

        public Node(int row, int col, int value) {
            this.row = row;
            this.col = col;
            this.value = value;
            this.id = row + "-" + col;
            this.distanceFromStart = 99999; // g
            this.estimatedDistanceToEnd = 99999; // f
            this.cameFrom = null;
        }

        @Override
        public int compareTo(Node o) {
            return estimatedDistanceToEnd - o.estimatedDistanceToEnd;
        }
    }
    

}
