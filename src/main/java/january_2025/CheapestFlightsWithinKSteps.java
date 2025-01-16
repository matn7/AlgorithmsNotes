package january_2025;

import java.util.Arrays;

public class CheapestFlightsWithinKSteps {

    public static void main(String[] args) {
        int n = 4;
        int[][] flights = {{0, 1, 1}, {0, 2, 5}, {1, 2, 1}, {2, 3, 1}};
        // [[0,1,1],[0,2,5],[1,2,1],[2,3,1]]
        int src = 0;
        int dst = 3;
        int k = 1;

        CheapestFlightsWithinKSteps flightsWithinKSteps = new CheapestFlightsWithinKSteps();
        int cheapestPrice = flightsWithinKSteps.findCheapestPrice(n, flights, src, dst, k);
        System.out.println(cheapestPrice);
    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] prices = new int[n];
        Arrays.fill(prices, Integer.MAX_VALUE);
        prices[src] = 0;

        //  0  1  2  3  4
        // [0, m, m, m, m]
        for (int i = 0; i <= k; i++) {
            int[] tempPrice = Arrays.copyOf(prices, n);

            for (int[] flight : flights) {
                int s = flight[0]; // 0
                int d = flight[1]; // 1
                int p = flight[2]; // 1

                if (prices[s] == Integer.MAX_VALUE) {
                    continue;
                }

                if (prices[s] + p < tempPrice[d]) {
                    tempPrice[d] = prices[s] + p;
                }
            }
            prices = tempPrice;
        }

        return prices[dst] == Integer.MAX_VALUE ? -1 : prices[dst];
    }

}
