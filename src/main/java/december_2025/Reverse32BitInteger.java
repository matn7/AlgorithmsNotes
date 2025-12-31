package december_2025;

public class Reverse32BitInteger {

    // O(log(n)) time | O(1) space
    public int reverse(int x) {
        boolean negative = false;
        if (x < 0) {
            negative = true;
            x = x * -1;
        }

        long res = 0;
        while (x > 0) {
            int curr = x % 10;
            res = 10 * res + curr;
            if (res > Integer.MAX_VALUE) {
                return 0;
            }
            x = x / 10;
        }
        return (int) (negative ? -1 * res : res);
    }

}
