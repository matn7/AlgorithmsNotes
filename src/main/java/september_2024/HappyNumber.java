package september_2024;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {

    public static void main(String[] args) {
        HappyNumber happyNumber = new HappyNumber();
        boolean result = happyNumber.isHappy(2);
        System.out.println(result);
    }

    // O(n) time | O(n) space
    public boolean isHappy(int n) {
        Set<Integer> seen = new HashSet<>();
        while (n >= 1) {
            if (seen.contains(n)) {
                return false;
            }
            seen.add(n);
            if (n == 1) {
                return true;
            }
            int sum = 0;
            while (n >= 1) {
                int num = n % 10;
                sum += num * num;
                n = n / 10;
            }
            n = sum;
        }
        return false;
    }

    public boolean isHappy2(int n) {
        Set<Integer> seen = new HashSet<>();
        while (n >= 1) {
            if (seen.contains(n)) {
                return false;
            }
            seen.add(n);
            int sum = 0;
            if (n == 1) {
                return true;
            }
            String str = String.valueOf(n);
            for (int i = 0; i < str.length(); i++) {
                int numericValue = Character.getNumericValue(str.charAt(i));
                sum += numericValue * numericValue;
            }
            n = sum;
        }
        return false;
    }

}
