package whiteboard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PowerSet {

    public static void main(String[] args) {
        List<Integer> array = new ArrayList<>();
        array.add(1);
        array.add(2);
        array.add(3);

        List<List<Integer>> result = powerset(array);
        System.out.println();
    }

    // O(n * 2^n) time | O(n * 2^n) space
    // #2: 26/06/2022
    // rand: 22/08/2022
    public static List<List<Integer>> powerset(List<Integer> array) {
        // Write your code here.
        List<List<Integer>> result = new ArrayList<>();
        powersetHelper(array, result);

        return result;
    }

    private static void powersetHelper(List<Integer> array, List<List<Integer>> result) {
        if (array.isEmpty()) {
            result.add(new ArrayList<>());
            return;
        }
        int currentElement = array.remove(array.size() - 1);
        powersetHelper(array, result);
        int size = result.size();
        for (int idx = 0; idx < size; idx++) {
            List<Integer> currList = new ArrayList<>(result.get(idx));
            currList.add(currentElement);
            result.add(currList);
        }
    }


//    // O(n * 2^n) time | O(n * 2^n) space
//    public static List<List<Integer>> powerset(List<Integer> array) {
//        // Write your code here.
//        List<List<Integer>> result = new ArrayList<>();
//        result.add(new ArrayList<>());
//
//        for (Integer element : array) {
//            int resultSize = result.size();
//            for (int idx = 0; idx < resultSize; idx++) {
//                List<Integer> currentElement = new ArrayList<>(result.get(idx));
//                currentElement.add(element);
//                result.add(currentElement);
//            }
//        }
//
//        return result;
//    }

}
