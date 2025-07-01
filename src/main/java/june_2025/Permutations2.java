package june_2025;

import java.util.ArrayList;
import java.util.List;

public class Permutations2 {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        Permutations2 permutations2 = new Permutations2();
        List<List<Integer>> result = permutations2.permute(nums);
        System.out.println(result);
    }

    // O(n * n!) time | O(n * n!) space
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> part = new ArrayList<>();
        boolean[] pick = new boolean[nums.length];
        dfs(nums, 0, pick, part, result);
        return result;
    }

    private void dfs(int[] nums, int idx, boolean[] pick, List<Integer> part, List<List<Integer>> result) {
        if (idx == nums.length) {
            result.add(new ArrayList<>(part));
            return;
        }
        if (idx > nums.length) {
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!pick[i]) {
                pick[i] = true;
                part.add(nums[i]);

                dfs(nums, idx + 1, pick, part, result);

                pick[i] = false;
                part.remove(part.size() - 1);
            }
        }
    }

}
