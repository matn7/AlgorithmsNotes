package november_2023;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;

public class SameBsts {

    public static void main(String[] args) {

        int[] one = {10, 15, 8, 12, 94, 81, 5, 2, 11};
        int[] two = {10, 8, 5, 15, 2, 12, 11, 94, 81};

        List<Integer> arrayOne = new ArrayList<>();
        List<Integer> arrayTwo = new ArrayList<>();
        for (int num : one) {
            arrayOne.add(num);
        }
        for (int num : two) {
            arrayTwo.add(num);
        }

        boolean result = sameBsts(arrayOne, arrayTwo);
        System.out.println(result);
    }

    // O(n^2) time | O(n^2) space
    public static boolean sameBsts(List<Integer> arrayOne, List<Integer> arrayTwo) {
        if (arrayOne.size() != arrayTwo.size()) {
            return false;
        }
        return sameBstsHelper(arrayOne, arrayTwo);
    }

    private static boolean sameBstsHelper(List<Integer> arrayOne, List<Integer> arrayTwo) {
        if (arrayOne.isEmpty() && arrayTwo.isEmpty()) {
            return true;
        }
        Integer valueOne = arrayOne.remove(0);
        Integer valueTwo = arrayTwo.remove(0);
        if (valueOne != valueTwo) {
            return false;
        }
        List<Integer> smallerOne = getValues(arrayOne, a -> a < valueOne);
        List<Integer> largerOne = getValues(arrayOne, a -> a > valueOne);
        List<Integer> smallerTwo = getValues(arrayTwo, a -> a < valueTwo);
        List<Integer> largerTwo = getValues(arrayTwo, a -> a > valueTwo);

        boolean smallerEquals = sameBstsHelper(smallerOne, smallerTwo);
        boolean largerEquals = sameBsts(largerOne, largerTwo);
        return smallerEquals && largerEquals;
    }

    private static List<Integer> getValues(List<Integer> array, Predicate<Integer> predicate) {
        List<Integer> result = new ArrayList<>();
        for (Integer num : array) {
            if (predicate.test(num)) {
                result.add(num);
            }
        }
        return result;
    }

}
