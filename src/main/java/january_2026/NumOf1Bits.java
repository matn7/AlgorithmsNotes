package january_2026;

public class NumOf1Bits {

    public static void main(String[] args) {
        int n = 11;
        NumOf1Bits numOf1Bits = new NumOf1Bits();
        int result = numOf1Bits.hammingWeight(n);
        System.out.println(result);
    }

    // O(n) time | O(1) space
    public int hammingWeight(int n) {
        int count = 0;
        while (n > 0) {
            if ((n & 1) == 1) {
                count++;
            }
            n = n >> 1;
        }
        return count;
    }

}
