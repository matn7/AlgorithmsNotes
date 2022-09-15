package udemy.recursion;

import java.util.ArrayList;
import java.util.List;

public class FinaAllSubsets {

    public static void main(String[] args) {
        int[] inputArr = {1, 2, 3, 4};
        List<Integer> input = new ArrayList<>();
        for (int element : inputArr) {
            input.add(element);
        }

        List<List<Integer>> resIterative = findAllSubsets(input);

        List<List<Integer>> resRecursive = new ArrayList<>();
        findAllSubsets(input, resRecursive);
        System.out.println();
    }

    // {1, 2, 3, 4}
    public static List<List<Integer>> findAllSubsets(List<Integer> input) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        for (int element : input) {
            int size = result.size();
            for (int i = 0; i < size; i++) {
                List<Integer> current = new ArrayList<>(result.get(i));
                current.add(element);
                result.add(current);
            }
        }
        return result;
    }

    // O(2^n) time
    public static void findAllSubsets(List<Integer> input, List<List<Integer>> result) {
        if (input.isEmpty()) {
            result.add(new ArrayList<>());
            return;
        }
        Integer current = input.remove(0);
        findAllSubsets(input, result);
        int size = result.size();
        for (int i = 0; i < size; i++) {
            List<Integer> currentArray = new ArrayList<>(result.get(i));
            currentArray.add(current);
            result.add(currentArray);
        }

    }
    
}
