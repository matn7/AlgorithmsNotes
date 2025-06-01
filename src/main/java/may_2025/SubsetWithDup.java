package may_2025;

import java.util.ArrayList;
import java.util.List;

public class SubsetWithDup {

    public static void main(String[] args) {
        int[] nums = {1, 2, 2};
        SubsetWithDup subsetWithDup = new SubsetWithDup();
        List<List<Integer>> result = subsetWithDup.subsetsWithDup(nums);
        System.out.println(result);
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> sub = new ArrayList<>();

        backtrack(nums, 0, sub, result);

        return result;
    }

    private void backtrack(int[] nums, int i, List<Integer> sub, List<List<Integer>> result) {
        if (i == nums.length) {
            result.add(new ArrayList<>(sub));
            return;
        }
        sub.add(nums[i]);
        backtrack(nums, i + 1, sub, result);
        sub.remove(sub.size() - 1);
        while (i + 1 < nums.length && nums[i + 1] == nums[i]) {
            i++;
        }
        backtrack(nums, i + 1, sub, result);
    }

}
