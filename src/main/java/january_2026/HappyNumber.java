package january_2026;

public class HappyNumber {

    public static void main(String[] args) {
        int n = 2;
        HappyNumber happyNumber = new HappyNumber();
        boolean result = happyNumber.isHappy(n);
        System.out.println(result);
    }

    // O(n) time | O(1) space
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

            if (slow == fast) {
                return false;
            }
        }
    }

    private int getNextNum(int n) {
        int sum = 0;
        while (n > 0) {
            int part = n % 10;
            sum += part * part;
            n = n / 10;
        }
        return sum;
    }

}
