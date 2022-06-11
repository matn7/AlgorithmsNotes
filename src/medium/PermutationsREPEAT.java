package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationsREPEAT {

    public static void main(String[] args) {
        List<Integer> array = new ArrayList<>(Arrays.asList(1, 2, 3));

        List<List<Integer>> permutations = getPermutations(array);
        System.out.println();
    }

//    // O(n!*n) time | O(n!*n) space
//    // OK - repeated 09/02/2022
//    public static List<List<Integer>> getPermutations(List<Integer> array) {
//        // Write your code here.
//        List<List<Integer>> permutations = new ArrayList<>();
//        permutationsHelper(0, array, permutations);
//        return permutations;
//    }
//
//    // rec(2, [3,2,1])
//    // rec(2, [3,1,2])
//    // rec(1, [3,1,2]) j = 2
//    // rec(0, [1,2,3]) j = 2
//
//    // rec(2, [2,3,1])
//    // rec(2, [2,1,3])
//    // rec(1, [2,1,3]) j = 1
//    // rec(0, [1,2,3]) j = 1
//
//    // rec(2, [1,3,2]) j = 2
//    // rec(2, [1,2,3])
//
//    // rec(1, [1,2,3]) j = 1
//    // rec(0, [1,2,3]) j = 0
//    private static void permutationsHelper(int i, List<Integer> array, List<List<Integer>> permutations) {
//        if (i == array.size() - 1) {
//            List<Integer> snapshot = new ArrayList<>(array);
//            permutations.add(snapshot);
//        } else {
//            for (int j = i; j < array.size(); j++) {
//                System.out.println("before: " + i + " : " + j);
//                swap(i, j, array);
//                permutationsHelper(i + 1, array, permutations);
//                System.out.println("after : " + i + " : " + j);
//                swap(i, j, array);
//            }
//        }
//    }
//    // [[1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], [3,2,1]]
//
//    private static void swap(int i, int j, List<Integer> array) {
//        int temp = array.get(i);
//        array.set(i, array.get(j));
//        array.set(j, temp);
//    }

    // Upper Bound: O(n!*n^2) time | O(n*n!) space
    // Roughly: O(n!*n) time | O(n*n!) space
    public static List<List<Integer>> getPermutations(List<Integer> array) {
        // Write your code here.
        List<Integer> currentPermutation = new ArrayList<>();
        List<List<Integer>> permutations = new ArrayList<>();
        permutationsHelper(array, currentPermutation, permutations);
        return permutations;
    }


    // rec([], [3,2,1])
    // rec([1], [3,2])
    // rec([], [3,1,2])
    // rec([2], [3,1])
    // rec([1,2], [3])

    // rec([], [2,3,1])
    // rec([1], [2,3])
    // rec([], [2,1,3])
    // rec([3], [2,1])
    // rec([1,3], [2])

    // rec([], [1,3,2])
    // rec([2], [1,3])
    // rec([], [1,2,3])
    // rec([3], [1,2])
    // rec([2,3], [1])

    // rec([1,2,3], [])
    private static void permutationsHelper(List<Integer> array, List<Integer> currentPermutation,
                                    List<List<Integer>> permutations) {
        if (array.isEmpty() && !currentPermutation.isEmpty()) {
            permutations.add(currentPermutation);
        } else {
            for (int idx = 0; idx < array.size(); idx++) {
                // new array with remaining numbers
                List<Integer> newArray = new ArrayList<>(array); // [2]
                newArray.remove(idx); // O(n) []

                List<Integer> newPerm = new ArrayList<>(currentPermutation);
                newPerm.add(array.get(idx)); // O(n) // [1, 3, 2]

                permutationsHelper(newArray, newPerm, permutations);
            }
        }
        // [[1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], [3,2,1]
    }

}
