package september_2023;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class SameBsts {

    public static void main(String[] args) {
        int[] arrOne = {10, 15, 8, 12, 94, 81, 5, 2, 11};
        int[] arrTwo = {10, 8, 5, 15, 2, 12, 11, 94, 81};
        List<Integer> arrayOne = new ArrayList<>();
        for (int n : arrOne) {
            arrayOne.add(n);
        }
        List<Integer> arrayTwo = new ArrayList<>();
        for (int n : arrTwo) {
            arrayTwo.add(n);
        }
        boolean result = sameBsts(arrayOne, arrayTwo);
        System.out.println(result);
    }

    // O(n^2) time | O(n) space
    public static boolean sameBsts(
            List<Integer> arrayOne, List<Integer> arrayTwo
    ) {
        return areSameBsts(arrayOne, arrayTwo, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private static boolean areSameBsts(List<Integer> arrayOne, List<Integer> arrayTwo, int rootIdxOne, int rootIdxTwo,
                                       int minVal, int maxVal) {
        if (rootIdxOne == -1 || rootIdxTwo == -1) {
            return rootIdxOne == rootIdxTwo;
        }

        if (arrayOne.get(rootIdxOne) != arrayTwo.get(rootIdxTwo)) {
            return false;
        }

        int leftRootIdxOne = getIdxOfFirstSmaller(arrayOne, rootIdxOne, minVal);
        int leftRootIdxTwo = getIdxOfFirstSmaller(arrayTwo, rootIdxTwo, minVal);
        int rightRootIdxOne = getIdxOfFirstBiggerOrEqual(arrayOne, rootIdxOne, maxVal);
        int rightRootIdxTwo = getIdxOfFirstBiggerOrEqual(arrayTwo, rootIdxTwo, maxVal);

        int currentValue = arrayOne.get(rootIdxOne);
        boolean leftAreSame = areSameBsts(arrayOne, arrayTwo, leftRootIdxOne, leftRootIdxTwo, minVal, currentValue);
        boolean rightAreSame = areSameBsts(arrayOne, arrayTwo, rightRootIdxOne, rightRootIdxTwo, currentValue, maxVal);
        return leftAreSame && rightAreSame;
    }

    private static int getIdxOfFirstSmaller(List<Integer> array, int startingIdx, int minVal) {
        for (int i = startingIdx + 1; i < array.size(); i++) {
            if (array.get(i) < array.get(startingIdx) && array.get(i) >= minVal) {
                return i;
            }
        }
        return -1;
    }

    private static int getIdxOfFirstBiggerOrEqual(List<Integer> array, int startingIdx, int maxVal) {
        for (int i = startingIdx + 1; i < array.size(); i++) {
            if (array.get(i) >= array.get(startingIdx) && array.get(i) < maxVal) {
                return i;
            }
        }
        return -1;
    }

    // O(n^2) time | O(n^2) space
    public static boolean sameBsts2(
            List<Integer> arrayOne, List<Integer> arrayTwo
    ) {
        // Write your code here.
        if (arrayOne.isEmpty() && arrayTwo.isEmpty()) {
            return true;
        }
        if (arrayOne.size() != arrayTwo.size()) {
            return false;
        }
        Integer firstOne = arrayOne.remove(0);
        Integer firstTwo = arrayTwo.remove(0);
        if (firstOne != firstTwo) {
            return false;
        }
        List<Integer> smallerOne = getElements(arrayOne, n -> n < firstOne);
        List<Integer> smallerTwo = getElements(arrayTwo, n -> n < firstTwo);
        List<Integer> largerOne = getElements(arrayOne, n -> n >= firstOne);
        List<Integer> largerTwo = getElements(arrayTwo, n -> n >= firstTwo);
        return sameBsts(smallerOne, smallerTwo) && sameBsts(largerOne, largerTwo);
    }

    private static List<Integer> getElements(List<Integer> array, Predicate<Integer> condition) {
        List<Integer> result = new ArrayList<>();
        for (int num : array) {
            if (condition.test(num)) {
                result.add(num);
            }
        }
        return result;
    }



}
