package june_2025;

public class MaxArea {

    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};

        MaxArea maxArea = new MaxArea();
        int result = maxArea.maxArea(height);
        System.out.println(result);
    }

    // O(n) time | O(1) space
    public int maxArea(int[] height) {
        int l = 0;
        int r = height.length - 1;
        int max = 0;
        while (l < r) {
            int currArea = Math.min(height[l], height[r]) * (r - l);
            max = Math.max(max, currArea);
            if (height[r] > height[l]) {
                l++;
            } else {
                r--;
            }
        }
        return max;
    }

}
