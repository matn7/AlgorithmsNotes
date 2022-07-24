package whiteboard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FourNumberSumRand {

    public static List<Integer[]> fourNumberSum(int[] array, int targetSum) {
        // Write your code here.
        Map<Integer, List<Integer[]>> pairSums = new HashMap<>();
        List<Integer[]> result = new ArrayList<>();

        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                int iNum = array[i];
                int jNum = array[j];
                int key = targetSum - (iNum + jNum);
                if (pairSums.containsKey(key)) {
                    List<Integer[]> pairs = pairSums.get(key);
                    for (Integer[] pair : pairs) {
                        result.add(new Integer[]{ iNum, jNum, pair[0], pair[1] });
                    }
                }
            }

            // k chasing i
            for (int k = 0; k < i; k++) {
                int kNum = array[k];
                int iNum = array[i];
                int key = kNum + iNum;
                if (pairSums.containsKey(key)) {
                    List<Integer[]> pairs = pairSums.get(key);
                    pairs.add(new Integer[]{ kNum, iNum });
                    pairSums.remove(key);
                    pairSums.put(key, pairs);
                } else {
                    List<Integer[]> pairs = new ArrayList<>();
                    pairs.add(new Integer[]{ kNum, iNum });
                    pairSums.put(key, pairs);
                }

            }
        }

        return result;
    }

}
