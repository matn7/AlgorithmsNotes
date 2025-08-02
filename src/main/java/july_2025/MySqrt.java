package july_2025;

public class MySqrt {

    public static void main(String[] args) {
        int x = 2147395599;

        MySqrt mySqrt = new MySqrt();
        int result = mySqrt.mySqrt(x);
        System.out.println(result);
    }

    public int mySqrt(int x) {
        int l = 0;
        int r = x;
        int res = 0;
        while (l <= r) {
            int m = l + (r - l) / 2;
            long test = (long) m * m;
            if (test > (long) x) {
                r = m - 1;
            } else if (test < (long) x) {
                l = m + 1;
                res = m;
            } else {
                return m;
            }
        }
        return res;
    }

}
