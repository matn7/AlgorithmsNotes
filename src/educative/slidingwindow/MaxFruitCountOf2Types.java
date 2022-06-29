package educative.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class MaxFruitCountOf2Types {

    public static void main(String[] args) {
        System.out.println("Maximum number of fruits: " +
                MaxFruitCountOf2Types.findLength(new char[] { 'A', 'B', 'C', 'A', 'C' }));
        System.out.println("Maximum number of fruits: " +
                MaxFruitCountOf2Types.findLength(new char[] { 'A', 'B', 'C', 'B', 'B', 'C' }));
    }

    // O(n) time | O(1) space
    public static int findLength(char[] arr) {
        int windowStart = 0;
        int maxLength = 0;
        Map<Character, Integer> fruitFreqMap = new HashMap<>();

        for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
            fruitFreqMap.put(arr[windowEnd], fruitFreqMap.getOrDefault(arr[windowEnd], 0) + 1);

            while (fruitFreqMap.size() > 2) {
                fruitFreqMap.put(arr[windowStart], fruitFreqMap.get(arr[windowStart]) - 1);
                if (fruitFreqMap.get(arr[windowStart]) == 0) {
                    fruitFreqMap.remove(arr[windowStart]);
                }
                windowStart++;
            }
            maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
        }

        return maxLength;
    }

}
