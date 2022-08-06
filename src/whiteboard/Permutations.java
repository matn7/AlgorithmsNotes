package whiteboard;

import java.util.ArrayList;
import java.util.List;

public class Permutations {

    public static void main(String[] args) {
        List<Integer> array = new ArrayList<>();
        array.add(1);
        array.add(2);
        array.add(3);

        getPermutations(array);
    }

    // O(n * n!) time | O(n * n!) space
    // rand: 06/08/2022
    public static List<List<Integer>> getPermutations(List<Integer> array) {
        // Write your code here.
        if (array.isEmpty()) {
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        getPermutationsHelper(array, new ArrayList<>(), result);
        return result;
    }

    private static void getPermutationsHelper(List<Integer> array, List<Integer> curr, List<List<Integer>> result) {
        if (array.isEmpty()) {
            result.add(curr);
        } else {
            for (int i = 0; i < array.size(); i++) {
                List<Integer> newArray = new ArrayList<>(array);
                List<Integer> newCurr = new ArrayList<>(curr);
                Integer top = newArray.remove(i);
                newCurr.add(top);
                getPermutationsHelper(newArray, newCurr, result);
            }
        }
    }

}
