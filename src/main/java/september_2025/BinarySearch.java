package september_2025;

public class BinarySearch {

    public static void main(String[] args) {
        int[] nums = {-1,0,3,5,9,12};
        int target = 9;

        BinarySearch binarySearch = new BinarySearch();
        int result = binarySearch.search(nums, target);
        System.out.println(result);
    }

    // O(log(n)) time | O(1) space
    public int search(int[] nums, int target) {
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
        return -1;
    }

}
