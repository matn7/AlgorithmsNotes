package whiteboard;

import java.util.*;

public class AStarAlgorithmMy {

    public static void main(String[] args) {
        AStarAlgorithmMy aStarAlgorithmRand = new AStarAlgorithmMy();
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
        List<List<Node>> nodeGraph = new ArrayList<>();
        boolean foundResult = false;
        for (int row = 0; row < graph.length; row++) {
            nodeGraph.add(new ArrayList<>());
            for (int col = 0; col < graph[row].length; col++) {
                int distance = calculateManhattanDistance(row, col, endRow, endCol);
                nodeGraph.get(row).add(new Node(row, col, distance));
            }
        }
        Node startNode = nodeGraph.get(startRow).get(startCol);
        Node endNode = nodeGraph.get(endRow).get(endCol);
        startNode.distanceFromStart = 0;
        startNode.recalculateHeuristic();
        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.add(startNode);

        while (!queue.isEmpty()) {
            Node curr = queue.poll();
            if (curr.visited) {
                continue;
            }
            curr.visited = true;
            if (curr == endNode) {
                // break
                foundResult = true;
                break;
            }
            List<Node> neighbors = getNeighbors(curr, nodeGraph, graph);
            for (Node neighbor : neighbors) {
                neighbor.cameFrom = curr;
                neighbor.distanceFromStart = Math.min(neighbor.distanceFromStart, curr.distanceFromStart + 1);
                neighbor.recalculateHeuristic();

                queue.add(neighbor);
            }
        }

        if (!foundResult) {
            return new int[][] {};
        }

        Stack<Node> path = new Stack<>();
        Node currNode = endNode;
        while (currNode.cameFrom != null) {
            path.push(currNode);
            currNode = currNode.cameFrom;
        }
        path.push(startNode);
        int[][] result = new int[path.size()][2];
        int index = 0;
        while (!path.isEmpty()) {
            Node current = path.pop();
            result[index][0] = current.x;
            result[index][1] = current.y;
            index++;
        }

        return result;
    }

    private List<Node> getNeighbors(Node curr, List<List<Node>> nodeGraph, int[][] graph) {
        List<Node> neighbors = new ArrayList<>();
        int currRow = curr.x;
        int currCol = curr.y;
        if (currRow > 0) { // north
            if (!nodeGraph.get(currRow - 1).get(currCol).visited && graph[currRow - 1][currCol] == 0) {
                neighbors.add(nodeGraph.get(currRow - 1).get(currCol));
            }
        }
        if (currRow < graph.length - 1) { // south
            if (!nodeGraph.get(currRow + 1).get(currCol).visited && graph[currRow + 1][currCol] == 0) {
                neighbors.add(nodeGraph.get(currRow + 1).get(currCol));
            }
        }
        if (currCol > 0) { // west
            if (!nodeGraph.get(currRow).get(currCol - 1).visited && graph[currRow][currCol - 1] == 0) {
                neighbors.add(nodeGraph.get(currRow).get(currCol - 1));
            }
        }
        if (currCol < graph[currRow].length - 1) { // east
            if (!nodeGraph.get(currRow).get(currCol + 1).visited && graph[currRow][currCol + 1] == 0) {
                neighbors.add(nodeGraph.get(currRow).get(currCol + 1));
            }
        }
        return neighbors;
    }

    private int calculateManhattanDistance(int startRow, int startCol, int endRow, int endCol) {
        return Math.abs(endRow - startRow) + Math.abs(endCol - startCol);
    }

    static class Node implements Comparable<Node> {
        int x; // row
        int y; // col
        int distanceFromStart = 9999;
        int distanceToDestination = 9999;
        Node cameFrom;
        boolean visited = false;
        int heuristic;

        public Node(int x, int y, int distanceToDestination) {
            this.x = x;
            this.y = y;
            this.distanceToDestination = distanceToDestination;
        }

        public void recalculateHeuristic() {
            heuristic = distanceFromStart + distanceToDestination;
        }

        @Override
        public int compareTo(Node o) {
            return heuristic - o.heuristic;
        }
    }

}
