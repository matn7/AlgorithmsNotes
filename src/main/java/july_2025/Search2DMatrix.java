package july_2025;

public class Search2DMatrix {

    public static void main(String[] args) {
//        int[][] matrix = {
//                {1, 3, 5, 7},
//                {10, 11, 16, 20},
//                {23, 30, 34, 60}
//        };
//        int target = 33;

        int[][] matrix = {{1}, {3}};
        int target = 1;

        Search2DMatrix search2DMatrix = new Search2DMatrix();
        boolean result = search2DMatrix.searchMatrix(matrix, target);
        System.out.println(result);
    }

    // O(log(n)) time | O(1) space
    public boolean searchMatrix(int[][] matrix, int target) {
        int top = 0;
        int bottom = matrix.length - 1;

        int cols = matrix[0].length - 1;

        int mid = 0;
        while (top <= bottom) {
            mid = (top + bottom) / 2;

            if (target >= matrix[mid][0] && target <= matrix[mid][cols]) {
                break;
            } else if (target < matrix[mid][0]) {
                bottom = mid - 1;
            } else {
                top = mid + 1;
            }
        }

        int[] nums = matrix[mid];
        int l = 0;
        int r = nums.length - 1;

        while (l <= r) {
            int m = l + (r - l) / 2;
            if (target == nums[m]) {
                return true;
            } else if (target > nums[m]) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }

        return false;
    }

}
