package october_2024;

import java.util.*;

public class CombinationSum3 {

    public static void main(String[] args) {
        int[] candidates = {2, 3, 6, 7};
        int target = 7;
//
//        int[] candidates = {10, 1, 2, 7, 6, 1, 5};
//        int target = 8;

        CombinationSum3 combinationSum = new CombinationSum3();
        List<List<Integer>> result = combinationSum.combinationSum(candidates, target);
        System.out.println(result);
    }

    // leetcode 39

    // O(2^t) time | O(t) space
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(0, new ArrayList<>(), 0, target, candidates, res);
        return res;
    }

    private void dfs(int i, List<Integer> cur, int total, int target, int[] candidates, List<List<Integer>> res) {
        if (total == target) {
            res.add(new ArrayList<>(cur));
            return;
        }
        if (i >= candidates.length || total > target) {
            return;
        }

        cur.add(candidates[i]);
        dfs(i, cur, total + candidates[i], target, candidates, res);
        cur.remove(cur.size() - 1);
        dfs(i + 1, cur, total, target, candidates, res);
    }

}
