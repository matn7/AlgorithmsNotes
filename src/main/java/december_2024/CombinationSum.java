package december_2024;

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
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();

        dfs(0, candidates, cur, 0, target, result);
        return result;
    }

    private void dfs(int i, int[] candidates, List<Integer> cur, int total, int target, List<List<Integer>> result) {
        if (total == target) {
            result.add(new ArrayList<>(cur));
            return;
        }
        if (i >= candidates.length || total > target) {
            return;
        }
        cur.add(candidates[i]);
        dfs(i, candidates, cur, total + candidates[i], target, result);
        cur.remove(cur.size() - 1);
        dfs(i + 1, candidates, cur, total, target, result);
    }
}
