package medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RiverSizesREPEAT {

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 0, 0, 1, 0},
                {1, 0, 1, 0, 0},
                {0, 0, 1, 0, 1},
                {1, 0, 1, 0, 1},
                {1, 0, 1, 1, 0},
        };

        riverSizes(matrix);
    }

    // O(w*h) or O(n) time | O(w*h) space
    // OK - repeated 13/02/2022
    public static List<Integer> riverSizes(int[][] matrix) {
        // Write your code here.
        List<Integer> sizes = new ArrayList<>();
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
//                      j
//         0  1  2  3  4
//        [T, T, T, T, T],  0
//        [T, T, T, T, T],  1
//        [T, T, T, T, T],  2
//        [T, T, T, T, T],  3 i
//        [T, T, T, T, T],  4
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (visited[i][j]) {
                    continue;
                }
                traverseNode(i, j, matrix, visited, sizes);
            }
        }
        return sizes;
    }

//         j                        j
//         0  1  2  3  4            0  1  2  3  4
//        [1, 0, 0, 1, 0],  0      [T, T, T, T, T],  0
//        [1, 0, 1, 0, 0],  1      [T, T, T, T, T],  1
//        [0, 0, 1, 0, 1],  2      [T, T, T, T, T],  2
//        [1, 0, 1, 0, 1],  3      [T, T, T, T, T],  3 i
//        [1, 0, 1, 1, 0],  4      [T, T, T, T, T],  4
    // rec(3, 0)
    private static void traverseNode(int i, int j, int[][] matrix, boolean[][] visited, List<Integer> sizes) {
        int currentRiverSize = 0;
        Queue<NodeToExplore> nodesToExplore = new LinkedList<>();
        nodesToExplore.add(new NodeToExplore(i, j));

        // --------------------
        //
        // --------------------
        while (!nodesToExplore.isEmpty()) {
            NodeToExplore currentNode = nodesToExplore.poll(); // (4,0)
            i = currentNode.i; // 4
            j = currentNode.j; // 0
            if (visited[i][j]) {
                continue;
            }
            visited[i][j] = true;
            if (matrix[i][j] == 0) {
                continue;
            }
            currentRiverSize++; // 2
            List<NodeToExplore> unvisitedNeighbors = getUnvisitedNeighbors(i, j, matrix, visited); // at most 4
            // [(4,0)]
            for (NodeToExplore neighbor : unvisitedNeighbors) {
                nodesToExplore.add(neighbor);
            }
        }
        if (currentRiverSize > 0) {
            sizes.add(currentRiverSize); // [2, 1, 5, 2, 2]
        }
    }

//                     j                        j
//         0  1  2  3  4            0  1  2  3  4
//        [1, 0, 0, 1, 0],  0      [T, T, T, T, T],  0
//        [1, 0, 1, 0, 0],  1      [T, T, T, T, T],  1
//        [0, 0, 1, 0, 1],  2      [T, T, T, T, T],  2 2
//        [1, 0, 1, 0, 1],  3      [T, T, T, T, T],  3
//        [1, 0, 1, 1, 0],  4      [T, T, T, T, T],  4
    // rec(3,0)
    private static List<NodeToExplore> getUnvisitedNeighbors(int i, int j, int[][] matrix, boolean[][] visited) {
        List<NodeToExplore> unvisitedNeighbors = new ArrayList<>();
        if (i > 0 && !visited[i-1][j]) {
            unvisitedNeighbors.add(new NodeToExplore(i - 1, j));
        }
        if (i < matrix.length - 1 && !visited[i+1][j]) {
            unvisitedNeighbors.add(new NodeToExplore(i + 1, j));
        }
        if (j > 0 && !visited[i][j - 1]) {
            unvisitedNeighbors.add(new NodeToExplore(i, j - 1));
        }
        if (j < matrix[i].length - 1 && !visited[i][j + 1]) {
            unvisitedNeighbors.add(new NodeToExplore(i, j + 1));
        }
        return unvisitedNeighbors; // [(4,0)]
    }

    static class NodeToExplore {
        int i;
        int j;

        public NodeToExplore(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

}
