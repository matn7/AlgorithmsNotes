package whiteboard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations {

    public static void main(String[] args) {
        List<Integer> array = new ArrayList<>();
        array.add(1);
        array.add(2);
        array.add(3);

        List<List<Integer>> result = getPermutations(array);
        System.out.println();
    }

    // O(n * n!) time | O(n * n!) space
    // #2: 26/06/2022
    public static List<List<Integer>> getPermutations(List<Integer> array) {
        // Write your code here.
        if (array.isEmpty()) {
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> newArr = new ArrayList<>();
        getPermutationsHelper(array, newArr, result);

        return result;
    }

    private static void getPermutationsHelper(List<Integer> array, List<Integer> newArr,
                                              List<List<Integer>> result) {
        if (array.isEmpty()) {
            result.add(newArr);
        } else {
            for (int idx = 0; idx < array.size(); idx++) {
                List<Integer> currArray = new ArrayList<>(array);
                Integer removed = currArray.remove(idx);
                List<Integer> currNewArray = new ArrayList<>(newArr);
                currNewArray.add(removed);
                getPermutationsHelper(currArray, currNewArray, result);
            }
        }
    }

}
