package september_2024;

public class ContainerWithMostWater {

    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};

        ContainerWithMostWater containerWithMostWater = new ContainerWithMostWater();
        int result = containerWithMostWater.maxArea(height);
        System.out.println(result);
    }

    // O(n) time | O(1) space
    public int maxArea(int[] height) {

        // [1, 8, 6, 2, 5, 4, 8, 3, 7]
        int s = 0;
        int e = height.length - 1;
        int maxArea = 0;

        while (s < e) {
            int start = height[s];
            int end = height[e];
            int smaller = Math.min(start, end);
            int currArea = smaller * (e - s);
            maxArea = Math.max(maxArea, currArea);
            if (start < end) {
                s++;
            } else {
                e--;
            }
        }

        return maxArea;
    }

}
