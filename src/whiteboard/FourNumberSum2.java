package whiteboard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FourNumberSum2 {

    public static void main(String[] args) {
        int[] array = {7, 6, 4, -1, 1, 2};
        fourNumberSum(array, 16);
    }

    // Average: O(n^2) time | O(n^2) space
    // Worst: O(n^3) time | O(n^2)
    public static List<Integer[]> fourNumberSum(int[] array, int targetSum) {
        // Write your code here.
        List<Integer[]> result = new ArrayList<>();
        Map<Integer, List<Integer[]>> pairsMap = new HashMap<>();
        for (int i = 1; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                int leftNum = array[i];
                int rightNum = array[j];
                int numsSum = leftNum + rightNum;
                int key = targetSum - numsSum;
                if (pairsMap.containsKey(key)) {
                    List<Integer[]> pairs = pairsMap.get(key);
                    for (Integer[] pair : pairs) {
                        result.add(new Integer[] {leftNum, rightNum, pair[0], pair[1]});
                    }
                }
            }

            for (int k = 0; k < i; k++) {
                int element = array[i];
                int element2 = array[k];
                int key = element + element2;
                if (pairsMap.containsKey(key)) {
                    List<Integer[]> pairs = pairsMap.get(key);
                    pairs.add(new Integer[] {element, element2});
                    pairsMap.remove(key);
                    pairsMap.put(key, pairs);
                } else {
                    List<Integer[]> pair = new ArrayList<>();
                    pair.add(new Integer[] {element, element2});
                    pairsMap.put(key, pair);
                }
            }
        }

        return result;
    }

}
