package december_2025;

import java.util.HashMap;
import java.util.Map;

public class PaintHouseII {

    public static void main(String[] args) {
        int[][] costs = {{1,5,3},{2,9,4}};

        PaintHouseII paintHouseII = new PaintHouseII();
        int result = paintHouseII.minCostII(costs);
        System.out.println(result);
    }

    // O(n * k) time | O(k) space
    public int minCostII(int[][] costs) {
        if (costs == null || costs.length == 0) {
            return 0;
        }

        int n = costs.length;
        int k = costs[0].length;

        int[] prev = new int[k];
        System.arraycopy(costs[0], 0, prev, 0, k);

        for (int i = 1; i < n; i++) {
            int min1 = Integer.MAX_VALUE;
            int min2 = Integer.MAX_VALUE;
            int idx1 = -1;

            // find smallest and second smallest from prev
            for (int j = 0; j < k; j++) {
                if (prev[j] < min1) {
                    min2 = min1;
                    min1 = prev[j];
                    idx1 = j;
                } else if (prev[j] < min2) {
                    min2 = prev[j];
                }
            }

            int[] curr = new int[k];
            for (int j = 0; j < k; j++) {
                if (j == idx1) {
                    curr[j] = costs[i][j] + min2;
                } else {
                    curr[j] = costs[i][j] + min1;
                }
            }

            prev = curr;
        }

        int result = Integer.MAX_VALUE;
        for (int cost : prev) {
            result = Math.min(result, cost);
        }

        return result;
    }

}
