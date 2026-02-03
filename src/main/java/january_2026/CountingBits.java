package january_2026;

public class CountingBits {

    public static void main(String[] args) {
        int n = 5;

        CountingBits countingBits = new CountingBits();
        int[] result = countingBits.countBits(n);
        System.out.println(result);
    }

    // O(n) time | O(n) space
    public int[] countBits(int n) {
        int[] res = new int[n + 1];
        int offset = 1;
        for (int i = 1; i <= n; i++) {
            if (offset * 2 == i) {
                offset = i;
            }
            res[i] = 1 + res[i - offset];
        }
        return res;
    }


}
