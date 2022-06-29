package whiteboard;

import java.util.ArrayList;
import java.util.List;

public class Permutations2 {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        List<Integer> array = new ArrayList<>();
        for (int element : arr) {
            array.add(element);
        }

        getPermutations(array);
    }

    // O(n*n!) time | O(n*n!) space
    public static List<List<Integer>> getPermutations(List<Integer> array) {
        // Write your code here.
        if (array.isEmpty()) {
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> newArray = new ArrayList<>();
        getPermutationsHelper(array, newArray, result);
        return result;
    }

    private static void getPermutationsHelper(List<Integer> array, List<Integer> newArray,
                                              List<List<Integer>> result) {
        if (array.isEmpty()) {
            result.add(newArray);
            return;
        } else {
            for (int i = 0; i < array.size(); i++) {
                List<Integer> currArray = new ArrayList<>(array);
                Integer current = currArray.remove(i);
                List<Integer> currNewArr = new ArrayList<>(newArray);
                currNewArr.add(current);
                getPermutationsHelper(currArray, currNewArr, result);
            }
        }
    }

}
