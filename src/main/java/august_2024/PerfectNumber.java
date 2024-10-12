package august_2024;

import java.util.ArrayList;
import java.util.List;

public class PerfectNumber {

    public static void main(String[] args) {
        int num = 28;

        boolean result = perfectNumber(num);
        System.out.println(result);
    }

    // O(n) time | O(n) space
    public static boolean perfectNumber(int num) {
        if (num <= 0) {
            return false;
        }

        List<Integer> divisors = new ArrayList<>();

        for (int i = 1; i <= num / 2; i++) {
            if (num % i == 0) {
                divisors.add(i);
            }
        }
        int sum = 0;
        for (Integer div : divisors) {
            sum += div;
        }

        return sum == num;
    }

}
