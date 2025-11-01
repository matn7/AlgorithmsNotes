package october_2025;

public class TrappingRainWater {

    public static void main(String[] args) {
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        TrappingRainWater trappingRainWater = new TrappingRainWater();
        int result = trappingRainWater.trap(height);
        System.out.println(result);
    }

    // O(n) time | O(1) space
    public int trap(int[] height) {
        int l = 0;
        int r = height.length - 1;
        int maxL = height[l];
        int maxR = height[r];
        int sum = 0;

        while (l <= r) {
            if (maxL <= maxR) {
                sum += Math.max(0, maxL - height[l]);
                maxL = Math.max(maxL, height[l]);
                l++;
            } else {
                sum += Math.max(0, maxR - height[r]);
                maxR = Math.max(maxR, height[r]);
                r--;
            }
        }

        return sum;
    }

    // O(n) time | O(n) space
    public int trap2(int[] height) {
        int[] left = new int[height.length];
        int maxL = height[0];
        for (int i = 0; i < height.length; i++) {
            left[i] = maxL;
            maxL = Math.max(maxL, height[i]);
        }

        int maxR = height[height.length - 1];
        int sum = 0;
        for (int i = height.length - 1; i >= 0; i--) {
            left[i] = Math.max(0, Math.min(left[i], maxR) - height[i]);
            maxR = Math.max(maxR, height[i]);
            sum += left[i];
        }

        return sum;
    }


}
