package problems.other;

import java.util.HashMap;
import java.util.Map;

// Bit manipulation
public class FindNonDuplicateNumber {
    // XOR
    // 1 ^ 1 = 0
    // 0 ^ 0 = 0
    // 1 ^ 0 = 1
    // 0 ^ 1 = 1

    // Only one value does not have duplicate
    public static void main(String[] args) {
        int[] nums = {4, 3, 2, 4, 1, 3, 2};
        FindNonDuplicateNumber findNonDuplicateNumber = new FindNonDuplicateNumber();
        int result = findNonDuplicateNumber.singleNumber(nums);
        System.out.println(result);
    }

    // ********
    // * STAR - G *
    // ********

    // O(n) time | O(1) space
    public int singleNumber(int[] nums) {
        int unique = 0;
        for (int n : nums) {
            unique ^= n;
        }
        return unique;
    }

    // O(n) time | O(n) space
    public int singleNumber2(int[] nums) {
        Map<Integer, Integer> occurrence = new HashMap<>();

        for (int n : nums) {
            if (occurrence.containsKey(n)) {
                occurrence.put(n, occurrence.get(n) + 1);
            } else {
                occurrence.put(n, 1);
            }
        }

        for (Map.Entry<Integer, Integer> num : occurrence.entrySet()) {
            if (num.getValue() == 1) {
                return num.getKey();
            }
        }
        return -1;
    }
}
