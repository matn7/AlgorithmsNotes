package april_2024;

public class TappingRainWater {

    public static void main(String[] args) {
//        int[] heights = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int[] heights = {0, 8, 0, 0, 5, 0, 0, 10, 0, 0, 1, 1, 0, 3};

        int result = trap(heights);
        System.out.println(result);
    }

    // O(n) time | O(n) space
    public static int trap(int[] height) {
        if (height.length < 2) {
            return 0;
        }
        int[] left = new int[height.length];
        int[] res = new int[height.length];
        int leftMax = height[0];

        for (int i = 0; i < height.length; i++) {
            leftMax = Math.max(leftMax, height[i]);
            left[i] = leftMax;
        }

        int rightMax = height[height.length - 1];
        for (int i = height.length - 1; i >= 0; i--) {
            rightMax = Math.max(rightMax, height[i]);
            res[i] = Math.min(rightMax, left[i]) - height[i];
        }

        int sum = 0;
        for (int num : res) {
            sum += num;
        }
        return sum;
    }

}
