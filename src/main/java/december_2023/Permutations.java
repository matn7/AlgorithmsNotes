package december_2023;

import java.util.ArrayList;
import java.util.List;

public class Permutations {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        List<Integer> array = new ArrayList<>();
        for (int num : arr) {
            array.add(num);
        }

        getPermutations(array);
    }

    // O(n!) time | O(n!) space
    public static List<int[]> getPermutations(List<Integer> array) {
        List<int[]> permutations = new ArrayList<>();
        getPermutationsHelper(array, new ArrayList<>(), permutations);
        return permutations;
    }

    private static void getPermutationsHelper(List<Integer> currArr, List<Integer> newArr, List<int[]> permutations) {
        if (currArr.isEmpty()) {
            int[] oneElement = new int[newArr.size()];
            for (int i = 0; i < newArr.size(); i++) {
                oneElement[i] = newArr.get(i);
            }
            permutations.add(oneElement);
        } else {
            for (int i = 0; i < currArr.size(); i++) {
                List<Integer> currArrNew = new ArrayList<>(currArr);
                List<Integer> newArrNew = new ArrayList<>(newArr);
                Integer removed = currArrNew.remove(i);
                newArrNew.add(removed);
                getPermutationsHelper(currArrNew, newArrNew, permutations);
            }
        }
    }

}
