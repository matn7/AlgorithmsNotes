package educative.bitwisexor;

public class CalculateComplement {

    public static void main(String[] args) {
        System.out.println("Bitwise complement is: " + CalculateComplement.bitwiseComplement(8));
        System.out.println("Bitwise complement is: " + CalculateComplement.bitwiseComplement(10));
    }

    // O(b) time | O(1) space
    public static int bitwiseComplement(int num) {
        // count number of total bits in 'num'
        int bitCount = 0;
        int n = num;
        while (n > 0) {
            bitCount++;
            n = n >> 1;
        }

        int all_bits_set = (int) Math.pow(2, bitCount) - 1;

        return num ^ all_bits_set;
    }

}
