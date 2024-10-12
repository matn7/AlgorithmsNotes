package march_2024;

import java.util.HashMap;
import java.util.Map;

public class MissingNumbers {

    public static void main(String[] args) {
        int[] numbers = {3, 2, 1, 0};
        System.out.println(missingNumber(numbers));
        System.out.println(missingNumber2(numbers));
        System.out.println(missingNumber3(numbers));
    }

    // O(n) time | O(n) space
    public static int missingNumber(int[] numbers) {
        Map<Integer, Boolean> presentNumbersMap = new HashMap<>();
        for (int num : numbers) {
            presentNumbersMap.put(num, true);
        }

        for (int i = 0; i < numbers.length + 1; i++) {
            if (!presentNumbersMap.containsKey(i)) {
                return i;
            }
        }
        return -1;
    }

    // O(n) time | O(n) space
    public static int missingNumber2(int[] numbers) {
        int num = 0;

        for (int i = 0; i <= numbers.length; i++) {
            num ^= i;
        }
        return num;
    }

    // O(n) time | O(1) space
    public static int missingNumber3(int[] numbers) {
        int n = numbers.length;
        int intendedSum = n * (n + 1) / 2;
        int actualSum = 0;
        for (int num : numbers) {
            actualSum += num;
        }

        return intendedSum - actualSum;
    }

}
