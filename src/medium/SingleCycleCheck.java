package medium;

import java.util.HashMap;
import java.util.Map;

public class SingleCycleCheck {

    public static void main(String[] args) {

//        int[] array = {1, 1, 1, 1, 2};
//        int[] array = {2, 3, 1, -4, -4, 2};
        int[] array = {10, 11, -6, -23, -2, 3, 88, 908, -26};
//                      [10, 11, -6, -23, -2, 3, 88, 909, -26]

        boolean result = hasSingleCycle(array);
        System.out.println(result);
    }

    public static boolean hasSingleCycle(int[] array) {
        int counter = 0;
        boolean[] visited = new boolean[array.length];
        int start = 0;
        int currentIndex = 0;
        Map<Integer, Integer> visitedTimes = new HashMap<>();
        int currentValue;

        // prepare array if element value exceeds size
        int[] arrayMod = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            arrayMod[i] = array[i] % array.length;
        }

        while (counter < arrayMod.length) {
            currentValue = arrayMod[currentIndex];
            if (start + currentValue >= 0 && start + arrayMod[currentIndex] < arrayMod.length) {
                start = start + currentValue;
            } else {
                // out of bound
                int left = start + currentValue; // 3 + (-4), 5 + 2 = 7
                if (left < 0) {
                    start = arrayMod.length + left; // 5
                } else {
                    start = left - arrayMod.length; // 7 - 6
                }
            }
            visited[currentIndex] = true;
            if (visitedTimes.containsKey(currentIndex)) {
                visitedTimes.put(currentIndex, visitedTimes.get(currentIndex) + 1);
            } else {
                visitedTimes.put(currentIndex, 1);
            }
            currentIndex = Math.abs(start);
            counter++;
        }


        for (boolean element : visited) {
            if (!element) {
                return false;
            }
        }

        return currentIndex == 0;
    }

}
