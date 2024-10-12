package udemy.faang;

import java.util.HashMap;
import java.util.Map;

public class KnightProbability {

    public static void main(String[] args) {
        // n = 6
        // k = 2
        // r = 2
        // c = 2
        KnightProbability knightProbability = new KnightProbability();
        double result = knightProbability.knightProbability(6, 2, 2, 2);
        System.out.println(result);
        double result2 = knightProbability.knightProbabilityMemo(6, 2, 2, 2);
        System.out.println(result2);
        double result3 = knightProbability.knightProbabilityTab(6, 2, 2, 2);
        System.out.println(result3);
    }

    int[][] directions = {{-2, -1}, {-2, 1}, {-1, 2}, {1, 2}, {2, 1}, {2, -1}, {1, -2}, {-1, -2}};

    // O(8^k) time | O(8^k) space
    public double knightProbability(int n, int k, int r, int c) {

        if (r < 0 || r >= n || c < 0 || c >= n) {
            return 0.0;
        }
        if (k == 0) {
            return 1.0;
        }
        double res = 0.0;
        for (int i = 0; i < directions.length; i++) {
            int[] dir = directions[i];
            res += knightProbability(n, k - 1, r + dir[0], c + dir[1]) / 8;
        }
        return res;
    }

    // O(n^2 * k) time | O(n^2 * k) space
    public double knightProbabilityMemo(int n, int k, int r, int c) {
        Map<String, Double> dp = new HashMap<>();
        return recurs(n, k, r, c, dp);
    }

    private double recurs(int n, int k, int r, int c, Map<String, Double> dp) {
        if (r < 0 || c < 0 || r >= n || c >= n) {
            return 0;
        }
        if (k == 0) {
            return 1;
        }
        String key = k + ":" + r + ":" + c;
        if (dp.containsKey(key)) {
            return dp.get(key);
        }
        double res = 0;
        for (int i = 0; i < directions.length; i++) {
            int[] dir = directions[i];
            res += recurs(n, k - 1, r + dir[0], c + dir[1], dp) / 8;
        }
        dp.put(key, res);
        return dp.get(key);
    }

    // O(n^2 * k) time | O(n^2 * k) space
    public double knightProbabilityTab(int n, int k, int r, int c) {
        Map<String, Double> dp = new HashMap<>();
        for (int i = 0; i < k; i++) {
            for (int row = 0; row < n; row++) {
                for (int col = 0; col < n; col++) {
                    String key = i + ":" + row + ":" + col;
                    dp.put(key, 0.0);
                }
            }
        }
        dp.put(0 + ":" + r + ":" + c, 1.0);
        for (int step = 1; step <= k; step++) {
            for (int row = 0; row < n; row++) {
                for (int col = 0; col < n; col++) {
                    for (int i = 0; i < directions.length; i++) {
                        int[] dir = directions[i];
                        int prevRow = row + dir[0];
                        int prevCol = col + dir[1];
                        if (prevRow >= 0 && prevRow < n && prevCol >= 0 && prevCol < n) {
                            String currKey = step + ":" + row + ":" + col;
                            String prevKey = (step - 1) + ":" + prevRow + ":" + prevCol;
                            dp.put(currKey, dp.get(currKey) + dp.get(prevKey) / 8);
                        }
                    }
                }
            }
        }
        double res = 0.0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                String key = k + ":" + i + ":" + j;
                res += dp.get(key);
            }
        }
        return res;
    }

}
