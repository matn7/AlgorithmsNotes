package october_2023;

import java.util.ArrayList;
import java.util.List;

public class PermutationsV2 {

    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(2);
        arr.add(3);

        permutations(arr);
    }

    // O(n*n!) time | O(n*n!) space
    public static List<List<Integer>> permutations(List<Integer> arr) {
        List<List<Integer>> result = new ArrayList<>();

        permutationsHelper(arr, new ArrayList<>(), result);

        return result;
    }

    private static void permutationsHelper(List<Integer> arr, List<Integer> permut, List<List<Integer>> result) {
        if (arr.isEmpty()) {
            result.add(permut);
        } else {
            for (int i = 0; i < arr.size(); i++) {
                List<Integer> newArr = new ArrayList<>(arr);
                List<Integer> newPermut = new ArrayList<>(permut);
                Integer removed = newArr.remove(i);
                newPermut.add(removed);
                permutationsHelper(newArr, newPermut, result);
            }
        }
    }

}
