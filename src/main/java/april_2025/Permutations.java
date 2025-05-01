package april_2025;

import java.util.ArrayList;
import java.util.List;

public class Permutations {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};

        Permutations permutations = new Permutations();
        List<List<Integer>> result = permutations.permute(nums);
        System.out.println(result);
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> numsArr = new ArrayList<>();
        for (int n : nums) {
            numsArr.add(n);
        }
        backtrack(numsArr, new ArrayList<>(), result);

        return result;
    }

    private void backtrack(List<Integer> nums, List<Integer> curr, List<List<Integer>> result) {
        if (nums.isEmpty()) {
            result.add(curr);
            return;
        }
        for (int i = 0; i < nums.size(); i++) {
            List<Integer> newNums = new ArrayList<>(nums);
            List<Integer> newCurr = new ArrayList<>(curr);
            Integer removed = newNums.remove(i);
            newCurr.add(removed);
            backtrack(newNums, newCurr, result);
        }
    }

}
