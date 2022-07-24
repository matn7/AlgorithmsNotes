package whiteboard;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RiverSizes2 {

    public static List<Integer> riverSizes(int[][] matrix) {
        // Write your code here.
        List<Integer> result = new ArrayList<>();
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];

        for (int row = 0; row < matrix.length - 1; row++) {
            for (int col = 0; col < matrix[row].length - 1; col++) {
                if (!visited[row][col]) {
                    explore(matrix, row, col, visited, result);
                }
            }
        }

        return result;
    }

    private static void explore(int[][] matrix, int row, int col, boolean[][] visited, List<Integer> result) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(row, col));
        int riverSize = 0;
        while (!queue.isEmpty()) {
            Node currNode = queue.poll();
            int currRow = currNode.row;
            int currCol = currNode.col;
            int currVal = matrix[currRow][currCol];
            if (currVal == 0) {
                visited[currRow][currCol] = true;
                continue;
            }
            if (visited[currRow][currCol]) {
                continue;
            }
            visited[currRow][currCol] = true;
            riverSize++;
            List<Node> neighbors = getNeighbors(matrix, currRow, currCol, visited);
            for (Node neighbor : neighbors) {
                queue.add(neighbor);
            }
        }
        if (riverSize != 0) {
            result.add(riverSize);
        }
    }

    private static List<Node> getNeighbors(int[][] matrix, int row, int col, boolean[][] visited) {
        List<Node> neighbors = new ArrayList<>();
        if (row > 0) {
            if (!visited[row - 1][col]) {
                neighbors.add(new Node(row - 1, col));
            }
        }
        if (row < matrix.length - 1) {
            if (!visited[row + 1][col]) {
                neighbors.add(new Node(row + 1, col));
            }
        }
        if (col > 0) {
            if (!visited[row][col - 1]) {
                neighbors.add(new Node(row, col - 1));
            }
        }
        if (col < matrix[row].length - 1) {
            if (!visited[row][col + 1]) {
                neighbors.add(new Node(row, col + 1));
            }
        }
        return neighbors;
    }

    static class Node {
        int row;
        int col;

        public Node(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

}
