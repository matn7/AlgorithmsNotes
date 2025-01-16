package december_2024;

import java.util.ArrayList;
import java.util.List;

public class Permutations {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> permutations = new ArrayList<>();
        List<Integer> numsArr = new ArrayList<>();
        for (int n : nums) {
            numsArr.add(n);
        }
        backtrack(numsArr, new ArrayList<>(), permutations);
        return permutations;
    }

    private void backtrack(List<Integer> nums, List<Integer> curr, List<List<Integer>> permutations) {
        if (nums.isEmpty()) {
            permutations.add(curr);
        } else {
            for (int i = 0; i < nums.size(); i++) {
                List<Integer> newNums = new ArrayList<>(nums);
                List<Integer> newCurr = new ArrayList<>(curr);
                Integer removed = newNums.remove(i);
                newCurr.add(removed);
                backtrack(newNums, newCurr, permutations);
            }
        }
    }


}
