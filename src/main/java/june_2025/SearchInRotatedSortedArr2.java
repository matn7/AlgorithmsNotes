package june_2025;

public class SearchInRotatedSortedArr2 {

    public static void main(String[] args) {
//        int[] nums = {4,5,6,7,0,1,2};
//        int target = 0;

//        int[] nums = {4,5,6,7,0,1,2};
//        int target = 3;

        int[] nums = {1, 3};
        int target = 3;


        SearchInRotatedSortedArr2 searchInRotatedSortedArr2 = new SearchInRotatedSortedArr2();
        int result = searchInRotatedSortedArr2.search(nums, target);
        System.out.println(result);
    }
    // O(log(n)) time | O(1) space
    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;

        while (l <= r) {
            int m = (l + r) / 2;

            if (nums[m] == target) {
                return m;
            }
            if (nums[l] <= nums[m]) {
                // left sorted
                if (target >= nums[l] && target < nums[m]) {
                    r = m - 1;
                } else {
                    l = m + 1;
                }
            } else {
                // right sorted
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
