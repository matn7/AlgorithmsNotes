package medium;

import java.util.ArrayList;
import java.util.List;

public class Powerset {

    public static void main(String[] args) {
        List<Integer> array = new ArrayList<>();
        array.add(1);
        array.add(2);
        array.add(3);

        List<List<Integer>> powerset = powerset(array);
        System.out.println();
    }

    // O(2^n * n) time | O(2^n * n) space
    // OK - repeated 12/02/2022
    public static List<List<Integer>> powerset(List<Integer> array) {
        List<List<Integer>> result = new ArrayList<>();
        if (array.isEmpty()) {
            result.add(new ArrayList<>());
            return result;
        }
        powersetHelper(array, result, null);
        return result;
    }

    public static void powersetHelper(List<Integer> array, List<List<Integer>> result, Integer idx) {
        if (idx == null) {
            idx = array.size() - 1; // 2
        } else if (idx < 0) {
            result.add(new ArrayList<>());
            return;
        }
        Integer element = array.get(idx); // 3, 2, 1
        powersetHelper(array, result, idx - 1); // []
        int size = result.size(); // 4
        for (int i = 0; i < size; i++) {
            List<Integer> current = new ArrayList<>(result.get(i)); // [1,2]
            current.add(element); // [1,2,3]
            result.add(current); // [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
        }
    }

    // O(2^n * n) time | O(2^n * n) space
    public static List<List<Integer>> powerset2(List<Integer> array) {
        // Write your code here.
        List<List<Integer>> subsets = new ArrayList<>();
        subsets.add(new ArrayList<>()); // [[]]

        // [1,2,3]
        for (int element : array) {
            // element = 3
            int size = subsets.size(); // 4
            // every time we loop we double number of subsets
            for (int i = 0; i < size; i++) {
                List<Integer> current = new ArrayList<>(subsets.get(i)); // [1,2]
                current.add(element); // [1,2,3]
                subsets.add(current); // [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
            }
        }

        return subsets;
    }

}
