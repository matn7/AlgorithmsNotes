package april_2025;

import java.util.*;

public class ThreeSum {

    public static void main(String[] args) {
//        int[] nums = {-3, 3, 4, -3, 1, 2};
        int[] nums = {-1,0,1,2,-1,-4};
        ThreeSum threeSum = new ThreeSum();
        List<List<Integer>> result = threeSum.threeSum(nums);
        System.out.println(result);
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
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
                } else if (sum < 0) {
                    L++;
                } else {
                    R--;
                }
            }
        }

        return new ArrayList<>(result);
    }

}
