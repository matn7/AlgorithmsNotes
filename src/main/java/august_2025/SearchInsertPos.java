package august_2025;

public class SearchInsertPos {

    public static void main(String[] args) {
//        int[] nums = {1,3,5,6};
//        int target = 2;

        int[] nums = {1,3,5,6};
        int target = 7;

//        int[] nums = {1, 3};
//        int target = 2;

        SearchInsertPos searchInsertPos = new SearchInsertPos();
        int result = searchInsertPos.searchInsert(nums, target);
        System.out.println(result);
    }

    // O(log(n)) time | O(1) space
    public int searchInsert(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (nums[m] == target) {
                return m;
            } else if (target > nums[m]) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return l;
    }

}
