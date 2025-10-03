package september_2025;

import java.util.HashMap;
import java.util.Map;

public class StoneGame {

    public static void main(String[] args) {
        int[] piles = {4, 3, 4, 5};
        StoneGame stoneGame = new StoneGame();
        boolean result = stoneGame.stoneGame(piles);
        System.out.println(result);
    }

    // O(n^2) time | O(n^2) space
    public boolean stoneGame(int[] piles) {
        int sum = 0;
        for (int pile: piles) {
            sum += pile;
        }
//        Map<String, Integer> dp = new HashMap<>(); // subarr piles (l,r) -> Max Alice Total
        int[][] dp = new int[piles.length][piles.length];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                dp[i][j] = -1;
            }
        }

        return dfs(0, piles.length - 1, piles, dp) > sum / 2;
    }

    // Return: Max Alice Total
    private int dfs(int l, int r, int[] piles, int[][] dp) {
        if (l > r) {
            return 0;
        }
        if (dp[l][r] != -1) {
            return dp[l][r];
        }

        boolean even = (r - l) % 2 == 0; // Alice making choice, odd Bob making a choice
        int left = even ? piles[l] : 0;
        int right = even ? piles[r] : 0;

        dp[l][r] = Math.max(dfs(l + 1, r, piles, dp) + left, dfs(l, r - 1, piles, dp) + right);
        return dp[l][r];
    }
}
