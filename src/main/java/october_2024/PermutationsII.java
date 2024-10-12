package october_2024;

import java.util.*;

public class PermutationsII {

    public static void main(String[] args) {
        PermutationsII permutationsII = new PermutationsII();
        int[] nums = {1, 1, 2};
        List<List<Integer>> result = permutationsII.permuteUnique(nums);
        System.out.println(result);
    }

    // leetcode 47

    // O(n*n!) time | O(n*n!) space
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> perm = new ArrayList<>();
        Map<Integer, Integer> count = new HashMap<>();
        for (int n : nums) {
            count.put(n, count.getOrDefault(n, 0) + 1);
        }
        dfs(nums, perm, res, count);
        return res;
    }

    private void dfs(int[] nums, List<Integer> perm, List<List<Integer>> res, Map<Integer, Integer> count) {
        if (perm.size() == nums.length) {
            res.add(new ArrayList<>(perm));
            return;
        }

        for (Map.Entry<Integer, Integer> element : count.entrySet()) {
            int n = element.getKey();
            if (count.get(n) > 0) {
                perm.add(n);
                count.put(n, count.get(n) - 1);
                dfs(nums, perm, res, count);
                count.put(n, count.get(n) + 1);
                perm.remove(perm.size() - 1);
            }
        }
    }

    // O(n*n!) time | O(n*n!) space
    public List<List<Integer>> permuteUnique2(int[] nums) {
        Set<List<Integer>> permutations = new HashSet<>();
        List<Integer> numsArr = new ArrayList<>();
        for (int n : nums) {
            numsArr.add(n);
        }
        helper(numsArr, new ArrayList<>(), permutations);
        return permutations.stream().toList();
    }

    private void helper(List<Integer> nums, List<Integer> curr, Set<List<Integer>> permutations) {
        if (nums.isEmpty()) {
            permutations.add(curr);
        } else {
            for (int i = 0; i < nums.size(); i++) {
                List<Integer> newNums = new ArrayList<>(nums);
                List<Integer> newCurr = new ArrayList<>(curr);
                Integer removed = newNums.remove(i);
                newCurr.add(removed);
                helper(newNums, newCurr, permutations);
            }
        }
    }

}
