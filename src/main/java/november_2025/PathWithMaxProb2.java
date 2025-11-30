package november_2025;

import java.util.*;

public class PathWithMaxProb2 {

    public static void main(String[] args) {
        int n = 3;
        int[][] edges = {{0,1},{1,2},{0,2}};
        double[] succProb = {0.5,0.5,0.2};
        int start = 0;
        int end = 2;

        PathWithMaxProb2 pathWithMaxProb2 = new PathWithMaxProb2();
        double result = pathWithMaxProb2.maxProbability(n, edges, succProb, start, end);
        System.out.println(result);
    }

    // O(e log(v)) time | O(v + e) space
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        Map<Integer, List<Pair>> adj = new HashMap<>();
        double[] prob = new double[n];
        for (int i = 0; i < n; i++) {
            adj.put(i, new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {
            double p = succProb[i];
            int[] edge = edges[i];
            int s = edge[0];
            int d = edge[1];
            adj.get(s).add(new Pair(d, p));
            adj.get(d).add(new Pair(s, p));
        }
        prob[start_node] = 1;
        PriorityQueue<Pair> maxHeap = new PriorityQueue<>((a, b) -> Double.compare(b.prob, a.prob)); // node, prob
        maxHeap.add(new Pair(start_node, 1));
        Set<Integer> visited = new HashSet<>();

        while (!maxHeap.isEmpty()) {
            Pair current = maxHeap.poll();
            int node = current.node;
            double curProb = current.prob;
            visited.add(node);
            if (node == end_node) {
                return curProb;
            }

            if (curProb > prob[node]) {
                continue;
            }

            List<Pair> neighbors = adj.get(node);
            for (Pair nei : neighbors) {
                int neiNode = nei.node;
                double neiProb = nei.prob;
                double newProb = curProb * neiProb;
                if (newProb > prob[neiNode] && !visited.contains(neiNode)) {
                    prob[neiNode] = newProb;
                    maxHeap.add(new Pair(neiNode, newProb));
                }
            }
        }
        return prob[end_node];
    }

    static class Pair {
        int node;
        double prob;

        public Pair(int node, double prob) {
            this.node = node;
            this.prob = prob;
        }
    }

}
