package october_2023;

import java.util.ArrayList;
import java.util.List;

public class Permutations {

    public static void main(String[] args) {
        List<Integer> array = new ArrayList<>();
        array.add(1);
        array.add(2);
        array.add(3);

        permutations(array);
    }

    // O(n*n!) time | O(n*n!) space
    public static List<List<Integer>> permutations(List<Integer> array) {
        List<List<Integer>> result = new ArrayList<>();
        permutationsHelper(array, new ArrayList<>(), result);
        return result;
    }

    private static void permutationsHelper(List<Integer> array, List<Integer> currArray, List<List<Integer>> result) {
        if (array.isEmpty()) {
            result.add(currArray);
        } else {
            for (int i = 0; i < array.size(); i++) {
                List<Integer> newArray = new ArrayList<>(array);
                Integer removed = newArray.remove(i);
                List<Integer> newCurrArray = new ArrayList<>(currArray);
                newCurrArray.add(removed);
                permutationsHelper(newArray, newCurrArray, result);
            }
        }
    }


}
