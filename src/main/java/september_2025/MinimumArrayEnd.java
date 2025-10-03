package september_2025;

public class MinimumArrayEnd {

    // O(log(n)) time | O(log(n)) space
    public long minEnd(int n, int x) {
        long res = 0;
        n -= 1;

        int[] x_bin = new int[64]; // Binary representation of x
        int[] n_bin = new int[64]; // Binary representation of n-1

        for (int i = 0; i < 32; i++) {
            x_bin[i] = (x >> i) & 1;
            n_bin[i] = (n >> i) & 1;
        }

        int i_x = 0;
        int i_n = 0;
        while (i_x < 63) {
            while (i_x < 63 && x_bin[i_x] != 0) {
                i_x++;
            }
            x_bin[i_x] = n_bin[i_n];
            i_x++;
            i_n++;
        }

        for (int i = 0; i < 64; i++) {
            if (x_bin[i] == 1) {
                res += (1L << i);
            }
        }

        return res;
    }
}
