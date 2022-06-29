package educative.subsets;

import java.util.ArrayList;
import java.util.List;

public class PermutationsRecursive {

    public static void main(String[] args) {
        List<List<Integer>> result = PermutationsRecursive.generatePermutations(new int[] { 1, 3, 5 });
        System.out.print("Here are all the permutations: " + result);
    }

    // O(n*n!) time | O(n*n!) space
    public static List<List<Integer>> generatePermutations(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        generatePermutationsRecursive(nums, 0, new ArrayList<>(), result);
        return result;
    }

    public static void generatePermutationsRecursive(int[] nums, int index, List<Integer> currentPermutation,
                                                     List<List<Integer>> result) {
        if (index == nums.length) {
            result.add(currentPermutation);
        } else {
            for (int i = 0; i <= currentPermutation.size(); i++) {
                List<Integer> newPermutation = new ArrayList<>(currentPermutation);
                newPermutation.add(i, nums[index]);
                generatePermutationsRecursive(nums, index + 1, newPermutation, result);
            }
        }
    }

}
