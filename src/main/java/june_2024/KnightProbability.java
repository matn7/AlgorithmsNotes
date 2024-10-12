package june_2024;

import java.util.HashMap;
import java.util.Map;

public class KnightProbability {

    static int[][] DIRECTIONS = {{-2, -1}, {-2, 1}, {-1, 2}, {1, 2}, {2, 1}, {2, -1}, {1, -2}, {-1, -2}};

    public static void main(String[] args) {
        double result = knightProbability(6, 3, 2, 2);
        System.out.println(result);
    }

    // O(8^k) time | O(8^k) space
    public static double knightProbability(int n, int k, int r, int c) {
        if (r < 0 || r >= n && c < 0 || c >= n) {
            return 0.0;
        }
        if (k == 0) {
          return 1.0;
        }
        double res = 0.0;
        for (int i = 0; i < DIRECTIONS.length; i++) {
            int[] dir = DIRECTIONS[i];
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
        for (int i = 0; i < DIRECTIONS.length; i++) {
            int[] dir = DIRECTIONS[i];
            res += recurs(n, k - 1, r + dir[0], c + dir[1], dp) / 8;
        }
        dp.put(key, res);
        return dp.get(key);
    }

}
























