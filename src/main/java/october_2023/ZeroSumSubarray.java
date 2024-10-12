package october_2023;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ZeroSumSubarray {

    public static void main(String[] args) {
        int[] array = {-5, -5, 2, 3, 2};
        zeroSumSubarray(array);
    }

    // O(n) time | O(n) space
    public static boolean zeroSumSubarray(int[] array) {

        Set<Integer> seen = new HashSet<>();
        seen.add(0);
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
            if (seen.contains(sum)) {
                return true;
            }
            seen.add(sum);
        }

        return false;
    }

}
