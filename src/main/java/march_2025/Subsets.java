package march_2025;

import java.util.ArrayList;
import java.util.List;

public class Subsets {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};

        Subsets subsets = new Subsets();
        List<List<Integer>> result = subsets.subsets(nums);
        System.out.println(result);
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        List<Integer> subset = new ArrayList<>();

        helper(nums, 0, subset, result);

        return result;
    }

    private void helper(int[] nums, int i, List<Integer> subset, List<List<Integer>> result) {
        if (i == nums.length) {
            result.add(new ArrayList<>(subset));
            return;
        }
        subset.add(nums[i]);
        helper(nums, i + 1, subset, result);
        subset.remove(subset.size() - 1);
        helper(nums, i + 1, subset, result);
    }


    public List<List<Integer>> subsets2(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());

        for (int num : nums) {
            int size = result.size();
            for (int i = 0; i < size; i++) {
                List<Integer> newElem = new ArrayList<>(result.get(i));
                newElem.add(num);
                result.add(newElem);
            }
        }
        return result;
    }

}
