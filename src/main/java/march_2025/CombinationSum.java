package march_2025;

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

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> subSum = new ArrayList<>();
        backtrack(candidates, target, 0, 0, subSum, result);
        return result;
    }

    private void backtrack(int[] candidates, int target, int i, int sum, List<Integer> subSum, List<List<Integer>> result) {
        if (sum == target) {
            result.add(new ArrayList<>(subSum));
            return;
        }
        if (sum > target || i >= candidates.length) {
            return;
        }
        subSum.add(candidates[i]);
        backtrack(candidates, target, i, sum + candidates[i], subSum, result);
        subSum.remove(subSum.size() - 1);
        backtrack(candidates, target, i + 1, sum ,subSum, result);
    }

}
