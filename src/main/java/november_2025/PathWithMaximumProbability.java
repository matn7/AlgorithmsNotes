package november_2025;

import java.util.*;

public class PathWithMaximumProbability {

    public static void main(String[] args) {
        int n = 3;
        int[][] edges = {{0,1},{1,2},{0,2}};
        double[] succProb = {0.5,0.5,0.2};
        int start = 0;
        int end = 2;

        PathWithMaximumProbability pathWithMaximumProbability = new PathWithMaximumProbability();
        double result = pathWithMaximumProbability.maxProbability(n, edges, succProb, start, end);
        System.out.println(result);
    }

    // O(e * log(v)) time | O(v + e) space
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        Map<Integer, List<Pair>> adj = new HashMap<>();
        for (int i = 0; i < n; i++) {
            adj.put(i, new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {
            int[] edge = edges[i];
            int s = edge[0];
            int d = edge[1];
            adj.get(s).add(new Pair(d, succProb[i]));
            adj.get(d).add(new Pair(s, succProb[i]));
        }

        boolean[] visited = new boolean[n];
        PriorityQueue<Pair> maxHeap = new PriorityQueue<>();
        maxHeap.add(new Pair(start_node, 1.0));

        while (!maxHeap.isEmpty()) {
            Pair pair = maxHeap.poll();
            int node1 = pair.val;
            double prob1 = pair.prob;

            if (visited[node1]) {
                continue;
            }
            visited[node1] = true;

            if (node1 == end_node) {
                return prob1;
            }

            List<Pair> neighbors = adj.get(node1);
            for (Pair neighbor : neighbors) {
                int node2 = neighbor.val;
                double prob2 = neighbor.prob;
                double newProb = prob1 * prob2;
                if (!visited[node2]) {
                    maxHeap.add(new Pair(neighbor.val, newProb));
                }
            }
        }
        return 0.0;
    }

    static class Pair implements Comparable<Pair> {
        int val;
        double prob;

        public Pair(int val, double prob) {
            this.val = val;
            this.prob = prob;
        }

        @Override
        public int compareTo(Pair o) {
            return Double.compare(o.prob, this.prob);
        }
    }

}
