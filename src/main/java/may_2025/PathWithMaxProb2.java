package may_2025;

import java.util.*;

public class PathWithMaxProb2 {

    public static void main(String[] args) {
        int n = 3;
        int[][] edges = {{0,1}, {1,2}, {0,2}};
        double[] succProb = {0.5, 0.5, 0.2};
        int start_node = 0;
        int end_node = 2;

        PathWithMaxProb2 pathWithMaxProb2 = new PathWithMaxProb2();
        double result = pathWithMaxProb2.maxProbability(n, edges, succProb, start_node, end_node);
        System.out.println(result);
    }

    // O((V + E)*log(V)) time | O(V + E) space
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
            adj.get(s).add(new Pair(d, w));
            adj.get(d).add(new Pair(s, w));
        }
        double[] prob = new double[n];
        prob[start_node] = 1;
        PriorityQueue<Pair> queue = new PriorityQueue<>();
        queue.add(new Pair(start_node, 1.0));

        while (!queue.isEmpty()) {
            Pair poll = queue.poll();
            int n1 = poll.node;
            double p1 = poll.prob;
            if (n1 == end_node) {
                return p1;
            }
            if (p1 > prob[n1]) {
                continue;
            }

            List<Pair> neighbors = adj.get(n1);
            for (Pair neighbor : neighbors) {
                int n2 = neighbor.node;
                double p2 = neighbor.prob;
                double newProb = p1 * p2;
                if (newProb > prob[n2]) {
                    prob[n2] = newProb;
                    queue.add(new Pair(n2, newProb));
                }
            }
        }

        return 0.0;
    }

    static class Pair implements Comparable<Pair> {
        int node;
        double prob;

        public Pair(int node, double prob) {
            this.node = node;
            this.prob = prob;
        }

        @Override
        public int compareTo(Pair o) {
            return Double.compare(o.prob, prob);
        }
    }


}
