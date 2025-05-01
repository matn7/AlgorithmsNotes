package april_2025;

public class NumberOfOneBits {

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
