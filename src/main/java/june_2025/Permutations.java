package june_2025;

import java.util.ArrayList;
import java.util.List;

public class Permutations {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        Permutations permutations = new Permutations();
        List<List<Integer>> result = permutations.permute(nums);
        System.out.println(result);
    }

    // O(n * n!) time | O(n * n!) space
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> oneRes = new ArrayList<>();
        boolean[] pick = new boolean[nums.length];
        backtrack(nums, oneRes, result, pick);

        return result;
    }

    private void backtrack(int[] nums, List<Integer> oneRes, List<List<Integer>> result, boolean[] pick) {
        if (oneRes.size() == nums.length) {
            result.add(new ArrayList<>(oneRes));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!pick[i]) {
                oneRes.add(nums[i]);
                pick[i] = true;
                backtrack(nums, oneRes, result, pick);
                oneRes.remove(oneRes.size() - 1);
                pick[i] = false;
            }
        }
    }


}
