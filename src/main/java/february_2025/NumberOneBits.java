package february_2025;

public class NumberOneBits {

    public static void main(String[] args) {
        NumberOneBits numberOneBits = new NumberOneBits();
        int result = numberOneBits.hammingWeight(3);
        System.out.println(result);
    }

    public int hammingWeight(int n) {
        int count = 0;

        while (n != 0) {
            if ((n & 1) == 1) {
                count++;
            }
            n = n >> 1;
        }

        return count;
    }

}
