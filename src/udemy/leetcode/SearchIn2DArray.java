package udemy.leetcode;

public class SearchIn2DArray {

    public static void main(String[] args) {
        // Q4. Search in sorted 2d array
        int[][] arr = {
                {1, 2, 3},
                {8, 9, 10},
                {18, 19, 20}
        };
        int target = 9;
        SearchIn2DArray searchIn2DArray = new SearchIn2DArray();
        searchIn2DArray.linearSearch5(arr, target);
    }

    public int[] linearSearch5(int[][] arr, int target) {
        int row = 0;
        int col = arr[0].length - 1;
        while (row < arr.length && col > 0) {
            if (arr[row][col] == target) {
                return new int[] {row, col};
            } else if (arr[row][col] < target) {
                row++;
            } else {
                col--;
            }
        }
        return new int[] {-1, -1};
    }

}
