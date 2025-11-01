package october_2025;

public class CountingBits2 {

    public static void main(String[] args) {
        int n = 5;
        CountingBits2 countingBits2 = new CountingBits2();
        int[] result = countingBits2.countBits(n);
        System.out.println(result);
    }

    // O(n) time | O(n) space
    public int[] countBits(int n) {
        int[] result = new int[n + 1];
        int offset = 1;
        for (int i = 1; i <= n; i++) {
            if (offset * 2 == i) {
                offset = i;
            }
            result[i] = 1 + result[i - offset];
        }
        return result;
    }

}
