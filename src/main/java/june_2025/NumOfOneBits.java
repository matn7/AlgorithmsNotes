package june_2025;

public class NumOfOneBits {

    public static void main(String[] args) {
        int n = 2147483645;

        NumOfOneBits numOfOneBits = new NumOfOneBits();
        int result = numOfOneBits.hammingWeight(n);
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
