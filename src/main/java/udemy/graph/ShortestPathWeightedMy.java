package udemy.graph;

import java.util.*;

public class ShortestPathWeightedMy {

    public static void main(String[] args) {
        int[][][] graph = {
                {{1, 2}, {2, 3}},   // A - 0
                {{3, 21}, {4, 5}},  // B - 1
                {{4, 6}},           // C - 2
                {},                 // D - 3
                {{3, 4}}            // E - 4
        };

        int[][][] graph2 = {
                {{1, 2}, {2, 3}},   // A - 0
                {{3, 2}},           // B - 1
                {{4, 6}},           // C - 2
                {},                 // D - 3
                {{1, -5}, {3, -6}}  // E - 4
        };

        int source = 0;
        int destination = 3;

        shortestPath(graph, source, destination);
    }

    // Dijkstra's, Bellman Ford but without PQ?
    public static List<Integer> shortestPath(int[][][] graph, int source, int destination) {
        Map<Integer, Vertex> graphMap = new HashMap<>();

        for (int i = 0; i < graph.length; i++) {
            graphMap.put(i, new Vertex(i));
        }

        for (int i = 0; i < graph.length; i++) {
            int[][] edges = graph[i];
            Vertex currentVertex = graphMap.get(i);
            for (int[] edge : edges) {
                Vertex neighborVertex = graphMap.get(edge[0]);
                currentVertex.addNeighbor(neighborVertex);
            }
        }

        Vertex sourceVertex = graphMap.get(source);
        Vertex destinationVertex = graphMap.get(destination);
        sourceVertex.distance = 0;

        PriorityQueue<Vertex> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(sourceVertex);

        while (!priorityQueue.isEmpty()) {
            Vertex current = priorityQueue.poll();
            List<Vertex> neighbors = current.neighbors;
            if (current == destinationVertex) {
                break;
            }
            for (int i = 0; i < neighbors.size(); i++) {
                Vertex neighbor = neighbors.get(i);
                int[] edge = graph[current.id][i]; // [1, 2]
                int newDistance = current.distance + edge[1]; // 0 + 2
                if (newDistance < neighbor.distance) {
                    neighbor.distance = newDistance;
                    neighbor.cameFrom = current;
                    priorityQueue.add(neighbor);
                }
            }
        }

        List<Integer> path = new ArrayList<>();
        Vertex current = destinationVertex;
        while (current != null) {
            path.add(current.id);
            current = current.cameFrom;
        }

        Collections.reverse(path);
        return path;
    }

    public static class Vertex implements Comparable<Vertex> {
        int id;
        int distance;
        Vertex cameFrom;
        List<Vertex> neighbors;

        public Vertex(int id) {
            this.id = id;
            this.distance = Integer.MAX_VALUE;
            this.cameFrom = null;
            this.neighbors = new ArrayList<>();
        }

        public void addNeighbor(Vertex v) {
            this.neighbors.add(v);
        }

        @Override
        public int compareTo(Vertex o) {
            return this.distance - o.distance;
        }
    }

}
