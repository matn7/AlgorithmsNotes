package august_2024;

import java.util.ArrayList;
import java.util.List;

public class CombinationSumV5 {

    public static void main(String[] args) {
        int[] arr = {2, 3, 6};
        int target = 8;

        List<List<Integer>> result = combinationSum(arr, target);
        System.out.println(result);
    }

    // O(2^n) time | O(2^n) space
    public static List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        helper(nums, target, 0, new ArrayList<>(), result);
        return result;
    }

    private static void helper(int[] nums, int target, int start, List<Integer> current,
                               List<List<Integer>> result) {
        if (target == 0){
            result.add(new ArrayList<>(current));
            return;
        }
        if (target < 0) {
            return;
        }
        for (int i = start; i < nums.length; i++) {
            current.add(nums[i]);
            helper(nums, target - nums[i], i, current, result);
            current.remove(current.size() - 1);
        }
    }
}
