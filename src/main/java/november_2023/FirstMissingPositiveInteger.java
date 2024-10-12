package november_2023;

import java.util.HashSet;
import java.util.Set;

public class FirstMissingPositiveInteger {

    public static void main(String[] args) {
        int[] arr = {3, 4, -1, 1};

        int result = firstMissing(arr);
        System.out.println(result);
    }

    // O(n) time | O(n) space
    public static int firstMissing(int[] arr) {
        Set<Integer> elements = new HashSet<>();
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int num : arr) {
            if (num < 0) {
                continue;
            }
            elements.add(num);
            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        for (int i = min; i <= max; i++) {
            if (!elements.contains(i)) {
                return i;
            }
        }
        return -1;
    }

}
