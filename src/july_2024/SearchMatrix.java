package july_2024;

public class SearchMatrix {

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 3, 5, 8},
                {10, 11, 15, 16},
                {24, 27, 30, 31}
        };

        int value = 10;
        boolean search = search(matrix, value);
        System.out.println(search);
    }

    // O(log(n)) time | O(1) space
    public static boolean search(int[][] matrix, int value) {
        if (matrix.length == 0) {
            return false;
        }
        int rows = matrix.length - 1; // 3
        int cols = matrix[0].length; // 4
        int low = 0;
        int high = rows * cols;

        //  0  1  2  3    4   5   6   7     8   9   10  11
        // [1, 3, 5, 8], [10, 11, 15, 16], [24, 27, 30, 31]
        //           l         h

        while (low < high) {
            int mid = (low + high) / 2; // 8 / 2 = 4
            int midVal = matrix[mid / cols][mid % cols]; // [4 / 4 = 1][4 % 4 = 0] = 10
            if (midVal == value) { // 10 == 10
                return true;
            }
            if (midVal < value) { // 5 < 10
                low = mid + 1;
            } else { // 11 > 10
                high = mid;
            }
        }
        return false;
    }

}
