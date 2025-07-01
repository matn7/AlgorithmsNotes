package june_2025;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber2 {

    public static void main(String[] args) {
        int n = 2;

        HappyNumber2 happyNumber2 = new HappyNumber2();
        boolean result = happyNumber2.isHappy(n);
        System.out.println(result);
    }

    // O(log(n)) time | O(log(n)) space
    public boolean isHappy(int n) {
        Set<Integer> calculated = new HashSet<>();

        while (n != 1) {
            int sum = 0;
            int x = n;
            while (x > 0) {
                int digit = x % 10;
                x = x / 10;
                sum += digit * digit;
            }
            n = sum;
            if (calculated.contains(n)) {
                return false;
            }
            calculated.add(n);
        }
        return true;
    }

}
