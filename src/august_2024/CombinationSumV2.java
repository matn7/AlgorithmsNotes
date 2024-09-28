package august_2024;

import java.util.ArrayList;
import java.util.List;

public class CombinationSumV2 {

    public static void main(String[] args) {
        int[] nums = {2, 3, 6};
        int target = 8;

        List<List<Integer>> result = combinationSum(nums, target);
        System.out.println(result);
    }

    public static List<List<Integer>> combinationSum(int[] nums, int target) {

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        return solution(nums, result, current, target, 0, 0);
    }

    private static List<List<Integer>> solution(int[] nums, List<List<Integer>> result, List<Integer> current,
                                                int target, int idx, int sum) {
        if (sum == target) {
            result.add(new ArrayList<>(current));
        } else if (sum < target) {
            int n = nums.length;
            for (int i = idx; i < n; i++) {
                current.add(nums[i]);
                solution(nums, result, current, target, i, sum + nums[i]);
                current.remove(current.size() - 1);
            }
        }
        return result;
    }

}
