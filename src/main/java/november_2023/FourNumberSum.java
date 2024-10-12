package november_2023;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FourNumberSum {

    public static void main(String[] args) {
        int[] arr = {7, 6, 4, -1, 1, 2};
        int targetSum = 16;

        fourNumberSum(arr, targetSum);
    }

    // O(n^2) time | O(n^2) space
    public static List<Integer[]> fourNumberSum(int[] arr, int targetSum) {
        List<Integer[]> result = new ArrayList<>();
        Map<Integer, List<Integer[]>> sumsMap = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                int a = arr[i];
                int b = arr[j];
                int sum = a + b;
                int key = targetSum - sum;
                if (sumsMap.containsKey(key)) {
                    List<Integer[]> sums = sumsMap.get(key);
                    for (Integer[] element : sums) {
                        result.add(new Integer[] {a, b, element[0], element[1]});
                    }
                }
            }

            for (int k = 0; k < i; k++) {
                int c = arr[k];
                int d = arr[i];
                int key = c + d;
                if (sumsMap.containsKey(key)) {
                    List<Integer[]> sums = sumsMap.get(key);
                    sums.add(new Integer[] {c, d});
                    sumsMap.put(key, sums);
                } else {
                    List<Integer[]> sums = new ArrayList<>();
                    sums.add(new Integer[]{c, d});
                    sumsMap.put(key, sums);
                }
            }
        }

        return result;
    }

}
