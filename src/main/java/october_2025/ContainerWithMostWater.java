package october_2025;

public class ContainerWithMostWater {

    public static void main(String[] args) {
        // int[] height = {1,8,6,2,5,4,8,3,7};
        int[] height = {1,1};
        ContainerWithMostWater containerWithMostWater = new ContainerWithMostWater();
        int result = containerWithMostWater.maxArea(height);
        System.out.println(result);

    }

    // O(n) time | O(1) space
    public int maxArea(int[] height) {
        int maxArea = 0;
        int l = 0;
        int r = height.length - 1;

        while (l < r) {
            int dist = r - l;
            int currArea = Math.min(height[l], height[r]) * dist;
            maxArea = Math.max(maxArea, currArea);
            if (height[l] < height[r]) {
                l++;
            } else {
                r--;
            }
        }

        return maxArea;
    }

}
