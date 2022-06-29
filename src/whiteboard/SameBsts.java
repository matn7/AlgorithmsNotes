package whiteboard;

import java.util.ArrayList;
import java.util.List;

public class SameBsts {

    public static void main(String[] args) {
        int[] elementsOne = {10, 15, 8, 12, 94, 81, 5, 2, 11, 10};
        int[] elementsTwo = {10, 8, 5, 15, 2, 12, 11, 94, 81, 10};
        List<Integer> arrayOne = new ArrayList<>();
        List<Integer> arrayTwo = new ArrayList<>();

        for (int element : elementsOne) {
            arrayOne.add(element);
        }

        for (int element : elementsTwo) {
            arrayTwo.add(element);
        }

        boolean result = sameBsts(arrayOne, arrayTwo);
        System.out.println();
    }

    // O(n^2) time | O(d) space
    // #2: 21/06/2022
    public static boolean sameBsts(List<Integer> arrayOne, List<Integer> arrayTwo) {
        // Write your code here.
        if (arrayOne.size() != arrayTwo.size()) {
            return false;
        }
        return sameBstsHelper(arrayOne, arrayTwo);
    }

    private static boolean sameBstsHelper(List<Integer> arrayOne, List<Integer> arrayTwo) {
        if (arrayOne.isEmpty() && arrayTwo.isEmpty()) {
            return true;
        }

        Integer one = arrayOne.remove(0);
        Integer two = arrayTwo.remove(0);
        if (one != two) {
            return false;
        }
        List<Integer> arrayOneToLeft = getSmaller(one, arrayOne);
        List<Integer> arrayOneToRight = getLargerOrEqual(one, arrayOne);

        List<Integer> arrayTwoToLeft = getSmaller(two, arrayTwo);
        List<Integer> arrayTwoToRight = getLargerOrEqual(two, arrayTwo);

        return sameBstsHelper(arrayOneToLeft, arrayTwoToLeft)
                && sameBstsHelper(arrayOneToRight, arrayTwoToRight);
    }

    private static List<Integer> getSmaller(Integer value, List<Integer> array) {
        List<Integer> result = new ArrayList<>();
        for (Integer element : array) {
            if (element < value) {
                result.add(element);
            }
        }
        return result;
    }

    private static List<Integer> getLargerOrEqual(Integer value, List<Integer> array) {
        List<Integer> result = new ArrayList<>();
        for (Integer element : array) {
            if (element >= value) {
                result.add(element);
            }
        }
        return result;
    }


}
