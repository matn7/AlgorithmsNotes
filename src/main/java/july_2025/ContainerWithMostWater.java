package july_2025;

public class ContainerWithMostWater {

    public static void main(String[] args) {
//        int[] height = {1,8,6,2,5,4,8,3,7};
        int[] height = {};

        ContainerWithMostWater containerWithMostWater = new ContainerWithMostWater();
        int result = containerWithMostWater.maxArea(height);
        System.out.println(result);
    }

    // O(n) time | O(1) space
    public int maxArea(int[] height) {
        // brute force nested-loops
        // two pointers, keep shrinking smaller height
        // complexity: O(n) time | O(1) space
        int l = 0;
        int r = height.length - 1;
        int maxArea = 0;
        while (l < r) {
            // area = w * h
            int w = r - l;
            int h = Math.min(height[l], height[r]);
            int area = w * h;
            maxArea = Math.max(maxArea, area);
            if (height[l] < height[r]) {
                l++;
            } else {
                r--;
            }
        }
        return maxArea;
    }

}
