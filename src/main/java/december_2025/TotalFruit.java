package december_2025;

import java.util.HashMap;
import java.util.Map;

public class TotalFruit {

    public static void main(String[] args) {
        int[] fruits = {1,2,3,2,2};

        TotalFruit totalFruit = new TotalFruit();
        int result = totalFruit.totalFruit(fruits);
        System.out.println(result);
    }

    // O(n) time | O(1) space
    public int totalFruit(int[] fruits) {
        int left = 0;
        Map<Integer, Integer> count = new HashMap<>();
        int maxLen = 0;

        for (int right = 0; right < fruits.length; right++) {
            count.put(fruits[right], count.getOrDefault(fruits[right], 0) + 1);

            while (count.size() > 2) {
                int leftFruit = fruits[left];
                count.put(leftFruit, count.get(leftFruit) - 1);
                if (count.get(leftFruit) == 0) {
                    count.remove(leftFruit);
                }
                left++;
            }

            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }



}
