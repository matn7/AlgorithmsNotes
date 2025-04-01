package march_2025;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PermutationsII {

    public static void main(String[] args) {
        int[] nums = {1, 1, 2};
        PermutationsII permutationsII = new PermutationsII();
        List<List<Integer>> result = permutationsII.permuteUnique(nums);
        System.out.println(result);
    }

    // O(n! * n) time | O(n! * n) space
    public List<List<Integer>> permuteUnique(int[] nums) {
        Set<List<Integer>> result = new HashSet<>();
        List<Integer> numsArr = new ArrayList<>();
        for (int num : nums) {
            numsArr.add(num);
        }
        backtrack(numsArr, new ArrayList<>(), result);
        return new ArrayList<>(result);
    }

    private void backtrack(List<Integer> nums, List<Integer> curr, Set<List<Integer>> result) {
        if (nums.isEmpty()) {
            result.add(curr);
            return;
        }
        for (int i = 0; i < nums.size(); i++) {
            List<Integer> newCurr = new ArrayList<>(curr);
            List<Integer> newNums = new ArrayList<>(nums);
            Integer removed = newNums.remove(i);
            newCurr.add(removed);
            backtrack(newNums, newCurr, result);
        }
    }

}
