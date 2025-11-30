package november_2025;

public class FindTheInsertionIndex {

    public static void main(String[] args) {
//        int[] nums = {1,3,5,6};
//        int target = 2;

        int[] nums = {1,3,5,6};
        int target = 7;

        FindTheInsertionIndex findTheInsertionIndex = new FindTheInsertionIndex();
        int result = findTheInsertionIndex.searchInsert(nums, target);
        System.out.println(result);
    }

    // O(log(n)) time | O(1) space
    public int searchInsert(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;

        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (target == nums[mid]) {
                return mid;
            } else if (target > nums[mid]) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }


}
