package july_2025;

public class NumOf1Bits {

    public static void main(String[] args) {
        int n = 11;
        NumOf1Bits bits = new NumOf1Bits();
        int result = bits.hammingWeight(n);
        System.out.println(result);
    }

    // O(1) time | O(1) space
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
