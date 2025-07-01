package june_2025;

import java.util.Arrays;

public class CheapestFlight2 {

    public static void main(String[] args) {
        int n = 3;
        int[][] flights = {{0,1,100},{1,2,100},{0,2,500}};
        int src = 0;
        int dst = 2;
        int k = 1;

        CheapestFlight2 cheapestFlight2 = new CheapestFlight2();
        int result = cheapestFlight2.findCheapestPrice(n, flights, src, dst, k);
        System.out.println(result);
    }

    // O(n * k) time | O(n) space
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[src] = 0;

        for (int i = 0; i <= k; i++) {
            int[] newDp = new int[n];
            System.arraycopy(dp, 0, newDp, 0, n);

            for (int[] flight : flights) {
                int s = flight[0];
                int d = flight[1];
                int c = flight[2];

                if (dp[s] == Integer.MAX_VALUE) {
                    continue;
                }
                if (dp[s] + c < dp[d]) {
                    newDp[d] = Math.min(newDp[d], dp[s] + c);
                }
            }
            dp = newDp;
        }

        return dp[dst] == Integer.MAX_VALUE ? -1 : dp[dst];
    }

}
