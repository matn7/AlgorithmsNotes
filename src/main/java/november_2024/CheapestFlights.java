package november_2024;

import java.util.*;

public class CheapestFlights {

    public static void main(String[] args) {
        int n = 4;
//        [[0,1,1],[0,2,5],[1,2,1],[2,3,1]]
//        int[][] flights = {{0, 1, 100}, {1, 2, 100}, {0, 2, 500}};
        int[][] flights = {{0, 1, 1}, {0, 2, 5}, {1, 2, 1}, {2, 3, 1}};
        int src = 0;
        int dst = 3;
        int k = 1;

        CheapestFlights cheapestFlights = new CheapestFlights();
        int cheapestPrice = cheapestFlights.findCheapestPrice(n, flights, src, dst, k);
        System.out.println(cheapestPrice);
    }

    // O(e + k) time
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] prices = new int[n];
        Arrays.fill(prices, Integer.MAX_VALUE);
        prices[src] = 0;

        for (int i = 0; i < k + 1; i++) {
            int[] tempPrices = new int[n];
            System.arraycopy(prices, 0, tempPrices, 0, n);
            for (int[] flight : flights) {
                int s = flight[0];
                int d = flight[1];
                int p = flight[2];
                if (prices[s] == Integer.MAX_VALUE) {
                    continue;
                }
                if (prices[s] + p < tempPrices[d]) {
                    tempPrices[d] = prices[s] + p;
                }
            }
            System.arraycopy(tempPrices, 0, prices, 0, n);
        }

        return prices[dst] == Integer.MAX_VALUE ? -1 : prices[dst];
    }


}
