package december_2025;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        Permutations permutations = new Permutations();
        List<List<Integer>> result = permutations.permute(nums);
        System.out.println(result);
    }

    // O(n * n!) time | O(n) space
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> part = new ArrayList<>();
        boolean[] seen = new boolean[nums.length];
        dfs(nums, seen, part, result);
        return result;
    }

    private void dfs(int[] nums, boolean[] seen, List<Integer> part, List<List<Integer>> result) {
        if (part.size() == nums.length) {
            result.add(new ArrayList<>(part));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!seen[i]) {
                seen[i] = true;
                part.add(nums[i]);
                dfs(nums, seen, part, result);
                part.remove(part.size() - 1);
                seen[i] = false;
            }
        }
    }
}
