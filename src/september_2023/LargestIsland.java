package september_2023;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LargestIsland {

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 0, 1, 0, 0},
                {0, 0, 1, 0, 0},
                {0, 1, 1, 1, 1},
                {1, 0, 1, 0, 0}
        };

        // 0 - land
        // 1 - water

        LargestIsland largestIsland = new LargestIsland();
        largestIsland.largestIsland(matrix);
    }

    // O(w*h) time | O(w*h) space
    public int largestIsland(int[][] matrix) {
        // Write your code here.
        List<Integer> islandSizes = new ArrayList<>();
        int islandNumber = 2;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == 0) {
                    islandSizes.add(getSizeFromNode(row, col, matrix, islandNumber));
                    islandNumber++;
                }
            }
        }
        int maxSize = 0;
        List<int[]> landNeighbors = new ArrayList<>();
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] != 1) {
                    continue;
                }

                getLandNeighbors(row, col, matrix, landNeighbors);
                Set<Integer> islands = new HashSet<>();
                for (int[] neighbor : landNeighbors) {
                    islands.add(matrix[neighbor[0]][neighbor[1]]);
                }

                int size = 1;
                for (int island : islands) {
                    size += islandSizes.get(island - 2);
                }
                maxSize = Math.max(maxSize, size);
            }
        }
        return maxSize;
    }

    private int getSizeFromNode(int row, int col, int[][] matrix, int islandNumber) {
        int size = 0;
        List<int[]> nodesToExplore = new ArrayList<>();
        nodesToExplore.add(new int[] {row, col});
        while (!nodesToExplore.isEmpty()) {
            int[] currentNode = nodesToExplore.remove(0);
            int currentRow = currentNode[0];
            int currentCol = currentNode[1];

            if (matrix[currentRow][currentCol] != 0) {
                continue;
            }

            matrix[currentRow][currentCol] = islandNumber;
            size += 1;
            getLandNeighbors(currentRow, currentCol, matrix, nodesToExplore);
        }
        return size;
    }

    private void getLandNeighbors(int row, int col, int[][] matrix, List<int[]> nodesToExplore) {
//        List<int[]> nodesToExplore = new ArrayList<>();
        if (row > 0 && matrix[row - 1][col] != 1) {
            nodesToExplore.add(new int[] {row - 1, col});
        }
        if (row < matrix.length - 1 && matrix[row + 1][col] != 1) {
            nodesToExplore.add(new int[] {row + 1, col});
        }
        if (col > 0 && matrix[row][col - 1] != 1) {
            nodesToExplore.add(new int[] {row, col - 1});
        }
        if (col < matrix[row].length - 1 && matrix[row][col + 1] != 1) {
            nodesToExplore.add(new int[] {row, col + 1});
        }
//        return nodesToExplore;
    }

//    // O(w^2*h^2) time | O(w*h) space
//    public int largestIsland(int[][] matrix) {
//        // Write your code here.
//        int maxSize = 0;
//        for (int row = 0; row < matrix.length; row++) {
//            for (int col = 0; col < matrix[row].length; col++) {
//                if (matrix[row][col] == 0) {
//                    continue;
//                }
//
//                maxSize = Math.max(maxSize, getSizeFromNode(row, col, matrix));
//            }
//        }
//        return maxSize;
//    }
//
//    private int getSizeFromNode(int row, int col, int[][] matrix) {
//        int size = 1;
//        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
//        List<int[]> nodesToExplore = new ArrayList<>();
//        getLandNeighbors(row, col, matrix, nodesToExplore);
//        while (!nodesToExplore.isEmpty()) {
//            int[] currentNode = nodesToExplore.remove(0);
//            int currentRow = currentNode[0];
//            int currentCol = currentNode[1];
//
//            if (visited[currentRow][currentCol]) {
//                continue;
//            }
//
//            visited[currentRow][currentCol] = true;
//            size += 1;
//            getLandNeighbors(currentRow, currentCol, matrix, nodesToExplore);
//        }
//        return size;
//    }
//
//    private void getLandNeighbors(int row, int col, int[][] matrix, List<int[]> nodesToExplore ) {
//        if (row > 0 && matrix[row - 1][col] != 1) {
//            nodesToExplore.add(new int[] {row - 1, col});
//        }
//        if (row < matrix.length - 1 && matrix[row + 1][col] != 1) {
//            nodesToExplore.add(new int[] {row + 1, col});
//        }
//        if (col > 0 && matrix[row][col - 1] != 1) {
//            nodesToExplore.add(new int[] {row, col - 1});
//        }
//        if (col < matrix[row].length - 1 && matrix[row][col + 1] != 1) {
//            nodesToExplore.add(new int[] {row, col + 1});
//        }
//    }


}
