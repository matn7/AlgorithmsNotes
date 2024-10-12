package september_2024;

public class SearchInRotatedArray {

    public static void main(String[] args) {
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
//        int[] nums = {1, 3, 5};
        int target = 0;

        SearchInRotatedArray search = new SearchInRotatedArray();
        int result = search.search(nums, target);
        System.out.println(result);
    }

    // O(log(n)) time | O(1) space
    public int search(int[] nums, int target) {
        //  0  1  2
        // [1, 3, 5]
        //  s     e
        //     m

        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) { // 1 < 3
                // left part is sorted
                if (nums[end] >= nums[mid] && nums[end] < target) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }

            } else {
                if (nums[start] <= nums[mid] && nums[start] > target) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return -1;
    }

}
