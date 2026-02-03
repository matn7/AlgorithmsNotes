package january_2026;


import java.util.HashMap;
import java.util.Map;

public class FruitIntoBaskets {

    public static void main(String[] args) {
        int[] fruits = {1,2,3,2,2};

        FruitIntoBaskets fruitIntoBaskets = new FruitIntoBaskets();
        int result = fruitIntoBaskets.totalFruit(fruits);
        System.out.println(result);
    }

    // O(n) time | O(n) space
    public int totalFruit(int[] fruits) {
        int left = 0;
        Map<Integer, Integer> countsMap = new HashMap<>();
        int maxLen = 0;

        for (int right = 0; right < fruits.length; right++) {
            countsMap.put(fruits[right], countsMap.getOrDefault(fruits[right], 0) + 1);
            while (countsMap.size() > 2) {
                int leftFruit = fruits[left];
                countsMap.put(leftFruit, countsMap.get(leftFruit) - 1);
                if (countsMap.get(leftFruit) == 0) {
                    countsMap.remove(leftFruit);
                }
                left++;
            }
            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }


}
