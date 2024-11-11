package october_2024;

public class FindMin {

    public static void main(String[] args) {
        int[] nums = {3, 4, 5, 1, 2};

        FindMin findMin = new FindMin();
        findMin.findMin(nums);
    }

    // O(log(n)) time | O(1) space
    public int findMin(int[] nums) {
        int s = 0;
        int e = nums.length - 1;
        int min = Integer.MAX_VALUE;
        while (s <= e) {
            int mid = (s + e) / 2;

            if (nums[s] <= nums[mid]) {
                // increasing slope result probably on right
                min = Math.min(min, nums[s]);
                s = mid + 1;
            } else {
                // result is somewhere between s and e
                min = Math.min(min, nums[mid]);
                e = mid - 1;
            }
        }
        return min;
    }

}
