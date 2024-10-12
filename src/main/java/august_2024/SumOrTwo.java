package august_2024;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SumOrTwo {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(sumOfTwo(new int[] {1, 2, 3, 5}, 4)));
        System.out.println(Arrays.toString(sumOfTwo(new int[] {7, 7, 4, 3, 8}, 7)));
        System.out.println(Arrays.toString(sumOfTwo(new int[] {13, 43, 2, 71}, 84)));
        System.out.println(Arrays.toString(sumOfTwo(new int[] {1, 2, 3, 5}, 100)));
    }

    public static int[] sumOfTwo(int[] arr, int target) {
        Map<Integer, Boolean> sumsMap = new HashMap<>();
        // {1: true, 2: true}

        // arr = [1, 2, 3, 5], target = 4
        //              *

        for (int num : arr) {
            int key = target - num; // 4 - 3
            if (sumsMap.containsKey(key)) {
                return new int[] {key, num};
            } else {
                sumsMap.put(num, true);
            }
        }

        return new int[] {0, 0};
    }

}
