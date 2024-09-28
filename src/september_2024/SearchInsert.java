package september_2024;

public class SearchInsert {

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 6};

        SearchInsert searchInsert = new SearchInsert();
        int result = searchInsert.searchInsert(nums, 0);
        System.out.println(result);
    }

    // O(log(n)) time | O(1) space
    public int searchInsert(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int mid = 0;
        while (start <= end) {
            mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        if (nums[mid] < target) {
            return mid + 1;
        }
        return mid;
    }

}
