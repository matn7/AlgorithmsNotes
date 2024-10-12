package june_2024;

import java.util.*;

public class NetworkTimeDelay {

    public static void main(String[] args) {
        int n = 5;
        int[][] times = {{1, 2, 9}, {1, 4, 2}, {2, 5, 1}, {4, 2, 4}, {4, 5, 6},
                {3, 2, 3}, {5, 3, 7}, {3, 1, 5}};

        int result = networkTimeDelay(n, times, 0);
        System.out.println(result);

    }

    // O(e*log(n) + n*log(n)) time n - vertex in graph
    // O(e*log(n)) time | O(e + n) time
    public static int networkTimeDelay(int n, int[][] times, int k) {
        Map<Integer, Vertex> graph = createGraph(n, times);
        int[] distance = new int[n];
        Arrays.fill(distance, Integer.MAX_VALUE);
        int startIdx = k;
        distance[startIdx] = 0;
        int nodeIdx = startIdx + 1;
        Vertex startNode = graph.get(nodeIdx);
        List<Edge> neighbors = startNode.neighbors;

        PriorityQueue<Edge> queue = new PriorityQueue<>();
        for (Edge edge : neighbors) {
            queue.add(edge);
        }

        while (!queue.isEmpty()) {
            Edge currentEdge = queue.poll();
            Vertex sourceNode = currentEdge.source;
            Vertex destinationNode = currentEdge.destination;
            int edge = currentEdge.edge;
            int sourceNodeIdx = sourceNode.id - 1;
            int destNodeIdx = destinationNode.id - 1;
            int currDistance = distance[destNodeIdx]; // max
            int newDistance = distance[sourceNodeIdx] + edge; // 0 + 9
            if (newDistance < currDistance) {
                distance[destNodeIdx] = newDistance;
                destinationNode.cameFrom = sourceNode;
                List<Edge> neighbors1 = destinationNode.neighbors;
                for (Edge e : neighbors1) {
                    queue.add(e);
                }
            }
        }
        int maxDistance = Integer.MIN_VALUE;
        for (int dist : distance) {
            maxDistance = Math.max(maxDistance, dist);
        }

        // print full path
        Vertex vertexThree = graph.get(3);
        List<Vertex> path = new ArrayList<>();
        path.add(vertexThree);
        while (vertexThree.cameFrom != null) {
            path.add(vertexThree.cameFrom);
            vertexThree = vertexThree.cameFrom;
        }

        for (Vertex p : path) {
            System.out.print(p.id + " -> ");
        }
        System.out.println();

        return maxDistance == Integer.MAX_VALUE ? -1 : maxDistance;
    }

    private static Map<Integer, Vertex> createGraph(int n, int[][] times) {
        Map<Integer, Vertex> graph = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            graph.put(i, new Vertex(i));
        }

        for (int[] time : times) {
            int source = time[0];
            int destination = time[1];
            int distance = time[2];
            Vertex sourceNode = graph.get(source);
            Vertex destinationNode = graph.get(destination);
            sourceNode.addNeighbor(new Edge(sourceNode, destinationNode, distance));
        }

        return graph;
    }

    static class Vertex {
        int id;
        Vertex cameFrom;
        List<Edge> neighbors;

        public Vertex(int id) {
            this.id = id;
            this.neighbors = new ArrayList<>();
        }

        void addNeighbor(Edge edge) {
            this.neighbors.add(edge);
        }
    }

    static class Edge implements Comparable<Edge> {
        Vertex source;
        Vertex destination;
        int edge;

        public Edge(Vertex source, Vertex destination, int edge) {
            this.source = source;
            this.destination = destination;
            this.edge = edge;
        }

        @Override
        public int compareTo(Edge o) {
            return o.edge - edge;
        }
    }


}
