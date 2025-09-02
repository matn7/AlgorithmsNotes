package august_2025;

public class SearchInRotatedArr {

    // O(log(n)) time | O(1) space
    public int search(int[] nums, int target) {
        //        M
        // [4,5,6,7,0,1,2]
        //  L           R
        int l = 0;
        int r = nums.length - 1;

        while (l <= r) {
            int m = (l + r) / 2;
            if (nums[m] == target) {
                return m;
            } else if (nums[l] <= nums[m]) {
                // left sorted
                if (target >= nums[l] && target < nums[m]) {
                    // regular bs
                    r = m - 1;
                } else {
                    l = m + 1;
                }
            } else {
                if (target > nums[m] && target <= nums[r]) {
                    l = m + 1;
                } else {
                    r = m - 1;
                }
            }
        }

        return -1;
    }

}
