package august_2024;

public class LargestRectangleUnderSkylineV3 {

    public static void main(String[] args) {
        int[] nums = {1, 3, 3, 2, 4, 1, 5, 3, 9};

        int result = largestRectangleUnderSkyline(nums);
        System.out.println(result);
    }

    // O(n^2) time | O(1) space
    public static int largestRectangleUnderSkyline(int[] nums) {
        int maxArea = 0;

        for (int i = 0; i < nums.length; i++) {
            int currBuilding = nums[i]; // 1
            int width = 1;
            int next = i + 1;
            int prev = i - 1;
            while (next < nums.length && currBuilding <= nums[next]) {
                width++;
                next++;
            }
            while (prev >= 0 && currBuilding <= nums[prev]) {
                width++;
                prev--;
            }
            int currentArea = currBuilding * width;
            maxArea = Math.max(currentArea, maxArea);
        }

        return maxArea;
    }

}
