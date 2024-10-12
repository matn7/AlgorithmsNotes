package april_2024;

public class TrappingRainWater {

    public static void main(String[] args) {
        int[] pillars = {0, 1, 0, 2, 1, 0, 3, 1, 0, 1, 2};

        int result = trapWater(pillars);
        System.out.println(result);

        int result2 = trapWater2(pillars);
        System.out.println(result2);
    }

    // O(n) time | O(n) space
    public static int trapWater(int[] pillars) {
        if (pillars.length < 2) {
            return 0;
        }
        int[] left = new int[pillars.length];
        int[] ans = new int[pillars.length];

        int leftMax = pillars[0];
        for (int i = 0; i < pillars.length; i++) {
            leftMax = Math.max(leftMax, pillars[i]);
            left[i] = leftMax;
        }

        int rightMax = pillars[pillars.length - 1];
        for (int i = pillars.length - 1; i >= 0; i--) {
            rightMax = Math.max(rightMax, pillars[i]);
            ans[i] = Math.min(left[i], rightMax) - pillars[i];
        }

        int sum = 0;
        for (int num : ans) {
            sum += num;
        }
        return sum;
    }

    // O(n) time | O(1) space
    public static int trapWater2(int[] pillars) {
        int left = 0;
        int right = pillars.length - 1;
        int leftMax = pillars[0];
        int rightMax = pillars[pillars.length - 1];
        int total = 0;

        while (left < right) {
            if (pillars[left] <= pillars[right]) {
                leftMax = Math.max(leftMax, pillars[left]);
                int currWater = Math.min(leftMax, rightMax) - pillars[left];
                total += currWater;
                left++;
            } else {
                rightMax = Math.max(rightMax, pillars[right]);
                int currWater = Math.min(leftMax, rightMax) - pillars[right];
                total += currWater;
                right--;
            }
        }

        return total;
    }

}
