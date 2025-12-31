package december_2025;

import java.util.HashMap;
import java.util.Map;

public class FruitIntoBasket {

    public static void main(String[] args) {
        // int[] fruits = {1,2,3,2,2};
        int[] fruits = {3,3,3,1,2,1,1,2,3,3,4};

        FruitIntoBasket fruitIntoBasket = new FruitIntoBasket();
        int result = fruitIntoBasket.totalFruit(fruits);
        System.out.println(result);
    }

    // O(n) time | O(1) space - max two types of fruit
    public int totalFruit(int[] fruits) {
        Map<Integer, Integer> count = new HashMap<>();
        int left = 0;
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
