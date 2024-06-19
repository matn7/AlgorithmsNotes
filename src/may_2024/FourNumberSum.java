package may_2024;

import java.util.*;

public class FourNumberSum {

    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>(Arrays.asList(7, 6, 4, -1, 1, 2));
        int targetSum = 16;

        List<Integer[]> integers = fourNumberSum(numbers, targetSum);
        System.out.println(integers);
    }

    // O(n^2) time | O(n^2) space
    public static List<Integer[]> fourNumberSum(List<Integer> numbers, int targetSum) {
        if (numbers.size() < 4) {
            return null;
        }
        List<Integer[]> result = new ArrayList<>();
        Map<Integer, List<Integer[]>> sumsMap = new HashMap<>();

        for (int i = 0; i < numbers.size(); i++) {
            for (int j = i + 1; j < numbers.size(); j++) {
                int a = numbers.get(i);
                int b = numbers.get(j);
                int key = targetSum - a - b;
                if (sumsMap.containsKey(key)) {
                    List<Integer[]> pairs = sumsMap.get(key);
                    for (Integer[] pair : pairs) {
                        Integer[] oneResult = new Integer[] {a, b, pair[0], pair[1]};
                        result.add(oneResult);
                    }
                }
            }
            for (int k = 0; k < i; k++) {
                int a = numbers.get(i);
                int c = numbers.get(k);
                int key = a + c;
                if (sumsMap.containsKey(key)) {
                    List<Integer[]> pairs = sumsMap.get(key);
                    pairs.add(new Integer[]{a, c});
                    sumsMap.put(key, pairs);
                } else {
                    List<Integer[]> pairs = new ArrayList<>();
                    pairs.add(new Integer[]{a, c});
                    sumsMap.put(key, pairs);
                }
            }
        }

        return result;
    }

}
