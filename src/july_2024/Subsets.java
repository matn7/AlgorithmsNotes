package july_2024;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets {

    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(1, 2, 3);
        List<List<Integer>> result = subsets(list);
        System.out.println(result);

        List<List<Integer>> result2 = subsets2(list);
        System.out.println(result2);
    }

    public static List<List<Integer>> subsets(List<Integer> list) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());

        for (int num : list) {
            int size = result.size();
            for (int i = 0; i < size; i++) {
                List<Integer> integers = new ArrayList<>(result.get(i));
                integers.add(num);
                result.add(integers);
            }
        }

        return result;
    }

    // O(2^n) time | O(2^n) space
    public static List<List<Integer>> subsets2(List<Integer> nums) {
        List<List<Integer>> answer = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        solution(nums, answer, curr, 0);
        return answer;
    }

    private static void solution(List<Integer> nums, List<List<Integer>> answer, List<Integer> curr, int index) {
        if (index > nums.size()) {
            return;
        }
        answer.add(new ArrayList<>(curr));
        for (int i = index; i < nums.size(); i++) {
            if (!curr.contains(nums.get(i))) {
                curr.add(nums.get(i));
                solution(nums, answer, curr, i);
                curr.remove(curr.size() - 1);
            }
        }
    }
}
