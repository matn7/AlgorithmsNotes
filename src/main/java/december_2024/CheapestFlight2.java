package december_2024;

import java.util.Arrays;

public class CheapestFlight2 {

    public static void main(String[] args) {
        int n = 4;
        int[][] flights = {{0, 1, 100}, {1, 2, 100}, {1, 3, 600}, {2, 3, 200}};
        int src = 0;
        int dst = 3;
        int k = 1;

        CheapestFlight2 cheapestFlight2 = new CheapestFlight2();
        int result = cheapestFlight2.findCheapestPrice(n, flights, src, dst, k);
        System.out.println(result);
    }

    // O(e * k) time | O(e) space
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] prices = new int[n];
        Arrays.fill(prices, Integer.MAX_VALUE);
        prices[src] = 0;

        for (int i = 0; i <= k; i++) {
            int[] temp = new int[n];
            System.arraycopy(prices, 0, temp, 0, n);
            for (int[] flight : flights) {
                int s = flight[0];
                int d = flight[1];
                int c = flight[2];

                if (prices[s] == Integer.MAX_VALUE) {
                    continue;
                }
                if (prices[s] + c < temp[d]) {
                    temp[d] = prices[s] + c;
                }
            }
            System.arraycopy(temp, 0, prices, 0, n);
        }

        return prices[dst] == Integer.MAX_VALUE ? -1 : prices[dst];
    }

}
