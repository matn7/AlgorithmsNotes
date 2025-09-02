package august_2025;

import java.util.Arrays;

public class FindCheapestPrice {

    public static void main(String[] args) {
        int n = 3;
        int[][] flights = {{0,1,100},{1,2,100},{0,2,500}};
        int src = 0;
        int dst = 2;
        int k = 1;

        FindCheapestPrice findCheapestPrice = new FindCheapestPrice();
        int result = findCheapestPrice.findCheapestPrice(n, flights, src, dst, k);
        System.out.println(result);
    }

    // O(k * f) time | O(n) space
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] distance = new int[n];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[src] = 0;

        for (int i = 0; i <= k; i++) {
            int[] newDist = Arrays.copyOf(distance, n);

            for (int[] flight : flights) {
                int s = flight[0];
                int d = flight[1];
                int w = flight[2];

                if (distance[s] == Integer.MAX_VALUE) {
                    continue;
                }

                newDist[d] = Math.min(newDist[d], distance[s] + w);
            }
            distance = newDist;
        }
        return distance[dst] == Integer.MAX_VALUE ? -1 : distance[dst];
    }

}
