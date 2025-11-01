package october_2025;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum2 {

    public static void main(String[] args) {
        int[] candidates = {2,3,5};
        int target = 8;

        CombinationSum2 combinationSum2 = new CombinationSum2();
        List<List<Integer>> result = combinationSum2.combinationSum(candidates, target);
        System.out.println(result);
    }

    // O(n * 2^n) time | O(n) space
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();

        backtrack(candidates, 0, target, curr, result);

        return result;
    }

    private void backtrack(int[] candidates, int i, int target, List<Integer> curr, List<List<Integer>> result) {
        if (target < 0 || i == candidates.length) {
            return;
        }
        if (target == 0) {
            result.add(new ArrayList<>(curr));
            return;
        }
        curr.add(candidates[i]);
        backtrack(candidates, i, target - candidates[i], curr, result);
        curr.remove(curr.size() - 1);
        backtrack(candidates, i + 1, target, curr, result);
    }

}
