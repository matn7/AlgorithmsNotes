package may_2025;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {

    public static void main(String[] args) {
//        int[] candidates = {10,1,2,7,6,1,5};
//        int target = 8;

        int[] candidates = {10, 1, 2, 7, 6, 1, 5};
        int target = 8;

        CombinationSumII combinationSumII = new CombinationSumII();
        List<List<Integer>> result = combinationSumII.combinationSum2(candidates, target);
        System.out.println(result);
    }

    // O(n*2^n) time | O(n) space
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        List<Integer> oneRes = new ArrayList<>();
        backtrack(candidates, target, 0, 0, oneRes, result);
        return result;
    }

    private void backtrack(int[] candidates, int target, int idx, int sum, List<Integer> oneRes, List<List<Integer>> result) {
        if (target == sum) {
            result.add(new ArrayList<>(oneRes));
            return;
        }
        if (sum > target || idx == candidates.length) {
            return;
        }
        int num = candidates[idx];
        oneRes.add(num);
        backtrack(candidates, target, idx + 1, sum + num, oneRes, result);
        oneRes.remove(oneRes.size() - 1);
        while (idx + 1 < candidates.length && candidates[idx] == candidates[idx + 1]) {
            idx++;
        }
        backtrack(candidates, target, idx + 1, sum, oneRes, result);
    }

}
