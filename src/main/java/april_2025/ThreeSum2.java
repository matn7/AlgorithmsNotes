package april_2025;

import java.util.*;

public class ThreeSum2 {

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};

        ThreeSum2 threeSum2 = new ThreeSum2();
        List<List<Integer>> result = threeSum2.threeSum(nums);
        System.out.println(result);
    }

    // O(n^2) time | O(n) space
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> result = new HashSet<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int a = nums[i];
            int L = i + 1;
            int R = nums.length - 1;
            while (L < R) {
                int b = nums[L];
                int c = nums[R];
                int sum = a + b + c;
                if (sum == 0) {
                    result.add(Arrays.asList(a, b, c));
                    L++;
                    R--;
                } else if (sum > 0) {
                    R--;
                } else {
                    L++;
                }

            }
        }
        return new ArrayList<>(result);
    }

}
