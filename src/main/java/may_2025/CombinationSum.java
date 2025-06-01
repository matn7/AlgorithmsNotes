package may_2025;

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

    // O(n*2^n) time | O(n) space
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> oneRes = new ArrayList<>();
        backtrack(candidates, target, 0, 0, oneRes, result);
        return result;
    }

    private void backtrack(int[] candidates, int target, int idx, int sum, List<Integer> oneRes, List<List<Integer>> result) {
        if (sum == target) {
            result.add(new ArrayList<>(oneRes));
            return;
        }
        if (sum > target || idx >= candidates.length) {
            return;
        }
        int num = candidates[idx];
        oneRes.add(num);
        backtrack(candidates, target, idx, sum + num, oneRes, result);
        oneRes.remove(oneRes.size() - 1);
        backtrack(candidates, target, idx + 1, sum, oneRes, result);
    }

}
