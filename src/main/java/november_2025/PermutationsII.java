package november_2025;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationsII {

    public static void main(String[] args) {
        int[] nums = {1, 1, 2};
        PermutationsII permutationsII = new PermutationsII();
        List<List<Integer>> result = permutationsII.permuteUnique(nums);
        System.out.println(result);
    }

    // O(n * n!) time | O(n) space
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length == 0) {
            return result;
        }
        Arrays.sort(nums);
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

                while (i + 1 < nums.length && nums[i] == nums[i + 1]) {
                    i++;
                }
            }
        }
    }

}
