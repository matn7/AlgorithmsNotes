package august_2024;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class SameBsts {

    public static void main(String[] args) {
        List<Integer> arrayOne = new ArrayList<>(Arrays.asList(10, 15, 8, 12, 94, 81, 5, 2, 11));
        List<Integer> arrayTwo = new ArrayList<>(Arrays.asList(10, 8, 5, 15, 2, 12, 11, 94, 81));

        boolean result = sameBsts(arrayOne, arrayTwo);
        System.out.println(result);
    }

    // O(n^2) time | O(n^2) space
    public static boolean sameBsts(List<Integer> arrOne, List<Integer> arrTwo) {
        if (arrOne.isEmpty() && arrTwo.isEmpty()) {
            return true;
        }
        if (arrOne.size() != arrTwo.size()) {
            return false;
        }
        if (arrOne.get(0) != arrTwo.get(0)) {
            return false;
        }
        Integer value = arrOne.get(0);
        List<Integer> arrOneSmaller = getElements(arrOne, a -> a < value);
        List<Integer> arrTwoSmaller = getElements(arrTwo, a -> a < value);

        List<Integer> arrOneBigger = getElements(arrOne, a -> a > value);
        List<Integer> arrTwoBigger = getElements(arrTwo, a -> a > value);

        return sameBsts(arrOneSmaller, arrTwoSmaller) && sameBsts(arrOneBigger, arrTwoBigger);

    }

    private static List<Integer> getElements(List<Integer> arr, Predicate<Integer> fn) {
        List<Integer> result = new ArrayList<>();
        for (int num : arr) {
            if (fn.test(num)) {
                result.add(num);
            }
        }
        return result;
    }

}
