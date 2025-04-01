package february_2025;

public class ContainerWithMostWater {

    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        ContainerWithMostWater containerWithMostWater = new ContainerWithMostWater();
        int result = containerWithMostWater.maxArea(height);
        System.out.println(result);
    }

    public int maxArea(int[] height) {
        int L = 0;
        int R = height.length - 1;
        int maxArea = 0;
        int minPillar;
        while (L < R) {
            minPillar = Math.min(height[L], height[R]);
            maxArea = Math.max(maxArea, (R - L) * minPillar);
            if (height[L] < height[R]) {
                L++;
            } else {
                R--;
            }
        }

        return maxArea;
    }

}
