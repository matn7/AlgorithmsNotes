package february_2025;

public class TrappingRainWater {

    public static void main(String[] args) {
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};

        TrappingRainWater trappingRainWater = new TrappingRainWater();
        int trap = trappingRainWater.trap(height);
        System.out.println(trap);
    }

    public int trap(int[] height) {
        int maxL = height[0];
        int[] water = new int[height.length];

        for (int i = 0; i < height.length; i++) {
            water[i] = maxL;
            maxL = Math.max(maxL, height[i]);
        }
        int maxR = height[height.length - 1];
        for (int i = height.length - 1; i >= 0; i--) {
            int min = Math.min(water[i], maxR);
            int val = Math.max(min - height[i], 0);
            water[i] = val;
            maxR = Math.max(maxR, height[i]);
        }
        int sum = 0;
        for (int num : water) {
            sum += num;
        }
        return sum;
    }

}
