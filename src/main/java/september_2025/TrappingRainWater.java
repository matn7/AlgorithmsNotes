package september_2025;

public class TrappingRainWater {

    public static void main(String[] args) {
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        TrappingRainWater trappingRainWater = new TrappingRainWater();

        int result = trappingRainWater.trap(height);
        System.out.println(result);
    }

    // O(n) time | O(1) space
    public int trap(int[] height) {
        if (height.length == 0) {
            return 0;
        }
        int l = 0;
        int r = height.length - 1;

        int maxLeft = height[l];
        int maxRight = height[r];
        int water = 0;

        while (l < r) {
            if (maxLeft < maxRight) {
                water = (maxLeft - height[l]) < 0 ? water : water + (maxLeft - height[l]);
                l++;
            } else {
                water = (maxRight - height[r]) < 0 ? water : water + (maxRight - height[r]);
                r--;
            }
            maxLeft = Math.max(maxLeft, height[l]);
            maxRight = Math.max(maxRight, height[r]);
        }
        return water;
    }

    // O(n) time | O(n) space
    public int trap2(int[] height) {
        int[] water = new int[height.length];
        // maxLeft = 3
        // [0,1,0,2,1,0,1,3,2,1,2,1]

        //                  *
        // [0,0,1,1,2,2,2,2,3,3,3,3]

        int maxLeft = 0;
        for (int i = 0; i < height.length; i++) {
            water[i] = maxLeft;
            maxLeft = Math.max(maxLeft, height[i]);
        }

        // [0,1,0,2,1,0,1,3,2,1,2,1]
        // maxRight = 3
        //    *
        // [0,0,1,0,1,2,1,0,0,1,0,0]
        int maxRight = height[height.length - 1];
        int sum = 0;
        for (int i = height.length - 1; i >= 0; i--) {
            water[i] = Math.min(maxRight, water[i]); // (3, 0) = 1
            water[i] -= height[i]; // 1 - 1
            if (water[i] < 0) {
                water[i] = 0;
            }
            maxRight = Math.max(maxRight, height[i]);
            sum += water[i];
        }

        return sum;
    }

}
