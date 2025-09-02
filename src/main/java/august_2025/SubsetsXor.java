package august_2025;

import java.util.ArrayList;
import java.util.List;

public class SubsetsXor {

    public static void main(String[] args) {
        int[] nums = {1, 3};

        SubsetsXor subsetsXor = new SubsetsXor();
        int result = subsetsXor.subsetXORSum(nums);
        System.out.println(result);
    }

    // O(n * 2^n) time | O(n) space
    public int subsetXORSum(int[] nums) {
        return dfs(nums, 0, 0);
    }

    private int dfs(int[] nums, int i, int total) {
        if (i == nums.length) {
            return total;
        }
        // include nums[i]
        return dfs(nums, i + 1, total ^ nums[i]) + dfs(nums, i + 1, total);
    }

    // O(n * 2^n) time | O(n) space
    public int subsetXORSum1(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        List<Integer> part = new ArrayList<>();

        backtrack(nums, 0, part, subsets);

        int sum = 0;
        for (List<Integer> sub : subsets) {
            int cur = 0;
            for (int num : sub) {
                cur ^= num;
            }
            sum += cur;
        }

        return sum;
    }

    private void backtrack(int[] nums, int i, List<Integer> part, List<List<Integer>> result) {
        if (i == nums.length) {
            result.add(new ArrayList<>(part));
            return;
        }
        part.add(nums[i]);
        backtrack(nums, i + 1, part, result);
        part.remove(part.size() - 1);
        backtrack(nums, i + 1, part, result);
    }





    public int subsetXORSum2(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        subsets.add(new ArrayList<>());

        for (int i = 0; i < nums.length; i++) {
            int size = subsets.size();
            for (int j = 0; j < size; j++) {
                List<Integer> curr = new ArrayList<>(subsets.get(j));
                curr.add(nums[i]);
                subsets.add(curr);
            }
        }
        int sum = 0;
        for (List<Integer> sub : subsets) {
            int cur = 0;
            for (int num : sub) {
                cur ^= num;
            }
            sum += cur;
        }

        return sum;
    }


}
