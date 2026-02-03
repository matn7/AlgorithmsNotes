package february_2026;

public class SearchInRotatedSortedArray {

    public static void main(String[] args) {
//        int[]  nums = {4,5,6,7,0,1,2};
//        int target = 0;

        int[] nums = {4,5,6,7,0,1,2};
        int target = 3;

        SearchInRotatedSortedArray searchInRotatedSortedArray = new SearchInRotatedSortedArray();
        int result = searchInRotatedSortedArray.search(nums, target);
        System.out.println(result);
    }

    // O(log(n)) time | O(1) space
    public int search(int[] nums, int target) {
        int L = 0;
        int R = nums.length - 1;

        while (L <= R) {
            int M = (L + R) / 2;
            if (target == nums[M]) {
                return M;
            } else {
                // left sorted
                if (nums[L] <= nums[M]) {
                    if (target >= nums[L] && target < nums[M]) {
                        R = M - 1;
                    } else {
                        L = M + 1;
                    }
                } else {
                    // Right sorted
                    if (target > nums[M] && target <= nums[R]) {
                        L = M + 1;
                    } else {
                        R = M - 1;
                    }
                }
            }
        }
        return -1;
    }

}
