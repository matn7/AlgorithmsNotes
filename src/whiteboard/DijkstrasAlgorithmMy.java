package whiteboard;

import java.util.*;

public class DijkstrasAlgorithmMy {

    public static void main(String[] args) {
        int[][][] edges = {
                {{1,7}},
                {{2,6}, {3,20}, {4,3}},
                {{3,11}},
                {{4,2}},
                {},
                {}
        };

        DijkstrasAlgorithmMy dijkstrasAlgorithmMy = new DijkstrasAlgorithmMy();
        dijkstrasAlgorithmMy.dijkstrasAlgorithm(0, edges);
    }

    public int[] dijkstrasAlgorithm(int start, int[][][] edges) {
        // Write your code here.
        if (edges.length == 0) {
            return new int[] {};
        }
        Map<Integer, Vertex> adjList = new HashMap<>();
        for (int i = 0; i < edges.length; i++) {
            adjList.put(i, new Vertex(i));
        }
        for (int i = 0; i < edges.length; i++) {
            int[][] edge = edges[i];
            Vertex current = adjList.get(i);
            for (int j = 0; j < edge.length; j++) {
                int[] e = edge[j];
                Vertex neighbor = adjList.get(e[0]);
                int weight = e[1];
                current.addEdge(new Edge(neighbor, weight));
            }
        }
        int[] distance = new int[edges.length];
        Arrays.fill(distance, Integer.MAX_VALUE);

        Vertex startVertex = adjList.get(start);
        distance[start] = 0;
        Queue<Vertex> queue = new LinkedList<>();
        queue.add(startVertex);

        while (!queue.isEmpty()) {
            Vertex current = queue.poll();
            if (current.visited) {
                continue;
            }
            current.visited = true;
            List<Edge> neighbors = current.edges;
            for (Edge neighbor : neighbors) {
                int neighborId = neighbor.vertex.id;
                int neighborWeight = neighbor.weight;
                int newDistance = distance[current.id] + neighborWeight;
                if (newDistance < distance[neighborId]) {
                    distance[neighborId] = newDistance;
                    queue.add(neighbor.vertex);
                }
            }
        }
        for (int i = 0; i < distance.length; i++) {
            if (distance[i] == Integer.MAX_VALUE) {
                distance[i] = -1;
            }
        }

        return distance;
    }

    class Vertex {
        int id;
        boolean visited;
        List<Edge> edges;

        public Vertex(int id) {
            this.id = id;
            this.edges = new ArrayList<>();
        }

        public void addEdge(Edge e) {
            this.edges.add(e);
        }
    }

    class Edge {
        Vertex vertex;
        int weight;

        public Edge(Vertex vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }
    }

}
