package may_2025;

public class SearchMatrix {

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 60}
        };
        int target = 0;

        SearchMatrix searchMatrix = new SearchMatrix();
        boolean result = searchMatrix.searchMatrix(matrix, target);
        System.out.println(result);
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int r1 = 0;
        int r2 = matrix.length - 1;
        int cols = matrix[0].length - 1;
        int row = 0;
        while (r1 <= r2) {
            row = (r2 + r1) / 2;
            int first = matrix[row][0];
            int last = matrix[row][cols];
            if (target == last || target == first) {
                return true;
            }
            if (target > first && target < last) {
                break;
            }
            if (target < last) {
                r2 = row - 1;
            } else {
                r1 = row + 1;
            }
        }
        if (r2 < r1) {
            return false;
        }
        int[] nums = matrix[row];
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int mid = (r + l) / 2;
            if (target == nums[mid]) {
                return true;
            }
            if (target > nums[mid]) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return false;
    }

}
