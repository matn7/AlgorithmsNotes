package june_2025;

public class Trap {

    public static void main(String[] args) {
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};

        Trap trap = new Trap();
        int result = trap.trap(height);
        System.out.println(result);
    }

    // O(n) time | O(n) space
    public int trap(int[] height) {
        int[] water = new int[height.length];
        int maxLeft = height[0];
        for (int i = 0; i < height.length; i++) {
            water[i] = maxLeft;
            maxLeft = Math.max(maxLeft, height[i]);
        }
        int maxRight = height[height.length - 1];
        int sum = 0;
        for (int i = height.length - 1; i >= 0; i--) {
            int h = Math.min(water[i], maxRight) - height[i];
            water[i] = Math.max(h, 0);
            sum += water[i];
            maxRight = Math.max(maxRight, height[i]);
        }
        return sum;
    }

}
