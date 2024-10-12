package udemy.faang;

import java.util.*;

public class NetworkTimeDelayMy {

    public static void main(String[] args) {
        int[][] times = {{1,2,9}, {1,4,2}, {2,5,1}, {4,2,4}, {4,5,6}, {3,2,3}, {3,1,5}, {5,3,7}};
//        int[][] times = {{1,2,9}, {1,4,2}, {2,5,1}, {4,2,4}, {4,5,6}, {3,2,3}, {3,1,5}};
        int n = 5;
        int k = 1;

        NetworkTimeDelayMy networkTimeDelay = new NetworkTimeDelayMy();
        networkTimeDelay.networkDelay(n, k, times);
    }


    public int networkDelay(int n, int k, int[][] times) {
        int[] distance = new int[n];
        Map<Integer, Vertex> adjacencyList = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            adjacencyList.put(i, new Vertex(i));
            distance[i - 1] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < times.length; i++) {
            int[] currentTime = times[i];
            Vertex source = adjacencyList.get(currentTime[0]);
            Vertex destination = adjacencyList.get(currentTime[1]);
            int weight = currentTime[2];
            source.addEdge(new Edge(destination, weight));
        }

        Vertex startVertex = adjacencyList.get(k);
        distance[k - 1] = 0;
        PriorityQueue<Edge> queue = new PriorityQueue<>();
        for (int i = 1; i <= n; i++) {
            queue.add(new Edge(adjacencyList.get(i), Integer.MIN_VALUE));
        }
        queue.add(new Edge(startVertex, 0));
        
        while (!queue.isEmpty()) {
            Edge currentEdge = queue.poll();
            Vertex currentVertex = currentEdge.vertex;
            int currentVertexId = currentVertex.id;
            int currentDistance = distance[currentVertexId - 1];
            if (currentDistance == Integer.MAX_VALUE) {
                return -1;
            }
            List<Edge> edges = currentVertex.edges;
            for (Edge edge : edges) {
                int candidateDistance = currentDistance + edge.weight;
                if (candidateDistance < distance[edge.vertex.id - 1]) {
                    distance[edge.vertex.id - 1] = candidateDistance;
                    queue.add(edge);
                }
            }
        }
        int max = 0;
        for (int dist : distance) {
            if (dist > max) {
                max = dist;
            }
        }
        return max;
    }

    class Vertex {
        int id;
        List<Edge> edges;

        public Vertex(int id) {
            this.id = id;
            this.edges = new ArrayList<>();
        }

        public void addEdge(Edge e) {
            this.edges.add(e);
        }
    }

    class Edge implements Comparable<Edge> {
        Vertex vertex;
        int weight;

        public Edge(Vertex vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge other) {
            return this.weight - other.weight;
        }
    }


}
