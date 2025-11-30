package november_2025;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {

    public static void main(String[] args) {
        HappyNumber happyNumber = new HappyNumber();
        int n = 19;
        boolean result = happyNumber.isHappy(n);
        System.out.println(result);
    }

    // O(log(n)) time | O(log(n)) space
    public boolean isHappy(int n) {

        int slow = n;
        int fast = n;

        while (true) {
            slow = getNextNum(slow);
            fast = getNextNum(getNextNum(fast));

            if (fast == 1) {
                return true;
            }

            if (slow == fast) {
                return false;
            }

        }
    }

    private int getNextNum(int x) {
        int next_num = 0;

        while (x > 0) {
            int digit = x % 10;
            x = x / 10;
            next_num += digit * digit;
        }

        return next_num;
    }

}
