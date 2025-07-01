package june_2025;

import java.util.Arrays;

public class FindCheapestPrice {

    public static void main(String[] args) {
        int n = 3;
        int[][] flights = {{0,1,100}, {1,2,100}, {0,2,500}};
        int k = 1;
        int src = 0;
        int dst = 2;

        FindCheapestPrice findCheapestPrice = new FindCheapestPrice();
        int result = findCheapestPrice.findCheapestPrice(n, flights, src, dst, k);
        System.out.println(result);
    }

    // O(k*n) time | O(n) space
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] result = new int[n];
        Arrays.fill(result, Integer.MAX_VALUE);
        result[src] = 0;

        for (int i = 0; i <= k; i++) {
            int[] temp = Arrays.copyOf(result, n);

            for (int[] flight : flights) {
                int s = flight[0];
                int d = flight[1];
                int w = flight[2];
                if (result[s] == Integer.MAX_VALUE) {
                    continue;
                }
                if (result[s] + w < temp[d]) {
                    temp[d] = result[s] + w;
                }
            }
            result = temp;
        }
        return result[dst] != Integer.MAX_VALUE ? result[dst] : -1;
    }

}
