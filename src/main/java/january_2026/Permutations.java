package january_2026;

import java.util.ArrayList;
import java.util.List;

public class Permutations {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};

        Permutations permutations = new Permutations();
        List<List<Integer>> result = permutations.permute(nums);
        System.out.println(result);
    }

    // O(n * 2^n) time | O(n * 2^n) space
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> part = new ArrayList<>();

        boolean[] visited = new boolean[nums.length];

        backtrack(nums, visited, part, result);

        return result;
    }

    private void backtrack(int[] nums, boolean[] visited, List<Integer> part, List<List<Integer>> result) {
        if (part.size() == nums.length) {
            result.add(new ArrayList<>(part));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                part.add(nums[i]);
                backtrack(nums, visited, part, result);
                visited[i] = false;
                part.remove(part.size() - 1);
            }
        }
    }

}
