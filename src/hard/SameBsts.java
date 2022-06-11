package hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SameBsts {

    public static void main(String[] args) {

//        List<Integer> arrayOne =
//                new ArrayList<>(Arrays.asList(10, 15, 8, 12, 94, 81, 5, 2, 11));
//        List<Integer> arrayTwo =
//                new ArrayList<>(Arrays.asList(10, 8, 5, 15, 2, 12, 11, 94, 81));

        List<Integer> arrayOne =
                new ArrayList<>(Arrays.asList(10, 15, 8, 12, 94, 81, 5, 2, -1, 101, 45, 12, 8, -1, 8, 2, -34));
        List<Integer> arrayTwo =
                new ArrayList<>(Arrays.asList(10, 8, 5, 15, 2, 12, 94, 81, -1, -1, -34, 8, 2, 8, 12, 45, 100));

        boolean result = sameBsts(arrayOne, arrayTwo);
        System.out.println(result);
    }

    public static boolean sameBsts(List<Integer> arrayOne, List<Integer> arrayTwo) {

        if (arrayOne.get(0) != arrayTwo.get(0)) {
            return false;
        }

        if (arrayOne.size() != arrayTwo.size()) {
            return false;
        }

        List<Boolean> results = new ArrayList<>();
        sameBstsHelper(arrayOne, arrayTwo, results);

        for (Boolean element : results) {
            if (!element) {
                return false;
            }
        }
        return true;

    }

    private static boolean sameBstsHelper(List<Integer> arrayOne, List<Integer> arrayTwo, List<Boolean> results) {
        // Write your code here.
        if (arrayOne.size() == 1 && arrayTwo.size() == 1 && arrayOne.get(0) == arrayTwo.get(0)) {
            return true;
        }
        if (arrayOne == null && arrayTwo == null) {
            return true;
        }
        if (arrayOne.get(0) != arrayTwo.get(0)) {
            return false;
        }

        Integer rootElement = arrayOne.remove(0);
        arrayTwo.remove(0);

        List<Integer> arrayOneLeft = new ArrayList<>();
        List<Integer> arrayOneRight = new ArrayList<>();

        for (Integer element : arrayOne) {
            if (element >= rootElement) {
                arrayOneRight.add(element);
            } else {
                arrayOneLeft.add(element);
            }
        }

        List<Integer> arrayTwoLeft = new ArrayList<>();
        List<Integer> arrayTwoRight = new ArrayList<>();

        for (Integer element : arrayTwo) {
            if (element >= rootElement) {
                arrayTwoRight.add(element);
            } else {
                arrayTwoLeft.add(element);
            }
        }

        if (!arrayOneLeft.isEmpty() && !arrayTwoLeft.isEmpty()) {
            if (arrayOneLeft.get(0) == arrayTwoLeft.get(0)) {
                results.add(true);
                sameBstsHelper(arrayOneLeft, arrayTwoLeft, results);
            } else {
                results.add(false);
                return false;
            }
        }

        if (!arrayOneRight.isEmpty() && !arrayTwoRight.isEmpty()) {
            if (arrayOneRight.get(0) == arrayTwoRight.get(0)) {
                results.add(true);
                sameBstsHelper(arrayOneRight, arrayTwoRight, results);
            } else {
                results.add(false);
                return false;
            }
        }

        return true;
    }
}
