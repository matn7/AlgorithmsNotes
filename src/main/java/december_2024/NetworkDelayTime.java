package december_2024;

import java.util.*;

public class NetworkDelayTime {

    public static void main(String[] args) {
        int[][] times = {{1, 2, 1}, {2, 3, 1}, {1, 4, 4}, {3, 4, 1}};
        int n = 4;
        int k = 1;

        NetworkDelayTime networkDelayTime = new NetworkDelayTime();
        int result = networkDelayTime.networkDelayTime(times, n, k);
        System.out.println(result);
    }

    // O(e * log(v) time | O(v + e) space
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, Node> graph = prepareGraph(times, n);
        Node startNode = graph.get(k);

        PriorityQueue<Edge> queue = new PriorityQueue<>();
        int[] distances = new int[n]; // []
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[k - 1] = 0;
        queue.add(new Edge(0, startNode));

        while (!queue.isEmpty()) {
            Edge current = queue.poll();
            int currentDistance = current.distance;
            Node currentNode = current.node;

            if (currentNode.visited) {
                continue;
            }
            currentNode.visited = true;

            List<Edge> neighbors = currentNode.neighbors;
            for (Edge neighbor : neighbors) {
                int neighborDistance = neighbor.distance;
                Node neighborNode = neighbor.node;
                int neighborIndex = neighborNode.id - 1;
                int newDistance = currentDistance + neighborDistance;
                if (newDistance < distances[neighborIndex]) {
                    distances[neighborIndex] = newDistance;
                    queue.add(new Edge(newDistance, neighborNode));
                }
            }
        }

        int max = Integer.MIN_VALUE;
        for (int dist : distances) {
            if (dist == Integer.MAX_VALUE) {
                return -1;
            }
            max = Math.max(max, dist);
        }

        return max;
    }

    private Map<Integer, Node> prepareGraph(int[][] times, int n) {
        Map<Integer, Node> graph = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            graph.put(i, new Node(i));
        }

        for (int[] time : times) {
            int sourceIdx = time[0];
            int destIdx = time[1];
            int distance = time[2];
            Node sourceNode = graph.get(sourceIdx);
            Node destNode = graph.get(destIdx);
            sourceNode.addNeighbor(new Edge(distance, destNode));
        }
        return graph;
    }

    static class Node {
        int id;
        boolean visited;
        List<Edge> neighbors;

        public Node(int id) {
            this.id = id;
            this.neighbors = new ArrayList<>();
        }

        public void addNeighbor(Edge edge) {
            this.neighbors.add(edge);
        }
    }

    static class Edge implements Comparable<Edge> {
        int distance;
        Node node;

        public Edge(int distance, Node node) {
            this.distance = distance;
            this.node = node;
        }

        @Override
        public int compareTo(Edge o) {
            return this.distance - o.distance;
        }
    }

}
