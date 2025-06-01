package may_2025;

public class TrappingRainWater {

    public static void main(String[] args) {
//        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        int[] height = {4,2,0,3,2,5};

        TrappingRainWater trappingRainWater = new TrappingRainWater();
        int result = trappingRainWater.trap(height);
        System.out.println(result);
    }

    // O(n) time | O(n) space
    public int trap(int[] height) {
        int[] water = new int[height.length];
        int max = 0;
        for (int i = 0; i < height.length; i++) {
            water[i] = max;
            max = Math.max(max, height[i]);
        }
        max = 0;
        for (int i = height.length - 1; i >= 0; i--) {
            max = Math.max(height[i], max);
            water[i] = Math.max(Math.min(water[i], max) - height[i], 0);
        }
        int result = 0;
        for (int w : water) {
            result += w;
        }
        return result;
    }

}
