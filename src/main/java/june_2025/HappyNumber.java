package june_2025;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {

    public static void main(String[] args) {
        int n = 2;
        HappyNumber happyNumber = new HappyNumber();
        boolean result = happyNumber.isHappy(n);
        System.out.println(result);
    }

    // O(log(n)) time | O(log(n)) space
    public boolean isHappy(int n) {

        Set<Integer> seen = new HashSet<>();
        seen.add(n);
        int sum = 0;
        int x = n;
        while (sum != 1) {
            sum = 0;
            while (x != 0) {
                int digit = x % 10;
                sum = sum + digit * digit;
                x = x / 10;
            }
            if (seen.contains(sum)) {
                return false;
            }
            seen.add(sum);
            x = sum;
        }
        return true;
    }

}
