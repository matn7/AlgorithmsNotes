package december_2025;

import java.util.Random;

public class RandomPickWithWeight {

    // O(log(n)) time | O(1) space
    int[] prefixSum;
    Random random;
    public RandomPickWithWeight(int[] w) {
        prefixSum = new int[w.length];
        random = new Random();
        prefixSum[0] = w[0];

        for (int i = 1; i < w.length; i++) {
            prefixSum[i] = w[i] + prefixSum[i - 1];
        }
    }

    public int pickIndex() {
        int target = random.nextInt(prefixSum[prefixSum.length - 1]) + 1;
        int left = 0;
        int right = prefixSum.length - 1;

        while (left < right) {
            int mid = (left + right) / 2;
            if (target > prefixSum[mid]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

}
