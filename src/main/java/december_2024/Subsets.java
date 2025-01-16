package december_2024;

import java.util.ArrayList;
import java.util.List;

public class Subsets {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        Subsets subsets = new Subsets();
        List<List<Integer>> result = subsets.subsets(nums);
        System.out.println(result);
    }

    public List<List<Integer>> subsets2(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());

        for (int num : nums) {
            int size = result.size();
            for (int i = 0; i < size; i++) {
                List<Integer> oneElem = new ArrayList<>(result.get(i));
                oneElem.add(num);
                result.add(oneElem);
            }
        }

        return result;
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        backtrack(0, nums, subset, result);
        return result;
    }

    private void backtrack(int i, int[] nums, List<Integer> subset, List<List<Integer>> subsets) {
        if (i == nums.length) {
            subsets.add(new ArrayList<>(subset));
            return;
        }

        subset.add(nums[i]);
        backtrack(i + 1, nums, subset, subsets);
        subset.remove(subset.size() - 1);

        backtrack(i + 1, nums, subset, subsets);
    }

}
