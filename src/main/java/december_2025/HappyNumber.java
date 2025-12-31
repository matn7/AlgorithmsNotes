package december_2025;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {

    public static void main(String[] args) {
        int n = 2;
        HappyNumber happyNumber = new HappyNumber();
        boolean result = happyNumber.isHappy(n);
        System.out.println(result);
    }

    // O(log(n)) time | O(1) space
    public boolean isHappy(int n) {
        if (n == 1) {
            return true;
        }
        int slow = n;
        int fast = n;
        while (true) {
            slow = getNextNum(slow);
            fast = getNextNum(getNextNum(fast));

            if (fast == 1) {
                return true;
            }

            if (fast == slow) {
                return false;
            }
        }
    }

    private int getNextNum(int n) {
        int newNum = 0;
        while (n > 0) {
            int curr = n % 10;
            newNum += curr * curr;
            n = n / 10;
        }
        return newNum;
    }

}
