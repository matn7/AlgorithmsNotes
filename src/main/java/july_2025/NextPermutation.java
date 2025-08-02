package july_2025;

import java.util.ArrayList;
import java.util.List;

public class NextPermutation {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        NextPermutation nextPermutation = new NextPermutation();
        nextPermutation.nextPermutation(nums);


        nextPermutation.permute(nums);
        System.out.println();
    }

    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }

        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1);
    }

    private void reverse(int[] nums, int start) {
        int end = nums.length - 1;
        while (start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    // O(n! * n) time | O(n! * n) space
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> permutations = new ArrayList<>();
        List<Integer> part = new ArrayList<>();
        boolean[] pick = new boolean[nums.length];
        helper(nums, pick, part, permutations);
        return permutations;
    }

    private void helper(int[] nums, boolean[] pick, List<Integer> part, List<List<Integer>> result) {
        if (part.size() == nums.length) {
            result.add(new ArrayList<>(part));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!pick[i]) {
                pick[i] = true;
                part.add(nums[i]);
                helper(nums, pick, part, result);
                part.remove(part.size() - 1);
                pick[i] = false;
            }
        }
    }

}
