package december_2025;

import java.util.ArrayList;
import java.util.List;

public class FindAllSubsets {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        FindAllSubsets findAllSubsets = new FindAllSubsets();
        List<List<Integer>> result = findAllSubsets.subsets(nums);
        System.out.println(result);
    }

    // O(n * 2^n) time | O(n) space
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> part = new ArrayList<>();
        dfs(nums, 0, part, result);
        return result;
    }

    private void dfs(int[] nums, int i, List<Integer> part, List<List<Integer>> result) {
        if (i == nums.length) {
            result.add(new ArrayList<>(part));
            return;
        }

        // include
        part.add(nums[i]);
        dfs(nums, i + 1, part, result);

        // not include
        part.remove(part.size() - 1);
        dfs(nums, i + 1, part, result);
    }

}
