package june_2025;

public class SearchInRotatedSortedArray {

    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0,1,2};
        int target = 0;

        SearchInRotatedSortedArray search = new SearchInRotatedSortedArray();
        int result = search.search(nums, target);
        System.out.println(result);
    }

    public int search(int[] nums, int target) {
        int L = 0;
        int R = nums.length - 1;

        while (L <= R) {
            int M = L + (R - L) / 2;
            if (nums[M] == target) {
                return M;
            }
            if (nums[L] <= nums[M]) {
                // left sorted
                if (target >= nums[L] && target < nums[M]) {
                    // regular BS
                    R = M - 1;
                } else {
                    L = M + 1;
                }
            } else {
                // right sorted
                if (target > nums[M] && target <= nums[R]) {
                    // regular BS
                    L = M + 1;
                } else {
                    R = M - 1;
                }
            }
        }
        return -1;
    }

}
