package december_2024;

import java.util.*;

public class CheapestFlight {

    public static void main(String[] args) {
//        int n = 4;
//        int[][] flights = {{0, 1, 100}, {1, 2, 100}, {1, 3, 600}, {2, 3, 200}};
//        int src = 0;
//        int dst = 3;
//        int k = 1;

        int n = 4;
        int[][] flights = {{0, 1, 1}, {0, 2, 5}, {1, 2, 1}, {2, 3, 1}};
        // [[0,1,1],[0,2,5],[1,2,1],[2,3,1]]
        int src = 0;
        int dst = 3;
        int k = 1;


        CheapestFlight cheapestFlight = new CheapestFlight();
        int cheapestPrice = cheapestFlight.findCheapestPrice(n, flights, src, dst, k);
        System.out.println(cheapestPrice);
    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        // Build adjacency list
        Map<Integer, List<int[]>> adj = new HashMap<>();
        for (int i = 0; i < n; i++) {
            adj.put(i, new ArrayList<>());
        }
        for (int[] flight : flights) {
            int s = flight[0];
            int d = flight[1];
            int c = flight[2];
            adj.get(s).add(new int[] {d, c});
        }

        // Costs array to store the cheapest price to reach each node with a specific number of stops
        int[][] costs = new int[n][k + 2]; // costs[node][stops]
        for (int i = 0; i < n; i++) {
            Arrays.fill(costs[i], Integer.MAX_VALUE); // Initialize costs to infinity
        }
        costs[src][0] = 0;

        // Priority queue: stores [node, cost, stops]
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        queue.add(new int[] {src, 0, 0}); // starting from src, with cost 0 and 0 stops

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int node = current[0];  // current node
            int cost = current[1];  // accumulated cost to this node
            int stops = current[2]; // stops made so far

            // If we've reached the destination, return the cost
            if (node == dst) {
                return cost;
            }

            // If we've used more than k stops, don't process further
            if (stops > k) {
                continue;
            }

            // Explore neighbors
            List<int[]> neighbors = adj.get(node);
            for (int[] nei : neighbors) {
                int neighbor = nei[0]; // neighboring node
                int edgeCost = nei[1]; // edge cost to neighbor

                // Check if the new cost is better and stops are within the limit
                if (cost + edgeCost < costs[neighbor][stops + 1]) {
                    costs[neighbor][stops + 1] = cost + edgeCost;
                    queue.add(new int[] {neighbor, cost + edgeCost, stops + 1});
                }
            }
        }

        // If no path was found within k stops, return -1
        return -1;
    }


    public int findCheapestPrice2(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer, List<int[]>> adj = new HashMap<>();
        for (int i = 0; i < n; i++) {
            adj.put(i, new ArrayList<>());
        }
        for (int[] flight : flights) {
            int s = flight[0];
            int d = flight[1];
            int c = flight[2];
            adj.get(s).add(new int[] {d, c});
        }
        int[] costs = new int[n];
        Arrays.fill(costs, Integer.MAX_VALUE);
        costs[src] = 0;
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        queue.add(new int[] {src, 0, -1});

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int node = current[0]; // 1
            int cost = current[1]; // 100
            int stops = current[2];
            if (stops == k) {
                break;
            }

            List<int[]> neighbors = adj.get(node);
            for (int[] nei : neighbors) {
                // nei = [[2, 100], [3, 600]]
                if (costs[node] + nei[1] < costs[nei[0]]) { // 100 + 100 < max
                    costs[nei[0]] = costs[node] + nei[1];
                    queue.add(new int[] {nei[0], nei[1], stops + 1});
                }
            }

        }
        return costs[dst] == Integer.MAX_VALUE ? -1 : costs[dst];
    }
}
