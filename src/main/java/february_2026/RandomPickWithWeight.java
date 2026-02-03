package february_2026;

import java.util.Random;

public class RandomPickWithWeight {

    Random random;
    int[] prefixSum;
    public RandomPickWithWeight(int[] w) {
        prefixSum = new int[w.length];
        prefixSum[0] = w[0];
        for (int i = 1; i < w.length; i++) {
            prefixSum[i] = w[i] + prefixSum[i - 1];
        }
        random = new Random();
    }

    public int pickIndex() {
        int target = random.nextInt(prefixSum[prefixSum.length - 1]) + 1;

        int l = 0;
        int r = prefixSum.length - 1;
        while (l < r) {
            int mid = (l + r) / 2;
            if (prefixSum[mid] < target) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l;
    }

}
