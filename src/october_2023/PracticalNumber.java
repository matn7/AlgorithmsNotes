package october_2023;

import java.util.ArrayList;
import java.util.List;

public class PracticalNumber {

    public static void main(String[] args) {
        int n = 18;

        isPracticalNum(n);
    }

    // O(n) time | O(n) space
    public static boolean isPracticalNum(int n) {
        List<Integer> divisors = new ArrayList<>();
        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                divisors.add(i);
                if (i != n/i) {
                    divisors.add(n/i);
                }
            }
        }

        boolean[] canBeSummed = new boolean[n + 1];
        canBeSummed[0] = true;

        for (int divisor : divisors) {
            for (int i = divisor; i <= n; i++) {
                canBeSummed[i] = canBeSummed[i] || canBeSummed[i - divisor];
            }
        }

        for (int i = 1; i < n; i++) {
            if (!canBeSummed[i]) {
                return false;
            }
        }

        return true;
    }

}
