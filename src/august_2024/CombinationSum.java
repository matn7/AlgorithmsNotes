package august_2024;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {

    public static void main(String[] args) {
        int[] nums = {2, 3, 6};
        int target = 8;

        combinationSum(nums, target);
    }

    // O(2^n) time | O(2^n) space
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> answer = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        List<List<Integer>> solution = solution(candidates, answer, current, target, 0, 0);
        return solution;
    }

    private static List<List<Integer>> solution(int[] candidates, List<List<Integer>> answer, List<Integer> curr,
                                                int target, int index, int sum) {
        if (sum == target) {
            answer.add(new ArrayList<>(curr));
        } else if (sum < target) {
            int n = candidates.length;
            for (int i = index; i < n; i++) {
                curr.add(candidates[i]);
                solution(candidates, answer, curr, target, i, sum + candidates[i]);
                curr.remove(curr.size() - 1);
            }
        }
        return answer;
    }


}
