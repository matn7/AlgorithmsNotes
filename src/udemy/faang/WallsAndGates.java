package udemy.faang;

public class WallsAndGates {

    static int GATE = 0;
    static int WALL = -1;
    static int EMPTY = Integer.MAX_VALUE;

    int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public static void main(String[] args) {
        int[][] matrix = {
                {EMPTY, WALL, GATE, EMPTY},
                {EMPTY, EMPTY, EMPTY, WALL},
                {EMPTY, WALL, EMPTY, WALL},
                {GATE, WALL, EMPTY, EMPTY}
        };

        WallsAndGates wallsAndGates = new WallsAndGates();
        wallsAndGates.wallsAndGates(matrix);

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    // O(w * h) time | O(w * h) space
    public int[][] wallsAndGates(int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == GATE) {
                    dfs(matrix, row, col, 0);
                }
            }
        }
        return matrix;
    }

    private void dfs(int[][] matrix, int row, int col, int currentStep) {
        if (row < 0 || row >= matrix.length || col < 0 || col >= matrix[row].length || currentStep > matrix[row][col]) {
            return;
        }

        matrix[row][col] = currentStep;
        for (int i = 0; i < directions.length; i++) {
            int[] currDir = directions[i];
            dfs(matrix, row + currDir[0], col + currDir[1], currentStep + 1);
        }
    }

}
