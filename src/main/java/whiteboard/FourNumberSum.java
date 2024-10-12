package whiteboard;

import java.util.*;

public class FourNumberSum {

    public static void main(String[] args) {
        int[] array = {7, 6, 4, -1, 1, 2};

        List<Integer[]> result = fourNumberSum(array, 16);
        System.out.println();
    }

    // O(n^2) time | O(n^2) space
    // #2: 22/06/2022
    // rand: 17/07/2022
    public static List<Integer[]> fourNumberSum(int[] array, int targetSum) {
        // Write your code here.
        if (array.length < 4) {
            return new ArrayList<>();
        }

//        Arrays.sort(array); // todo: maybe not needed

        List<Integer[]> result = new ArrayList<>();
        Map<Integer, List<Integer[]>> pairMap = new HashMap<>();

        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                int iVal = array[i];
                int jVal = array[j];
                int sum = iVal + jVal;
                int diffKey = targetSum - sum;
                if (pairMap.containsKey(diffKey)) {
                    List<Integer[]> pairs = pairMap.get(diffKey);
                    for (Integer[] pair : pairs) {
                        Integer[] oneResult = new Integer[] {iVal, jVal, pair[0], pair[1]};
                        result.add(oneResult);
                    }

                }
            }

            // k chasing i, add stuff already visited by j
            for (int k = 0; k < i; k++) {
                int kVal = array[k];
                int iVal = array[i];
                int sumKey = kVal + iVal;
                if (pairMap.containsKey(sumKey)) {
                    List<Integer[]> currList = pairMap.get(sumKey);
                    currList.add(new Integer[]{kVal, iVal});
                    pairMap.remove(sumKey);
                    pairMap.put(sumKey, currList);
                } else {
                    List<Integer[]> valueList = new ArrayList<>();
                    valueList.add(new Integer[]{kVal, iVal});
                    pairMap.put(sumKey, valueList);
                }
            }
        }
        return result;
    }

}
