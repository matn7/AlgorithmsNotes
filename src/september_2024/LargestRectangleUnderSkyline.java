package september_2024;

public class LargestRectangleUnderSkyline {

    public static void main(String[] args) {
        int[] nums = {1, 3, 3, 2, 4, 1, 3, 3, 19};

        int result = largestRectangle(nums);
        System.out.println(result);
    }

    // O(n^2) time | O(1) space
    public static int largestRectangle(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int maxArea = 0;
        for (int idx = 0; idx < nums.length; idx++) {
            int height = nums[idx];
            int width = 1;
            int left = idx - 1;
            while (left >= 0 && nums[left] >= height) {
                left--;
                width++;
            }
            int right = idx + 1;
            while (right < nums.length && nums[right] >= height) {
                right++;
                width++;
            }
            maxArea = Math.max(maxArea, height * width);
        }
        return maxArea;
    }

}
