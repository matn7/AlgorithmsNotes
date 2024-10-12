package october_2024;

import java.util.ArrayList;
import java.util.List;

public class Subsets {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};

        Subsets subsets = new Subsets();
        List<List<Integer>> result = subsets.subsets(nums);
        System.out.println(result);
    }

    // O(2^n) time | O(n*2^n) space
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        result.add(new ArrayList<>());
        for (int n : nums) {
            int size = result.size();;
            for (int i = 0; i < size; i++) {
                List<Integer> integers = new ArrayList<>(result.get(i));
                integers.add(n);
                result.add(integers);
            }
        }

        return result;
    }

}
