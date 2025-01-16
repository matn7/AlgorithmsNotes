package december_2024;

public class NumberOfOneBits {

    public static void main(String[] args) {
        int n = 128;
        NumberOfOneBits numberOfOneBits = new NumberOfOneBits();
        int result = numberOfOneBits.hammingWeight(n);
        System.out.println(result);
    }

    public int hammingWeight(int n) {
        int count = 0;
        int BIT_MASK = 1;
        while (n > 0) {
            if ((n & BIT_MASK) == 1) {
                count++;
            }
            n = n >> 1;
        }
        return count;
    }

}
