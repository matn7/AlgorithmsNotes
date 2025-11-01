package october_2025;

import java.util.ArrayList;
import java.util.List;

public class Subsets2 {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};

        Subsets2 subsets2 = new Subsets2();
        List<List<Integer>> result = subsets2.subsets(nums);
        System.out.println(result);
    }

    // O(n * 2^n) time | O(n * 2^n) space
    public List<List<Integer>> subsets2(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());

        for (int num : nums) {
            int size = result.size();
            for (int i = 0; i < size; i++) {
                List<Integer> current = new ArrayList<>(result.get(i));
                current.add(num);
                result.add(current);
            }
        }
        return result;
    }

    // O(n * 2^n) time | O(n) space
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> oneRes = new ArrayList<>();

        backtrack(nums, 0, oneRes, result);

        return result;
    }

    private void backtrack(int[] nums, int i, List<Integer> oneRes, List<List<Integer>> result) {
        if (i == nums.length) {
            result.add(new ArrayList<>(oneRes));
            return;
        }

        oneRes.add(nums[i]);
        backtrack(nums, i + 1, oneRes, result);
        oneRes.remove(oneRes.size() - 1);
        backtrack(nums, i + 1, oneRes, result);
    }


}
