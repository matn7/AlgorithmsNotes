package whiteboard;

import java.util.*;

public class AStarAlgorithmMy {

    public static void main(String[] args) {
        int[][] graph = {
                {0, 0, 0, 0, 0},
                {0, 1, 1, 1, 0},
                {0, 0, 0, 0, 0},
                {1, 0, 1, 1, 1},
                {0, 0, 0, 0, 0}
        };

        AStarAlgorithmMy aStarAlgorithm = new AStarAlgorithmMy();
        int[][] result = aStarAlgorithm.aStarAlgorithm(0, 1, 4, 3, graph);
        System.out.println(result);
    }

    // O(w*h*log(w * h)) time | O(w * h) space
    public int[][] aStarAlgorithm(int startRow, int startCol, int endRow, int endCol, int[][] graph) {
        // Write your code here.
        Map<String, Node> adjList = new HashMap<>();
        for (int row = 0; row < graph.length; row++) {
            for (int col = 0; col < graph[row].length; col++) {
                String key = row + ":" + col;
                int distEnd = calculateManhattanDistance(row, endRow, col, endCol);
                adjList.put(key, new Node(key, row, col, distEnd));
            }
        }
        String startKey = startRow + ":" + startCol;
        Node startNode = adjList.get(startKey);
        String endKey = endRow + ":" + endCol;
        Node endNode = adjList.get(endKey);
        startNode.recalculateHeuristic();
        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.add(startNode);
        while (!queue.isEmpty()) {
            Node curr = queue.poll();
            if (curr == endNode) {
                break;
            }
            if (curr.visited) {
                continue;
            }
            curr.visited = true;
            List<Node> neighbors = getNeighbors(graph, curr, adjList);
            for (Node neighbor : neighbors) {
                neighbor.distStart = 1 + curr.distStart;
                neighbor.recalculateHeuristic();
                neighbor.cameFrom = curr;
                queue.add(neighbor);
            }
        }
        if (endNode.cameFrom == null) {
            return new int[][] {};
        }
        List<Integer[]> pathList = new ArrayList<>();
        Node currentNode = endNode;
        while (currentNode != null) {
            pathList.add(new Integer[]{currentNode.row, currentNode.col});
            currentNode = currentNode.cameFrom;
        }
//        pathList.add(new Integer[]{startNode.row, startNode.col});
        Collections.reverse(pathList);
        int[][] result = new int[pathList.size()][2];
        for (int i = 0; i < pathList.size(); i++) {
            result[i][0] = pathList.get(i)[0];
            result[i][1] = pathList.get(i)[1];
        }
        return result;
    }

    private List<Node> getNeighbors(int[][] graph, Node node, Map<String, Node> adjList) {
        List<Node> neighbors = new ArrayList<>();
        int row = node.row;
        int col = node.col;
        int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

        for (int[] direction : directions) {
            int newRow = row + direction[0];
            int newCol = col + direction[1];
            if (isValidCoord(newRow, newCol, graph)) {
                addOneNode(adjList, neighbors, newRow, newCol, graph);
            }
        }

        return neighbors;
    }

    private boolean isValidCoord(int row, int col, int[][] graph) {
        return row >= 0 && row <= graph.length - 1 && col >= 0 && col <= graph[row].length - 1 ;
    }

    private void addOneNode(Map<String, Node> adjList, List<Node> neighbors, int row, int col, int[][] graph) {
        String key = row + ":" + col;
        Node neighbor = adjList.get(key);
        if (!neighbor.visited && graph[row][col] == 0) {
            neighbors.add(neighbor);
        }
    }

    private int calculateManhattanDistance(int sR, int eR, int sC, int eC) {
        return Math.abs(eR - sR) + Math.abs(eC - sC);
    }

    class Node implements Comparable<Node> {
        String key;
        int row;
        int col;
        int distStart;
        int distEnd;
        int heuristic;
        boolean visited;
        Node cameFrom;

        public Node(String key, int row, int col, int distEnd) {
            this.key = key;
            this.row = row;
            this.col = col;
            this.distEnd = distEnd;
        }

        public void recalculateHeuristic() {
            this.heuristic = this.distStart + this.distEnd;
        }

        @Override
        public int compareTo(Node o) {
            return this.heuristic - o.heuristic;
        }
    }

}
