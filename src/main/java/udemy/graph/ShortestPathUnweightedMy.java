package udemy.graph;

import java.util.*;

public class ShortestPathUnweightedMy {

    public static void main(String[] args) {
        int[][] graph = {
                {1, 2}, // 0 - A
                {},    // 1 - B
                {4},    // 2 - C
                {},     // 3 - D
                {1, 3}  // 4 - E
        };

        List<Integer> path = shortestPath(graph, 0, 3);

        for (Integer p : path) {
            System.out.print(p + " -> ");
        }
    }

    // O(v + e) time
    public static List<Integer>  shortestPath(int[][] graph, int source, int destination) {
        Map<Integer, Vertex> graphMap = new HashMap<>();
        for (int i = 0; i < graph.length; i++) {
            graphMap.put(i, new Vertex(i));
        }

        for (int i = 0; i < graph.length; i++) {
            Vertex currentVertex = graphMap.get(i);
            int[] vertexNeighbors = graph[i];
            for (int neighbor : vertexNeighbors) {
                Vertex neighborVertex = graphMap.get(neighbor);
                currentVertex.addNeighbor(neighborVertex);
            }
        }

        Vertex sourceVertex = graphMap.get(source);
        Vertex destinationVertex = graphMap.get(destination);
        sourceVertex.distance = 0;

        LinkedList<Vertex> queue = new LinkedList<>();
        queue.add(sourceVertex);

        while (!queue.isEmpty()) {
            Vertex currentVertex = queue.pollFirst();
            if (currentVertex == destinationVertex) {
                break;
            }
            List<Vertex> neighbors = currentVertex.neighbors;
            for (Vertex neighbor : neighbors) {
                int newDistance = currentVertex.distance + 1;
                if (neighbor.distance == -1) {
                    neighbor.distance = newDistance;
                    neighbor.cameFrom = currentVertex;
                    queue.add(neighbor);
                } else {
                    // if came here not possible to update distance to be lower than already set
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

    public static class Vertex {
        int id;
        int distance;
        Vertex cameFrom;
        List<Vertex> neighbors;

        public Vertex(int id) {
            this.id = id;
            this.distance = -1;
            this.cameFrom = null;
            this.neighbors = new ArrayList<>();
        }

        public void addNeighbor(Vertex vertex) {
            this.neighbors.add(vertex);
        }
    }

}
