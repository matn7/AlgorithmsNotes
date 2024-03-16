package september_2023;

import java.util.HashSet;
import java.util.Set;

public class FirstDuplicate {

    public static void main(String[] args) {
        int[] array = {2, 1, 5, 2, 3, 3, 2, 4};
        FirstDuplicate firstDuplicate = new FirstDuplicate();
        firstDuplicate.firstDuplicateValue(array);
    }

    // O(n) time | O(1) space
    public int firstDuplicateValue(int[] array) {
        //  0   1   2  3  4   5  6  7
        // [2, -1, -5, 2, 3, -3, 2, 4]
        //
        //             *
        for (int i = 0; i < array.length; i++) {
            int curr = Math.abs(array[i]) - 1; // 2
            if (array[curr] < 0) {
                return Math.abs(array[i]);
            }
            array[curr] *= -1;
        }
        return -1;
    }

    // O(n) time | O(n) space
    public int firstDuplicateValue1(int[] array) {
        Set<Integer> seen = new HashSet<>();
        for (int i = 0; i < array.length; i++) {
            int curr = array[i];
            if (seen.contains(curr)) {
                return array[i];
            }
            seen.add(curr);
        }
        return -1;
    }

    // O(n^2) time | O(1) space
    public int firstDuplicateValue2(int[] array) {
        // Write your code here.
        int minimumIndex = array.length;

        for (int i = 0; i < array.length; i++) {
            int curr = array[i];
            for (int j = i + 1; j < array.length; j++) {
                int other = array[j];
                if (curr == other) {
                    minimumIndex = Math.min(minimumIndex, j);
                }
            }
        }
        if (minimumIndex == array.length) {
            return -1;
        }
        return array[minimumIndex];
    }
}
