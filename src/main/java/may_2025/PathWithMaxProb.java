package may_2025;

import java.util.*;

public class PathWithMaxProb {

    public static void main(String[] args) {
        int n = 3;
        int[][] edges = {{0,1}, {1,2}, {0,2}};
        double[] succProb = {0.5, 0.5, 0.2};
        int start_node = 0;
        int end_node = 2;

        PathWithMaxProb pathWithMaxProb = new PathWithMaxProb();
        double result = pathWithMaxProb.maxProbability(n, edges, succProb, start_node, end_node);
        System.out.println(result);
    }

    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        Map<Integer, List<Pair>> adj = new HashMap<>();
        for (int i = 0; i < n; i++) {
            adj.put(i, new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {
            int[] edge = edges[i];
            int s = edge[0];
            int d = edge[1];
            double w = succProb[i];
            adj.get(s).add(new Pair(w, d));
            adj.get(d).add(new Pair(w, s));
        }
        PriorityQueue<Pair> queue = new PriorityQueue<>();
        queue.add(new Pair(1.0, start_node));
        double[] prob = new double[n];
        prob[start_node] = 1.0;
        // prob = [1.0, 0.5, 0.0]

        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            double weight = pair.weight; // 0.5
            int node = pair.node; // 1
            if (node == end_node) {
                return weight;
            }
            if (weight > prob[node]) {
                continue;
            }

            List<Pair> neighbors = adj.get(node); // [0, 2]
            for (Pair neighbor : neighbors) { // 2
                double newProb = weight * neighbor.weight; // 0.5 * 0.5 = 0.25
                if (newProb > prob[neighbor.node]) { // 0.25 > 0.0
                    prob[neighbor.node] = newProb;
                    queue.add(new Pair(newProb, neighbor.node));
                }
            }
        }

        return 0.0;
    }

    static class Pair implements Comparable<Pair> {
        double weight;
        int node;

        public Pair(double weight, int node) {
            this.weight = weight;
            this.node = node;
        }

        @Override
        public int compareTo(Pair o) {
            return (int) (o.weight - weight);
        }
    }

}
