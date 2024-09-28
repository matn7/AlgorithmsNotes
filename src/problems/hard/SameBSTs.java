package problems.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SameBSTs {

    public static void main(String[] args) {
        List<Integer> arrayOne = new ArrayList<>(Arrays.asList(10, 15, 8, 12, 94, 81, 5, 2, 11));
        List<Integer> arrayTwo = new ArrayList<>(Arrays.asList(10, 8, 5, 15, 2, 12, 11, 94, 81));

        boolean result = sameBsts(arrayOne, arrayTwo);

        System.out.println(result);
    }

    // ********
    // * STAR - G *
    // ********

    // O(n^2) time | O(d) space
    // OK - repeated 24/01/2022
    public static boolean sameBsts(List<Integer> arrayOne, List<Integer> arrayTwo) {
        return areSameBsts(arrayOne, arrayTwo, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private static boolean areSameBsts(List<Integer> arrayOne, List<Integer> arrayTwo,
                             int rootIdxOne, int rootIdxTwo, int minVal, int maxVal) {
        if (rootIdxOne == -1 || rootIdxTwo == -1) {
            return rootIdxOne == rootIdxTwo;
        }
        if (arrayOne.get(rootIdxOne) != arrayTwo.get(rootIdxTwo)) { // 81 != 81
            return false;
        }
        //  0   1   2   3   4   5   6   7   8
        //-----------------------------------
        // 10, 15,  8, 12, 94, 81,  5,  2, 11
        // 10,  8,  5, 15,  2, 12, 11, 94, 81
        int leftRootIdxOne = getIdxOfFirstSmaller(arrayOne, rootIdxOne, minVal); // first index smaller than 10
        int leftRootIdxTwo = getIdxOfFirstSmaller(arrayTwo, rootIdxTwo, minVal); // 1, 2, 4, -1 | 5, 6, -1 | 8, -1
        int rightRootIdxOne = getIdxOfFirstBiggerOrEqual(arrayOne, rootIdxOne, maxVal); // 1, 3, 8, 8 | 4, -1, -1 | -1, -1
        int rightRootIdxTwo = getIdxOfFirstBiggerOrEqual(arrayTwo, rootIdxTwo, maxVal); // 3, 3, 3, 5 | 7, -1, -1 | -1, -1

        int currentValue = arrayOne.get(rootIdxOne); // 10, 8, 5, 2, 15, 12, 11, 94, 81
        boolean leftAreSame = areSameBsts(arrayOne, arrayTwo, leftRootIdxOne, leftRootIdxTwo, minVal, currentValue); // true
        boolean rightAreSame = areSameBsts(arrayOne, arrayTwo, rightRootIdxOne, rightRootIdxTwo, currentValue, maxVal);

        return leftAreSame && rightAreSame;
    }

    // Look for indexes of smaller from arr1 and arr2
    // arr1 has elements from left subtree at indexes: [2, 6, 7]
    // arr2 has elements from right subtree at indexes: [2, 6, 7]
    //  0   1   2   3   4   5   6   7   8
    //-----------------------------------
    // 10, 15,  8, 12, 94, 81,  5,  2, 11
    // 10,  8,  5, 15,  2, 12, 11, 94, 81
    private static int getIdxOfFirstSmaller(List<Integer> array, int startingIdx, int minVal) { // arr, 0, -9999
        for (int i = startingIdx + 1; i < array.size(); i++) {
            if (array.get(startingIdx) > array.get(i)  && array.get(i) >= minVal) {
                return i;
            }
        }
        return -1;
    }

    //  0   1   2   3   4   5   6   7   8
    //-----------------------------------
    // 10, 15,  8, 12, 94, 81,  5,  2, 11
    // 10,  8,  5, 15,  2, 12, 11, 94, 81
    private static int getIdxOfFirstBiggerOrEqual(List<Integer> array, int startingIdx, int maxVal) {
        for (int i = startingIdx + 1; i < array.size(); i++) {
            if (array.get(startingIdx) <= array.get(i) && array.get(i) < maxVal) {
                return i;
            }
        }
        return -1;
    }

    // O(n^2) time | O(n^2) space
    public static boolean sameBsts2(List<Integer> arrayOne, List<Integer> arrayTwo) {
        // do array has the same lengths
        if (arrayOne.size() != arrayTwo.size()) {
            return false;
        }
        if (arrayOne.isEmpty() && arrayTwo.isEmpty()) {
            return true;
        }
        if (arrayOne.get(0) != arrayTwo.get(0)) {
            return false;
        }
        List<Integer> leftOne = getSmaller(arrayOne);
        List<Integer> leftTwo = getSmaller(arrayTwo);
        List<Integer> rightOne = getBiggerOrEqual(arrayOne);
        List<Integer> rightTwo = getBiggerOrEqual(arrayTwo);

        return sameBsts(leftOne, leftTwo) && sameBsts(rightOne, rightTwo);
    }

    private static List<Integer> getSmaller(List<Integer> array) {
        List<Integer> smaller = new ArrayList<>();
        for (int i = 1; i < array.size(); i++) {
            if (array.get(i) < array.get(0)) {
                smaller.add(array.get(i));
            }
        }
        return smaller;
    }

    private static List<Integer> getBiggerOrEqual(List<Integer> array) {
        List<Integer> biggerOrEqual = new ArrayList<>();
        for (int i = 1; i < array.size(); i++) {
            if (array.get(i) >= array.get(0)) {
                biggerOrEqual.add(array.get(i));
            }
        }
        return biggerOrEqual;
    }

}
