package april_2025;

public class NumberOf1Bits {

    public static void main(String[] args) {
        int n = 2147483645;
        NumberOf1Bits numberOf1Bits = new NumberOf1Bits();
        int result = numberOf1Bits.hammingWeight(n);
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
