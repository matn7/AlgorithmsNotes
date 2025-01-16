package january_2025;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {

    public static void main(String[] args) {
        int[] candidates = {2, 3, 5};
        int target = 8;

        CombinationSum combinationSum = new CombinationSum();
        List<List<Integer>> result = combinationSum.combinationSum(candidates, target);
        System.out.println(result);
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> combinations = new ArrayList<>();
        List<Integer> oneRes = new ArrayList<>();
        backtrack(candidates, 0, 0, target, oneRes, combinations);
        return combinations;
    }

    private void backtrack(int[] candidates, int idx, int sum, int target, List<Integer> oneRes, List<List<Integer>> combinations) {
        if (sum == target) {
            combinations.add(new ArrayList<>(oneRes));
            return;
        }
        if (idx >= candidates.length || sum > target) {
            return;
        }
        int candidate = candidates[idx];
        oneRes.add(candidate);
        backtrack(candidates, idx, sum + candidate, target, oneRes, combinations);
        oneRes.remove(oneRes.size() - 1);
        backtrack(candidates, idx + 1, sum, target, oneRes, combinations);
    }


}
