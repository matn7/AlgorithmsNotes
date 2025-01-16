package november_2024;

public class TrappingRainWater {

    public static void main(String[] args) {
        int[] height = {0, 2, 0, 3, 1, 0, 1, 3, 2, 1};

        TrappingRainWater trappingRainWater = new TrappingRainWater();
        int trap = trappingRainWater.trap(height);
        System.out.println(trap);
    }

    public int trap(int[] height) {
        int[] water = new int[height.length];
        int left = height[0];

        for (int i = 0; i < height.length; i++) {
            water[i] = left;
            left = Math.max(left, height[i]);
        }
        int res = 0;
        int right = height[height.length - 1];
        int area = 0;
        for (int i = height.length - 1; i >= 0; i--) {
            area = Math.min(water[i], right) - height[i];
            if (area < 0) {
                area = 0;
            }
            right = Math.max(right, height[i]);
            res += area;
        }

        return res;
    }

    public int trap2(int[] height) {
        int[] water = new int[height.length];
        int left = height[0];

        for (int i = 0; i < height.length; i++) {
            water[i] = left;
            left = Math.max(left, height[i]);
        }
        int right = height[height.length - 1];
        for (int i = height.length - 1; i >= 0; i--) {
            water[i] = Math.min(water[i], right);
            right = Math.max(right, height[i]);
        }

        for (int i = 0; i < height.length; i++) {
            int w = water[i];
            int h = height[i];
            int area = w - h;
            if (area < 0) {
                area = 0;
            }
            water[i] = area;
        }

        return 0;
    }

}
