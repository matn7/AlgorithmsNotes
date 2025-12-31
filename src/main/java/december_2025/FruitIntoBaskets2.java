package december_2025;

import java.util.HashMap;
import java.util.Map;

public class FruitIntoBaskets2 {

    public static void main(String[] args) {
//        int[] fruits = {1,2,3,2,2};
        int[] fruits = {0,1,2,2};
        FruitIntoBaskets2 fruitIntoBaskets2 = new FruitIntoBaskets2();
        int result = fruitIntoBaskets2.totalFruit(fruits);
        System.out.println(result);
    }

    // O(n) time | O(1) space
    public int totalFruit(int[] fruits) {
        Map<Integer, Integer> countMap = new HashMap<>();
        int left = 0;
        int right = 0;
        int numFruits = 0;

        while (right < fruits.length) {
            int fruit = fruits[right];
            countMap.put(fruit, countMap.getOrDefault(fruit, 0) + 1);

            while (countMap.size() > 2) {
                int leftF = fruits[left];
                countMap.put(leftF, countMap.get(leftF) - 1);
                if (countMap.get(leftF) == 0) {
                    countMap.remove(leftF);
                }
                left++;
            }

            numFruits = Math.max(numFruits, right - left + 1);
            right++;
        }
        return numFruits;
    }

}
