package may_2024;

import java.util.ArrayList;
import java.util.List;

public class PerfectNumber {

    public static void main(String[] args) {
        int number = 28;

        for (int i = 1; i < 10000; i++) {
            if (perfectNumber(i)) {
                System.out.println(i + " isPerfectNumber: " + perfectNumber(i));
            }
        }
    }

    public static boolean perfectNumber(int number) {
        if (number <= 0) {
            return false;
        }
        // 28
        List<Integer> divisors = new ArrayList<>();
        for (int i = 1; i <= number / 2; i++) {
            if (number % i == 0) {
                divisors.add(i);
            }
        }
        int sum = 0;
        for (Integer div : divisors) {
            sum += div;
        }
        return sum == number;
    }

}
