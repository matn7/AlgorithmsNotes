package june_2025;

import java.util.Arrays;

public class CheapestFlight {

    public static void main(String[] args) {
        int n = 4;
        int[][] flights = {{0,1,100},{1,2,100},{2,0,100},{1,3,600},{2,3,200}};
        int src = 0;
        int dst = 3;
        int k = 1;
        CheapestFlight cheapestFlight = new CheapestFlight();
        int result = cheapestFlight.findCheapestPrice(n, flights, src, dst, k);
        System.out.println(result);
    }

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
                newDp[d] = Math.min(newDp[d], dp[s] + c);
            }
            dp = newDp;
        }

        return dp[dst] == Integer.MAX_VALUE ? -1 : dp[dst];
    }



}
