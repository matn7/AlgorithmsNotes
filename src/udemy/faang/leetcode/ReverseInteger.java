package udemy.faang.leetcode;

public class ReverseInteger {

    public static void main(String[] args) {
        ReverseInteger reverseInteger = new ReverseInteger();
        int result = reverseInteger.reverse(1534236469);
        System.out.println(result);
//        reverseInteger.reverse(120);
    }

    public int reverse(int x) {
        boolean isNegative = x < 0;
        if (isNegative) {
            x = x * -1;
        }
        int counter = 0;
        int res = 0;
        int decimal = 10;
        int pow = String.valueOf(x).length();
        int div = pow - 1;

        for (int p = pow; p >= 1; p--) {
            int mod = (int) Math.pow(decimal, p);
            int denom = (int) Math.pow(decimal, div);
            int value = (x % mod) / denom;
            value *= Math.pow(decimal, counter);
            long test = (long) res + value;
            if (test > Integer.MAX_VALUE || test < Integer.MIN_VALUE) {
                return 0;
            }
            res += value;
            counter++;
            div--;
        }
        if (isNegative) {
            return res * -1;
        }
        return res;
    }


}
