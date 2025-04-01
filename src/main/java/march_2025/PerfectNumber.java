package march_2025;

import java.util.ArrayList;
import java.util.List;

public class PerfectNumber {

    public static void main(String[] args) {
        int num = 28;

        PerfectNumber perfectNumber = new PerfectNumber();
        boolean result = perfectNumber.checkPerfectNumber(num);
        System.out.println(result);
    }

    // O(n) time | O(n) space
    public boolean checkPerfectNumber(int num) {
        List<Integer> divisors = new ArrayList<>();

        for (int i = 1; i <= num / 2; i++) {
            if (num % i == 0) {
                divisors.add(i);
            }
        }
        int sum = 0;
        for (int d : divisors) {
            sum += d;
        }
        return sum == num;
    }

}
