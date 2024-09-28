package july_2024;

import java.util.HashMap;
import java.util.Map;

public class FactorialV2 {

    public static void main(String[] args) {
        // 5! = 5 * 4! = 5 * 4 * 3!

        int factorial = factorial(5);
        System.out.println(factorial);

        int factorial2 = factorialMemo(5);
        System.out.println(factorial2);

        int factorial3 = factorialTailRecursion(5);
        System.out.println(factorial3);

        int factorial4 = factorialIter(5);
        System.out.println(factorial4);
    }

    // O(n) time | O(n) space
    public static int factorial(int number) {
        if (number == 0) {
            return 1;
        }
        return number * factorial(number - 1);
    }

    // O(n) time | O(n) space
    public static int factorialMemo(int number) {
        Map<Integer, Integer> memo = new HashMap<>();
        memo.put(0, 1);
        memo.put(1, 1);
        return factorialMemoHelper(number, memo);
    }

    private static int factorialMemoHelper(int number, Map<Integer, Integer> memo) {
        if (memo.containsKey(number)) {
            return memo.get(number);
        }
        memo.put(number, number * factorialMemoHelper(number - 1, memo));
        return memo.get(number);
    }

    // O(n) time | O(1) space
    public static int factorialTailRecursion(int number) {
        int result = factorialTailRecursionHelper(number, 1);
        return result;
    }

    private static int factorialTailRecursionHelper(int number, int result) {
        if (number == 0) {
            return result;
        }
        return factorialTailRecursionHelper(number - 1, result * number);
    }

    // O(n) time | O(1) space
    public static int factorialIter(int number) {
        int result = 1;

        for (int n = 1; n < number + 1; n++) {
            result *= n;
        }

        return result;
    }

}
