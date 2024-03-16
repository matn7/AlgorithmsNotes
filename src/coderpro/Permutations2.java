package coderpro;

import java.util.ArrayList;
import java.util.List;

public class Permutations2 {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        List<Integer> array = new ArrayList<>();
        for (int a : arr) {
            array.add(a);
        }

        Permutations2 permutations2 = new Permutations2();
        permutations2.permutations(array);
    }
    
    // O(n * n!) time | O(n * n!) space
    public List<List<Integer>> permutations(List<Integer> array) {
        List<List<Integer>> result = new ArrayList<>();
        permutationsHelper(new ArrayList<>(), array, result);
        return result;
    }

    private void permutationsHelper(List<Integer> current, List<Integer> array, List<List<Integer>> result) {
        if (array.isEmpty()) {
            result.add(current);
        } else {
            for (int i = 0; i < array.size(); i++) {
                List<Integer> newArray = new ArrayList<>(array);
                Integer removed = newArray.remove(i);
                List<Integer> newCurrent = new ArrayList<>(current);
                newCurrent.add(removed);
                permutationsHelper(newCurrent, newArray, result);
            }
        }
    }

}
