package december_2024;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class HappyNumber2 {

    public static void main(String[] args) {
        int n = 18;

        HappyNumber2 happyNumber = new HappyNumber2();
        boolean result = happyNumber.isHappy(n);
        System.out.println(result);
    }

    // O(log(n)) time | O(1) space
    public boolean isHappy(int n) {
        int sum = 0;
        Set<Integer> seen = new HashSet<>();
        while (n > 0) {
            int temp = n;
            while (temp > 0) {
                int c = temp % 10;
                sum += c*c;
                temp = temp / 10;
            }
            if (sum == 1) {
                return true;
            }
            if (seen.contains(sum)) {
                return false;
            }
            seen.add(sum);
            n = sum;
            sum = 0;
        }
        return false;
    }

}
