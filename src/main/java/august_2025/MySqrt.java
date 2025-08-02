package august_2025;

public class MySqrt {

    public static void main(String[] args) {
        int x = 8;

        MySqrt mySqrt = new MySqrt();
        int result = mySqrt.mySqrt(x);
        System.out.println(result);
    }

    // O(log(n)) time | O(1) space
    public int mySqrt(int x) {
        int l = 0;
        int r = x;
        int res = 0;

        while (l <= r) {
            int m = l + (r - l) / 2;
            long test = (long) m * m;
            if (test == x) {
                return m;
            } else if (test > x) {
                r = m - 1;
            } else {
                res = m;
                l = m + 1;
            }
        }
        return res;
    }

}
