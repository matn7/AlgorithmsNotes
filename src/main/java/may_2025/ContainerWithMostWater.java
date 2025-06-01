package may_2025;

public class ContainerWithMostWater {

    public static void main(String[] args) {
//        int[] height = {1,8,6,2,5,4,8,3,7};
        int[] height = {1,1};
        ContainerWithMostWater containerWithMostWater = new ContainerWithMostWater();
        int result = containerWithMostWater.maxArea(height);
        System.out.println(result);
    }

    // O(n) time | O(1) space
    public int maxArea(int[] height) {
        int l = 0;
        int r = height.length - 1;
        int maxArea = 0;
        while (l < r) {
            int left = height[l];
            int right = height[r];
            int h = Math.min(left, right);
            int currArea = h * (r - l);
            maxArea = Math.max(maxArea, currArea);
            if (left < right) {
                l++;
            } else {
                r--;
            }
        }
        return maxArea;
    }

}
