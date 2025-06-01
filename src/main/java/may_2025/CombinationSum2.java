package may_2025;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum2 {

    public static void main(String[] args) {
        int[] candidates = {2,3,6,7};
        int target = 7;

        CombinationSum2 combinationSum2 = new CombinationSum2();
        List<List<Integer>> result = combinationSum2.combinationSum(candidates, target);
        System.out.println(result);
    }

    // O(n*2^n) time | O(n) space
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> sub = new ArrayList<>();
        baccktrack(candidates, 0, 0, target, sub, res);
        return res;
    }

    private void baccktrack(int[] candidates, int i, int sum, int target, List<Integer> sub, List<List<Integer>> res) {
        if (i >= candidates.length || sum > target) {
            return;
        }
        if (sum == target) {
            res.add(new ArrayList<>(sub));
            return;
        }
        sub.add(candidates[i]);
        baccktrack(candidates, i, sum + candidates[i], target, sub, res);
        sub.remove(sub.size() - 1);
        baccktrack(candidates, i + 1, sum, target, sub, res);
    }


}
