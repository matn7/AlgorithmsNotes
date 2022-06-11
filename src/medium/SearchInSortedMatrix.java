package medium;

public class SearchInSortedMatrix {

    public static void main(String[] args) {
        int[][] matrix = {{1,    4,   7,  12,  15, 1000},
                          {2,    5,   19,  31,  32, 1001},
                          {3,    8,   24,  33,  35, 1002},
                          {40,  41,   42,  44,  45, 1003},
                          {99, 100,  103, 106, 128, 1004}};

        int[] array = {1,    4,   7,  12,  15, 1000};

        searchInArray(array, 15);

        int[] ints = searchInSortedMatrix(matrix, 100);

        for (int i = 0 ; i < ints.length; i++) {
            System.out.println(ints[i]);
        }
    }

    public static int searchInArray(int[] array, int target) {
        int min = 0;
        int max = array.length;

        while (min <= max) {
            int mid = (min + max) / 2;
            if (array[mid] == target) {
                return mid;
            } else if (array[mid] < target) {
                min = mid + 1;
            } else {
                max = mid - 1;
            }
        }
        return -1;
    }

    public static int[] searchInSortedMatrix(int[][] matrix, int target) {
        // Write your code here.
        int colMin = 0;
        int colMax = matrix[0].length - 1;

        int rowMin = 0;
        int rowMax = matrix.length - 1;

        while (colMin <= colMax && rowMin <= rowMax) {
            // check current min-max
            for (int row = rowMin; row <= rowMax; row++) {
                if (matrix[row][colMin] == target) {
                    return new int[] {row, colMin};
                }
            }
            for (int col = colMin; col <= colMax; col++) {
                if (matrix[rowMin][col] == target) {
                    return new int[] {rowMin, col};
                }
            }
            for (int col = colMin; col <= colMax; col++) {
                if (matrix[rowMax][col] == target) {
                    return new int[] {rowMax, col};
                }
            }

            int colMidIdx = (colMin + colMax) / 2;
            int rowMidIdx = (rowMin + rowMax) / 2;
            if (matrix[rowMidIdx][colMidIdx] == target) {
                return new int[] {rowMidIdx, colMidIdx};
            }
            // check along row and col whether we can find
            for (int row = rowMidIdx; row <= rowMax; row++) {
                if (matrix[row][colMidIdx] == target) {
                    return new int[] {row, colMidIdx};
                }
            }
            for (int col = colMidIdx; col <= colMax; col++) {
                if (matrix[rowMidIdx][col] == target) {
                    return new int[] {rowMidIdx, col};
                }
            }

            if (matrix[rowMidIdx][colMidIdx] < target) {
                colMin = colMidIdx + 1;
                rowMin = rowMidIdx - 1;
            } else {
                colMax = colMidIdx - 1;
                rowMax = rowMidIdx + 1;
            }

        }

        return new int[] {-1, -1};
    }

}
