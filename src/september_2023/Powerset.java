package september_2023;

import java.util.ArrayList;
import java.util.List;

public class Powerset {

    public static void main(String[] args) {
        List<Integer> array = new ArrayList<>();
        array.add(1);
        array.add(2);
        array.add(3);

        powersetRec(array);
    }

    // O(n * 2^n) time | O(n * 2^n) space
    public static List<List<Integer>> powerset(List<Integer> array) {
        // Write your code here.
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        powersetHelper(array, result);
        return result;
    }

    private static void powersetHelper(List<Integer> array, List<List<Integer>> result) {
        for (int i = 0; i < array.size(); i++) {
            int currSize = result.size();
            for (int j = 0; j < currSize; j++) {
                List<Integer> currRes = new ArrayList<>(result.get(j));
                currRes.add(array.get(i));
                result.add(currRes);
            }
        }
    }

    // O(n * 2^n) time | O(n * 2^n) space
    public static List<List<Integer>> powersetRec(List<Integer> array) {
        List<List<Integer>> result = new ArrayList<>();
        if (array.isEmpty()) {
            result.add(new ArrayList<>());
            return result;
        }
        powersetRecHelper(result, array, null);
        return result;
    }

    private static void powersetRecHelper(List<List<Integer>> result, List<Integer> array, Integer idx) {
        if (idx == null) {
            idx = array.size() - 1;
        } else if (idx < 0) {
            result.add(new ArrayList<>());
            return;
        }
        Integer element = array.get(idx);
        powersetRecHelper(result, array, idx - 1);
        int currSize = result.size();
        for (int j = 0; j < currSize; j++) {
            List<Integer> currRes = new ArrayList<>(result.get(j));
            currRes.add(element);
            result.add(currRes);
        }
    }

}
