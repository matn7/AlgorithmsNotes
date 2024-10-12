package april_2024;

import java.util.ArrayList;
import java.util.List;

public class Subsets {

    public static void main(String[] args) {
        int[] nums = {1,2,3};

        List<List<Integer>> result = subsets(nums);
        System.out.println(result);
    }

    // O(2^n) time | O(2^n) space
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        solution(nums, ans, curr, 0);
        return ans;
    }

    private static void solution(int[] nums, List<List<Integer>> ans, List<Integer> curr, int index) {
        if (index > nums.length) {
            return;
        }
        ans.add(new ArrayList<>(curr));
        for (int i = index; i < nums.length; i++) {
            if (!curr.contains(nums[i])) {
                curr.add(nums[i]);
                solution(nums, ans, curr, i);
                curr.remove(curr.size() - 1);
            }
        }
        return;
    }

    // O(2^n) time | O(2^n) space
    public static List<List<Integer>> subsets2(int[] nums) {
        if (nums.length == 0) {
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());

        for (int num : nums) {
            int size = result.size();
            for (int i = 0; i < size; i++) {
                List<Integer> currElement = new ArrayList<>(result.get(i));
                currElement.add(num);
                result.add(currElement);
            }
        }

        return result;
    }

}
