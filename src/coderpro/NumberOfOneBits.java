package coderpro;

public class NumberOfOneBits {

    public static void main(String[] args) {
        int num = 23;
        NumberOfOneBits numberOfOneBits = new NumberOfOneBits();
        int result = numberOfOneBits.one_bits(num);
        System.out.println(result);
    }

    // O(log(n)) time | O(1) space
    public int one_bits(int n) {
        int count = 0;
        while (n > 0) {
            int check = n & 1;
            if (check == 1) {
                count++;
            }
            n = n >> 1;
        }
        return count;
    }

}
