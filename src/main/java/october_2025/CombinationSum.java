package october_2025;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {

    public static void main(String[] args) {
//        int[] candidates = {2,3,6,7};
//        int target = 7;

        int[] candidates = {2,3,5};
        int target = 8;

        CombinationSum combinationSum = new CombinationSum();
        List<List<Integer>> result = combinationSum.combinationSum(candidates, target);
        System.out.println(result);
    }

    // O(n * 2^n) time | O(n * 2^n) space
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
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
        dfs(candidates, i, sum + candidates[i], target, oneRes, result); // include multiple time
        oneRes.remove(oneRes.size() - 1); // not include
        dfs(candidates, i + 1, sum, target, oneRes, result); // go to next element, do not add to sum
    }


}
