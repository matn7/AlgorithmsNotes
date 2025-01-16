package december_2024;

public class CountingBits {

    public static void main(String[] args) {
        int n = 5;
        CountingBits countingBits = new CountingBits();
        int[] result = countingBits.countBits(n);
        System.out.println(result);
    }

    public int[] countBits(int n) {
        int[] res = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            int count = 0;
            int num = i;
            while (num > 0) {
                if ((num & 1) == 1) {
                    count++;
                }
                num = num >> 1;
            }
            res[i] = count;
        }
        return res;
    }

}
