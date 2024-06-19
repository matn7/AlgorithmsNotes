package april_2024;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {

    public static void main(String[] args) {
//        int[] candidates = {2, 3, 6, 7};
//        int target = 7;

        int[] candidates = {2, 3, 6};
        int target = 8;

        List<List<Integer>> result = combinationSum2(candidates, target);
        System.out.println(result);
    }

    // O(2^n) time | O(2^n) space
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        return solution(candidates, ans, curr, target, 0, 0);
    }

    private static List<List<Integer>> solution(int[] candidates, List<List<Integer>> ans, List<Integer> curr,
                                                int target, int index, int sum) {
        if (sum == target) {
            ans.add(new ArrayList<>(curr));
        } else if (sum < target) {
            int n = candidates.length;
            for (int i = index; i < n; i++) {
                curr.add(candidates[i]);
                solution(candidates, ans, curr, target, i, sum + candidates[i]);
                curr.remove(curr.size() - 1);
            }
        }
        return ans;
    }


    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        combinationSumHelper(candidates, target, 0, new ArrayList<>(), result);
        return result;
    }

    private static void combinationSumHelper(int[] candidates, int target, int sum, List<Integer> curr, List<List<Integer>> result) {
        if (sum > target) {
            return;
        }
        if (sum == target) {
            result.add(curr);
        } else {
            List<Integer> newCurr = new ArrayList<>(curr);

            for (int candidate : candidates) {
                newCurr.add(candidate);
                combinationSumHelper(candidates, target, sum + candidate, newCurr, result);
                newCurr.remove(newCurr.size() - 1);
            }
        }
    }

}
