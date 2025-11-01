package october_2025;

import java.util.*;

public class CombinationSumII {

    public static void main(String[] args) {
        int[] candidates = {10,1,2,7,6,1,5};
        int target = 8;
//        int[] candidates = {2,5,2,1,2};
//        int target = 5;

        CombinationSumII combinationSumII = new CombinationSumII();
        List<List<Integer>> result = combinationSumII.combinationSum2(candidates, target);
        System.out.println(result);
    }

    // O(n * 2^n) time | O(n * 2^n) space
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> oneRes = new ArrayList<>();
        dfs(candidates, 0, 0, target, oneRes, result);
        return result;
    }

    private void dfs(int[] candidates, int i, int sum, int target, List<Integer> oneRes, List<List<Integer>> result) {
        if (sum == target) {
            result.add(new ArrayList<>(oneRes));
            return;
        }
        if (i >= candidates.length || sum > target) {
            return;
        }
        oneRes.add(candidates[i]); // include
        dfs(candidates, i + 1, sum + candidates[i], target, oneRes, result); // not allow reusing the same element
        oneRes.remove(oneRes.size() - 1); // not include
        // do not use the same element again in second branch
        while (i + 1 < candidates.length && candidates[i] == candidates[i + 1]) {
            i++;
        }
        dfs(candidates, i + 1, sum, target, oneRes, result); // skip element
    }

}
