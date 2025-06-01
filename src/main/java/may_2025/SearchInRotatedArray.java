package may_2025;

public class SearchInRotatedArray {

    public static void main(String[] args) {
//        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int[] nums = {6, 7, 0, 1, 2, 4, 5};
        int target = 0;

        SearchInRotatedArray searchInRotatedArray = new SearchInRotatedArray();
        int result = searchInRotatedArray.search(nums, target);
        System.out.println(result);
    }

    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;

        while (l <= r) {
            int m = (r + l) / 2;
            if (nums[m] == target) {
                return m;
            }
            if (nums[l] <= nums[m]) {
                if (target >= nums[l] && target <= nums[m]) {
                    if (target > nums[m]) {
                        l = m + 1;
                    } else {
                        r = m - 1;
                    }
                } else {
                    l = m + 1;
                }
            } else {
                if (target >= nums[m] && target <= nums[r]) {
                    if (target > nums[m]) {
                        l = m + 1;
                    } else {
                        r = m - 1;
                    }
                } else {
                    r = m - 1;
                }
            }
        }
        return -1;
    }

}
