package november_2025;

import java.util.Random;

public class Solution {

    public static void main(String[] args) {
        int[] w = {1, 3};
        Solution solution = new Solution(w);

        System.out.println(solution);
    }

    int[] prefixSum;
    Random random;

    public Solution(int[] w) {
        prefixSum = new int[w.length];
        prefixSum[0] = w[0];
        for (int i = 1; i < w.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + w[i];
        }
        random = new Random();
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
