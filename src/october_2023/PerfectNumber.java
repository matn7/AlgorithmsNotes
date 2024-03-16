package october_2023;

import java.util.ArrayList;
import java.util.List;

public class PerfectNumber {

    public static void main(String[] args) {
        int num = 28;

        System.out.println(checkPerfectNumber(num));
    }

    // O(n) time | O(n) space
    public static boolean checkPerfectNumber(int num) {
        if (num < 0) {
            return false;
        }
        List<Integer> factors = new ArrayList<>();
        for (int i = 1; i < Math.sqrt(num); i++) {
            if (num % i == 0) {
                factors.add(i);
                factors.add(num / i);
            }
        }

        int sum = 0;
        if (!factors.isEmpty()) {
            for (Integer elem : factors) {
                sum += elem;
            }
            int res = sum - num;
            return res == num;
        }
        return false;
    }

}
