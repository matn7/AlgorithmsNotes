package october_2024;

public class SearchRange {

    public static void main(String[] args) {
        int[] nums = {5, 7, 7, 8, 8, 10};
        int target = 89;

        SearchRange searchRange = new SearchRange();
        int[] result = searchRange.searchRange(nums, target);
        System.out.println();
    }

    public int[] searchRange(int[] nums, int target) {

        int leftIdx = binarySearch(nums, target, true);
        int rightIdx = binarySearch(nums, target, false);

        if (leftIdx == -1) {
            return new int[] {-1, -1};
        }

        return new int[] {leftIdx, rightIdx};
    }

    private int binarySearch(int[] nums, int target, boolean searchLeft) {
        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] == target) {
                // search range
                if (searchLeft) {
                    if (mid == 0 || nums[mid - 1] != target) {
                        return mid;
                    }
                    end = mid - 1;
                } else {
                    if (mid == nums.length - 1 || nums[mid + 1] != target) {
                        return mid;
                    }
                    start = mid + 1;
                }
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }

}
