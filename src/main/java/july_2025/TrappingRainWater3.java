package july_2025;

public class TrappingRainWater3 {

    public static void main(String[] args) {
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        TrappingRainWater3 trappingRainWater3 = new TrappingRainWater3();
        int result = trappingRainWater3.trap(height);
        System.out.println(result);
    }

    // O(n) time | O(n) space
    public int trap(int[] height) {
        //                        3
        // [0,1,0,2,1,0,1,3,2,1,2,1]
        // [0,0,1,1,2,2,2,2,3,3,3,3]
        int[] water = new int[height.length];
        int leftMax = 0;
        for (int i = 0; i < height.length; i++) {
            water[i] = leftMax;
            leftMax = Math.max(leftMax, height[i]);
        }
        int rightMax = height[height.length - 1];
        for (int i = height.length - 1; i >= 0; i--) {
            water[i] = Math.min(water[i], rightMax);
            rightMax = Math.max(rightMax, height[i]);
            water[i] = Math.max(water[i] - height[i], 0);
        }
        int sum = 0;
        for (int w : water) {
            sum += w;
        }
        return sum;
    }

}
