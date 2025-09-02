package august_2025;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {

    public static void main(String[] args) {
//        int[] candidates = {2, 3, 6, 7};
//        int target = 7;

        int[] candidates = {10,1,2,7,6,1,5};
        int target = 8;

        CombinationSumII combinationSumII = new CombinationSumII();
        List<List<Integer>> result = combinationSumII.combinationSum2(candidates, target);
        System.out.println(result);
    }

    // O(n * 2^n) time | O(n) space
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> part = new ArrayList<>();

        backtrack(candidates, 0, 0, target, part, result);

        return result;
    }

    private void backtrack(int[] candidates, int idx, int sum, int target, List<Integer> part, List<List<Integer>> result) {
        if (sum == target) {
            result.add(new ArrayList<>(part));
            return;
        }
        if (sum > target || idx >= candidates.length) {
            return;
        }
        part.add(candidates[idx]);
        backtrack(candidates, idx + 1, sum + candidates[idx], target, part, result);
        part.remove(part.size() - 1);
        while (idx + 1 < candidates.length && candidates[idx] == candidates[idx + 1]) {
            idx++;
        }
        backtrack(candidates, idx + 1, sum, target, part, result);
    }

}
