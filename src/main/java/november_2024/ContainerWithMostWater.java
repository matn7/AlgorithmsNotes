package november_2024;

public class ContainerWithMostWater {

    public static void main(String[] args) {
        int[] height = {1, 7, 2, 5, 4, 7, 3, 6};

        ContainerWithMostWater container = new ContainerWithMostWater();
        int result = container.maxArea(height);
        System.out.println(result);
    }

    public int maxArea(int[] height) {
        int l = 0;
        int r = height.length - 1;
        int max = 0;
        while (l < r) {
            int lHeight = height[l];
            int rHeight = height[r];
            int h = Math.min(lHeight, rHeight);
            int w = r - l;
            max = Math.max(max, w * h);
            if (lHeight < rHeight) {
                l++;
            } else {
                r--;
            }
        }
        return max;
    }

}
