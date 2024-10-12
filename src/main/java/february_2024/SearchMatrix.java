package february_2024;

public class SearchMatrix {

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 3, 5, 8},
                {10, 11, 15, 16},
                {24, 27, 30, 31}
        };

        boolean result = search(matrix, 10);
        System.out.println(result);
    }

    // O(log(n)) time | O(1) space
    public static boolean search(int[][] matrix, int value) {
        if (matrix.length == 0) {
            return false;
        }
        int rows = matrix.length;
        int cols = matrix[0].length;
        int low = 0;
        int high = rows * cols;

        while (low < high) {
            int mid = (high + low) / 2;
            int midVal = matrix[mid / cols][mid % cols];
            if (midVal == value) {
                return true;
            } else if (midVal < value) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return false;
    }

}
