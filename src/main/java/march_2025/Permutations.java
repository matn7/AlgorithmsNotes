package march_2025;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        Permutations permutations = new Permutations();
        List<List<Integer>> permute = permutations.permute(nums);
        System.out.println(permute);
    }


    // O(n^2 * n!) time | O(n * n!) space
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> numsArr = new ArrayList<>();
        for (int num : nums) {
            numsArr.add(num);;
        }
        backtrack2(numsArr, new ArrayList<>(), result);
        return result;
    }

    private void backtrack2(List<Integer> nums, List<Integer> curr, List<List<Integer>> result) {
        if (nums.size() == 0) {
            result.add(curr);
            return;
        }
        for (int i = 0; i < nums.size(); i++) {
            List<Integer> newCurr = new ArrayList<>(curr);
            List<Integer> newNums = new ArrayList<>(nums);
            Integer removed = newNums.remove(i);
            newCurr.add(removed);
            backtrack2(newNums, newCurr, result);
        }
    }

}
