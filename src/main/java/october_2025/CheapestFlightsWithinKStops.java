package october_2025;

import java.util.Arrays;

public class CheapestFlightsWithinKStops {

    public static void main(String[] args) {
        int n = 4;
        int[][] flights = {{0,1,100},{1,2,100},{2,0,100},{1,3,600},{2,3,200}};
        int src = 0;
        int dst = 3;
        int k = 1;

        CheapestFlightsWithinKStops cheapestFlightsWithinKStops = new CheapestFlightsWithinKStops();
        int result = cheapestFlightsWithinKStops.findCheapestPrice(n, flights, src, dst, k);
        System.out.println(result);
    }

    // O(k * m) time | O(n) space
    // n - num of cities
    // k - stops
    // m - flights
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] cost = new int[n];
        Arrays.fill(cost, Integer.MAX_VALUE);

        cost[src] = 0;

        for (int i = 0; i <= k; i++) {
            int[] newCost = Arrays.copyOf(cost, cost.length);
            for (int[] flight : flights) {
                if (cost[flight[0]] == Integer.MAX_VALUE) {
                    continue;
                }
                if (cost[flight[0]] + flight[2] < newCost[flight[1]]) {
                    newCost[flight[1]] = cost[flight[0]] + flight[2];
                }
            }
            cost = newCost;
        }
        return cost[dst] == Integer.MAX_VALUE ? -1 : cost[dst];
    }

}
