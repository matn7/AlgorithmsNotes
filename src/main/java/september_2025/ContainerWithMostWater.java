package september_2025;

public class ContainerWithMostWater {

    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        ContainerWithMostWater containerWithMostWater = new ContainerWithMostWater();
        int result = containerWithMostWater.maxArea(height);
        System.out.println(result);
    }

    // O(n) time | O(1) space
    public int maxArea(int[] height) {
        // [1,8,6,2,5,4,8,3,7]
        //  l               r
        // h = min(height[l], height[r])
        // currArea = h * (r - l + 1)
        // update max
        // l++ if height[l] < height[r] else r++
        int l = 0;
        int r = height.length - 1;
        int maxArea = 0;
        while (l < r) {
            int currHeight = Math.min(height[l], height[r]);
            int currArea = currHeight * (r - l);
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
