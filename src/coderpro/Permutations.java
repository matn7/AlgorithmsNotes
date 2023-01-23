package coderpro;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations {

    public static void main(String[] args) {
        List<Integer> nums = new ArrayList<>(Arrays.asList(1, 2, 3));

        Permutations permutations = new Permutations();

        List<List<Integer>> result = permutations.findPermutationsMy(nums);
        System.out.println();
    }

    // O(n!) time | O(n!) space
    public List<List<Integer>> permute(List<Integer> nums) {
        List<List<Integer>> result = new ArrayList<>();
        permuteHelper(nums, 0, result);
        return result;
    }

    private void permuteHelper(List<Integer> nums, int start, List<List<Integer>> result) {
        if (start == nums.size()) {
            List<Integer> snapshot = new ArrayList<>(nums);
            result.add(snapshot);
        } else {
            for (int i = start; i < nums.size(); i++) {
                swap(nums, start, i);
                permuteHelper(nums, start + 1, result);
                swap(nums, start, i);
            }
        }
    }

    private void swap(List<Integer> nums, int i, int j) {
        Integer temp = nums.get(i);
        nums.set(i, nums.get(j));
        nums.set(j, temp);
    }

    // O(n!) time | O(n!) space
    public List<List<Integer>> findPermutationsMy(List<Integer> nums) {
        List<List<Integer>> perms = new ArrayList<>();
        findPermutationsHelper(nums, new ArrayList<>(), perms);
        return perms;
    }

    private void findPermutationsHelper(List<Integer> nums, List<Integer> curr, List<List<Integer>> perms) {
        if (nums.isEmpty()) {
            perms.add(curr);
        } else {
            for (int i = 0; i < nums.size(); i++) {
                List<Integer> newNums = new ArrayList<>(nums);
                Integer removed = newNums.remove(i);
                List<Integer> newCurr = new ArrayList<>(curr);
                newCurr.add(removed);
                findPermutationsHelper(newNums, newCurr, perms);
            }
        }
    }

}
