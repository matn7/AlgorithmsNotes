package april_2025;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {

    public static void main(String[] args) {
        int[] candidates = {2, 3, 6, 7};
        int target = 7;

        CombinationSum combinationSum = new CombinationSum();
        List<List<Integer>> result = combinationSum.combinationSum(candidates, target);
        System.out.println(result);
    }

    // O(2^(t/m)) time | O(2^(t/m)) space -> t - target, m - min value in nums
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> sub = new ArrayList<>();

        backtracking(candidates, target, 0,0, sub, result);

        return result;
    }

    private void backtracking(int[] candidates, int target, int idx, int sum, List<Integer> sub, List<List<Integer>> result) {
        if (sum == target) {
            result.add(new ArrayList<>(sub));
            return;
        }
        if (sum > target || idx >= candidates.length) {
            return;
        }
        sub.add(candidates[idx]);
        backtracking(candidates, target, idx, sum + candidates[idx], sub, result);
        sub.remove(sub.size() - 1);
        backtracking(candidates, target, idx + 1, sum, sub, result);
    }

}
