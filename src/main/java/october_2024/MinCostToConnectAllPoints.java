package october_2024;

import java.util.*;

public class MinCostToConnectAllPoints {

    public static void main(String[] args) {
        int[][] points = {{0, 0}, {2, 2}, {3, 10}, {5, 2}, {7, 0}};

        MinCostToConnectAllPoints minCost = new MinCostToConnectAllPoints();
        int result = minCost.minCostConnectPoints(points);
        System.out.println(result);
    }

    public int minCostConnectPoints(int[][] points) {
        int[] distances = new int[points.length];
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[0] = 0;
        for (int i = 0; i < points.length; i++) {
            int[] a = points[i];
            for (int j = 0; j < points.length; j++) {
                int[] b = points[j];
                if (i == j) {
                    continue;
                }
                int distance = Math.abs(b[0] - a[0]) + Math.abs(b[1] - a[1]);
                distances[j] = Math.min(distances[j], distance);
            }
        }
        int sum = 0;
        for (int d : distances) {
            sum += d;
        }
        return sum;
    }

    // O(n^2 log(n)) time
    public int minCostConnectPoints2(int[][] points) {
        int N = points.length;

        // i : list of [cost, node]
        Map<Integer, List<Node>> adj = new HashMap<>();
        for (int i = 0; i < N; i++) {
            adj.put(i, new ArrayList<>());
        }
        for (int i = 0; i < N; i++) {
            int x1 = points[i][0];
            int y1 = points[i][1];
            for (int j = i + 1; j < N; j++) {
                int x2 = points[j][0];
                int y2 = points[j][1];
                int dist = Math.abs(x1 - x2) + Math.abs(y1 - y2);
                adj.get(i).add(new Node(dist, j));
                adj.get(j).add(new Node(dist, i));
            }
        }
        // Prim's
        int res = 0;
        Set<Integer> visit = new HashSet<>();
        PriorityQueue<Element> minH = new PriorityQueue<>();
        minH.add(new Element(0, 0));
        while (visit.size() < N) {
            Element elem = minH.poll();
            int cost = elem.cost;
            int i = elem.point;
            if (visit.contains(i)) {
                continue;
            }
            res += cost;
            visit.add(i);
            for (Node n : adj.get(i)) {
                int neiCost = n.dist;
                int nei = n.node;
                if (!visit.contains(nei)) {
                    minH.add(new Element(neiCost, nei));
                }
            }
        }
        return res;
    }

    static class Element implements Comparable<Element> {
        int cost;
        int point;

        public Element(int cost, int point) {
            this.cost = cost;
            this.point = point;
        }

        @Override
        public int compareTo(Element o) {
            return this.cost - o.cost;
        }
    }

    static class Node {
        int dist;
        int node;

        public Node(int dist, int node) {
            this.dist = dist;
            this.node = node;
        }
    }



}
