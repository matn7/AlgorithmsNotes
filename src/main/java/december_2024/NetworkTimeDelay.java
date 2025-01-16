package december_2024;

import java.util.*;

public class NetworkTimeDelay {

    public static void main(String[] args) {
        int[][] times = {{2, 1, 1}, {2, 3, 1}, {3, 4, 1}};
        int n = 4;
        int k = 2;

        NetworkTimeDelay networkTimeDelay = new NetworkTimeDelay();
        int result = networkTimeDelay.networkDelayTime(times, n, k);
        System.out.println(result);
    }

    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, Node> adj = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            adj.put(i, new Node(i));
        }

        for (int[] time : times) {
            int s = time[0];
            int d = time[1];
            int w = time[2];
            Node source = adj.get(s);
            Node dest = adj.get(d);
            source.neighbors.add(new Edge(dest, w));
        }
        Node source = adj.get(k);
        Set<Integer> visited = new HashSet<>();
        PriorityQueue<Edge> queue = new PriorityQueue<>();
        int[] distances = new int[n + 1];
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[0] = 0;
        distances[k] = 0;
        queue.add(new Edge(source, 0));

        int max = 0;
        while (!queue.isEmpty()) {
            Edge current = queue.poll();
            Node node = current.destination;
            int weight = current.weight;
            if (visited.contains(node.id)) {
                continue;
            }
            visited.add(node.id);

            List<Edge> neighbors = node.neighbors;
            for (Edge neighbor : neighbors) {
                Node neiDest = neighbor.destination;
                int neiWeight = neighbor.weight;
                int neiId = neiDest.id;
                if (weight + neiWeight < distances[neiId]) {
                    distances[neiId] = weight + neiWeight;
                    if (!visited.contains(neiId)) {
                        queue.add(new Edge(neiDest,weight + neiWeight));
                    }
                }
            }
        }
        for (int d : distances) {
            if (d == Integer.MAX_VALUE) {
                return -1;
            }
            max = Math.max(d, max);
        }
        return max;
    }

    static class Node {
        int id;
        List<Edge> neighbors;

        public Node(int id) {
            this.id = id;
            this.neighbors = new ArrayList<>();
        }
    }

    static class Edge implements Comparable<Edge> {
        Node destination;
        int weight;

        public Edge(Node destination, int weight) {
            this.destination = destination;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return this.weight - o.weight;
        }
    }

}
