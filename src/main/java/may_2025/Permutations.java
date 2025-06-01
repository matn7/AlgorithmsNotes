package may_2025;

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
        List<Integer> perm = new ArrayList<>();
        boolean[] pick = new boolean[nums.length];
        backtrack(nums, pick, perm, result);
        return result;
    }

    private void backtrack(int[] nums, boolean[] pick, List<Integer> perm, List<List<Integer>> result) {
        if (perm.size() == nums.length) {
            result.add(new ArrayList<>(perm));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!pick[i]) {
                pick[i] = true;
                perm.add(nums[i]);
                backtrack(nums, pick, perm, result);
                perm.remove(perm.size() - 1);
                pick[i] = false;
            }
        }
    }

}













