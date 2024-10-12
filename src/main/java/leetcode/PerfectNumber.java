package leetcode;

import java.util.ArrayList;
import java.util.List;

public class PerfectNumber {

    // O(n) time | O(n) space
    public boolean checkPerfectNumber(int num) {
        if (num < 0) {
            return false;
        }
        List<Integer> factors = new ArrayList<>();
        for (int i = 1; i < Math.pow(num, 0.5); i++) {
            if (num % i == 0) {
                factors.add(i);
                factors.add(num / i);

            }
        }
        int sum = 0;
        if (!factors.isEmpty()) {
            for (Integer element : factors) {
                sum += element;
            }
            int res = sum - num;
            return res == num;
        }
        return false;
    }

}
