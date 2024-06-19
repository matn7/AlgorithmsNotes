package april_2024;

public class ContainerWithMostWater {

    public static void main(String[] args) {
//        int[] nums = {7, 1, 2, 3, 9};
//        int[] nums = {};
//        int[] nums = {7};
//        int[] nums = {1, 7, 2, 8, 1, 6};
        int[] nums = {6, 9, 3, 4, 5, 8};

        int result = maxContainer(nums);
        System.out.println(result);
    }

    // O(n) time | O(1) space
    public static int maxContainer(int[] nums) {
        if (nums.length <= 1) {
            return 0;
        }
        int maxArea = 0;
        int p1 = 0;
        int p2 = nums.length - 1;

        while (p1 < p2) {
            int num1 = nums[p1];
            int num2 = nums[p2];
            int currArea = Math.min(num1, num2) * (p2 - p1);
            maxArea = Math.max(maxArea, currArea);
            if (num1 < num2) {
                p1++;
            } else {
                p2--;
            }
        }

        return maxArea;
    }

}
