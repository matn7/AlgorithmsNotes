package july_2025;

public class TrappingRainWater {

    public static void main(String[] args) {
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};

        TrappingRainWater trappingRainWater = new TrappingRainWater();
        int result = trappingRainWater.trap(height);
        System.out.println(result);

    }

    public int trap(int[] height) {
        // Intuition: a couple of times go through input arr
        // Approach:
        // water container arr, max pillar from L -> R
        // trap water R <- L, use water and height, in case < 0 ? -> 0
        // Complexity: O((2-3) * n) | O(n) space
        // Code:
        int[] water = new int[height.length];
        int maxL = 0;
        for (int i = 0; i < height.length; i++) {
            water[i] = maxL;
            maxL = Math.max(maxL, height[i]);
        }
        //                                *
        // [0, 0, 1, 1, 2, 2, 2, 2, 3, 3, 3, 0] - water
        // [0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1] - height
        // maxR = 2

        int maxR = height[height.length - 1]; // 1
        for (int i = height.length - 1; i >= 0; i--) {
            water[i] = Math.min(water[i], maxR);
            int sum = water[i] - height[i];
            water[i] = Math.max(sum, 0);
            maxR = Math.max(maxR, height[i]);
        }

        int res = 0;
        for (int w : water) {
            res += w;
        }
        return res;
    }

}
