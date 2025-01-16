package january_2025;

import java.util.ArrayList;
import java.util.List;

public class Permutations {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        Permutations permutations = new Permutations();
        List<List<Integer>> permute = permutations.permute(nums);
        System.out.println(permute);
    }

    List<List<Integer>> res;

    public List<List<Integer>> permute(int[] nums) {
        res = new ArrayList<>();
        List<Integer> numsArr = new ArrayList<>();
        for (int num : nums) {
            numsArr.add(num);
        }
        backtrack(numsArr, new ArrayList<>());
        return res;
    }

    private void backtrack(List<Integer> nums, List<Integer> curr) {
        if (nums.size() == 0) {
            res.add(new ArrayList<>(curr));
        } else {
            for (int i = 0; i < nums.size(); i++) {
                List<Integer> newNums = new ArrayList<>(nums);
                Integer removed = newNums.remove(i);
                curr.add(removed);
                backtrack(newNums, curr);
                curr.remove(curr.size() - 1);
            }
        }
    }

}
