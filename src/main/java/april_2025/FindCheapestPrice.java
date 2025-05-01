package april_2025;

import java.util.Arrays;

public class FindCheapestPrice {

    // O(n + (m * k)) time | O(n) space - n - num of cities, m - num of flights, k - num of stops
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] prices = new int[n];
        Arrays.fill(prices, Integer.MAX_VALUE);
        prices[src] = 0;

        for (int i = 0; i < k + 1; i++) {
            int[] tmpProces = Arrays.copyOf(prices, n);
            for (int[] flight : flights) {
                int s = flight[0];
                int d = flight[1];
                int p = flight[2];
                if (prices[s] == Integer.MAX_VALUE) {
                    continue;
                }
                if (prices[s] + p < tmpProces[d]) {
                    tmpProces[d] = prices[s] + p;
                }
            }
            prices = tmpProces;
        }
        return prices[dst] == Integer.MAX_VALUE ? -1 : prices[dst];
    }

}
