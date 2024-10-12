package october_2023;

public class ReverseInteger {

    public static void main(String[] args) {
        int x = 831400877;
        reverseInteger(x);
    }

    // O(n) time | O(1) space
    public static int reverseInteger(int n) {
        int sum = 0;
        String nStr = String.valueOf(n);
        int numDigits = nStr.length();
        int pow = 0;
        for (int i = 0; i < nStr.length(); i++) {
            int currValue = (int) ((n % Math.pow(10, numDigits - pow)) / Math.pow(10, numDigits - pow - 1));
            int currMul = (int) Math.pow(10, pow);
            int toAdd = currValue * currMul;
            long test = toAdd + sum;
            if (test > Integer.MAX_VALUE || test < Integer.MIN_VALUE) {
                return 0;
            }
            sum += toAdd;
            pow++;
        }

        return sum;
    }

}
