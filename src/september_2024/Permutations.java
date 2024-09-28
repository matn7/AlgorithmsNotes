package september_2024;

import java.util.ArrayList;
import java.util.List;

public class Permutations {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};

        Permutations permutations = new Permutations();
        List<List<Integer>> permute = permutations.permute(nums);
        System.out.println(permute.size());
    }

    public List<List<Integer>> permute(int[] nums) {
        List<Integer> numsArr = new ArrayList<>();
        for (int n : nums) {
            numsArr.add(n);
        }
        List<List<Integer>> result = new ArrayList<>();
        helper(numsArr, new ArrayList<>(), result);
        return result;
    }

    private void helper(List<Integer> nums, List<Integer> curr, List<List<Integer>> result) {
        if (nums.isEmpty()) {
            result.add(curr);
        } else {
            for (int i = 0; i < nums.size(); i++) {
                List<Integer> newNums = new ArrayList<>(nums);
                List<Integer> newCurr = new ArrayList<>(curr);
                Integer removed = newNums.remove(i);
                newCurr.add(removed);
                helper(newNums, newCurr, result);
            }
        }
    }

}
