package january_2026;

public class PaintHouseII {

    public static void main(String[] args) {
        int[][] costs = {{1,5,3},{2,9,4}};

        PaintHouseII paintHouseII = new PaintHouseII();
        int result = paintHouseII.minCostII(costs);
        System.out.println(result);
    }

    // O(n * k^2) time | O(n) space
    public int minCostII(int[][] costs) {
        int k = costs[0].length;
        int[] prev = new int[k]; // [1, 5, 3]
        for (int i = 0; i < k; i++) {
            prev[i] = costs[0][i];
        }

        for (int i = 1; i < costs.length; i++) {
            int[] curr = new int[k]; // [0, 0, 0]
            int[] cost = costs[i];
            for (int c = 0; c < cost.length; c++) {
                int min = Integer.MAX_VALUE;
                for (int p = 0; p < prev.length; p++) {
                    if (p == c) {
                        continue;
                    }
                    min = Math.min(min, prev[p]);
                }
                curr[c] = cost[c] + min;
            }
            prev = curr;
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < prev.length; i++) {
            min = Math.min(min, prev[i]);
        }
        return min;
    }

}
