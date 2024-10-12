package october_2024;

public class TrappingRainWater {

    public static void main(String[] args) {
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};

        TrappingRainWater trappingRainWater = new TrappingRainWater();
        int trap = trappingRainWater.trap2(height);
        System.out.println(trap);
    }

    // O(n) time | O(n) space
    public int trap(int[] height) {
        if (height.length <= 2) {
            return 0;
        }
        int[] trap = new int[height.length];
        int leftMax = height[0];
        for (int i = 0; i < height.length; i++) {
            trap[i] = leftMax;
            leftMax = Math.max(leftMax, height[i]);
        }
        int rightMax = height[height.length - 1];
        for (int i = height.length - 1; i >= 0; i--) {
            int h = Math.min(trap[i], rightMax) - height[i];
            if (h < 0) {
                h = 0;
            }
            trap[i] = h;
            rightMax = Math.max(rightMax, height[i]);
        }
        int sum = 0;
        for (int num : trap) {
            sum += num;
        }
        return sum;
    }

    // O(n) time | O(1) space
    public int trap2(int[] height) {
        if (height.length <= 2) {
            return 0;
        }
        int left = 0;
        int right = height.length - 1;
        int maxL = height[left];
        int maxR = height[right];
        int sum = 0;
        while (left < right) {
            if (maxL < maxR) {
                left++;
                maxL = Math.max(maxL, height[left]);
                sum += maxL - height[left];
            } else {
                right--;
                maxR = Math.max(maxR, height[right]);
                sum += maxR - height[right];
            }
        }
        return sum;
    }

}
