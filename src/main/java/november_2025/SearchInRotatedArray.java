package november_2025;

public class SearchInRotatedArray {

    public static void main(String[] args) {
//        int[] nums = {4,5,6,7,0,1,2};
//        int target = 0;

//        int[] nums = {4,5,6,7,0,1,2};
//        int target = 3;

        int[] nums = {1};
        int target = 0;

        SearchInRotatedArray searchInRotatedArray = new SearchInRotatedArray();
        int result = searchInRotatedArray.search(nums, target);
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
            }
            if (nums[L] <= nums[M]) {
                // left sorted
                if (target >= nums[L] && target < nums[M]) {
                    R = M - 1;
                } else {
                    L = M + 1;
                }
            } else {
                // right sorted
                if (target > nums[M] && target <= nums[R]) {
                    L = M + 1;
                } else {
                    R = M - 1;
                }
            }
        }
        return -1;
    }

}
