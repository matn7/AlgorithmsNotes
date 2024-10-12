package august_2024;

import java.util.ArrayList;
import java.util.List;

public class PerfectNumberV2 {

    public static void main(String[] args) {
        int num = 28;

        System.out.println(isPerfectNumber(num));

        for (int i = 0; i < 10000; i++) {
            if (isPerfectNumber(i)) {
                System.out.println(i + " is perfect num");
            }
        }
    }

    // O(n) time | O(n) space
    public static boolean isPerfectNumber(int num) {
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
        for (Integer d : divisors) {
            sum += d;
        }
        return sum == num;
    }

}
