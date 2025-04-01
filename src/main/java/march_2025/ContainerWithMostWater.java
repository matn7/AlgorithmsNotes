package march_2025;

public class ContainerWithMostWater {

    public static void main(String[] args) {
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};

        ContainerWithMostWater containerWithMostWater = new ContainerWithMostWater();
        int result = containerWithMostWater.maxArea(height);
        System.out.println(result);
    }

    public int maxArea(int[] height) {
        int L = 0;
        int R = height.length - 1;
        int maxArea = 0;
        while (L < R) {
            int lh = height[L];
            int rh = height[R];
            int currArea = Math.min(lh, rh) * (R - L);
            maxArea = Math.max(maxArea, currArea);
            if (lh < rh) {
                L++;
            } else {
                R--;
            }
        }
        return maxArea;
    }

}
