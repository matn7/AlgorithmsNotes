package udemy.graph;

import java.util.*;

public class BellmanFord {

    public static void shortestPath(Graph graph, Integer source, Integer destination) {
        Map<Integer, DistanceInfo> distanceTable = buildDistanceTable(graph, source);

        Stack<Integer> stack = new Stack<>();
        stack.push(destination);

        int previousVertex = distanceTable.get(destination).getLastVertex();
        while (previousVertex != -1 && previousVertex != source) {
            stack.push(previousVertex);
            previousVertex = distanceTable.get(previousVertex).getLastVertex();
        }

        if (previousVertex == -1) {
            System.out.println("There is no path from node: " + source + " to node: " + destination);
        } else {
            System.out.print("Smallest Path is " + source);
            while (!stack.isEmpty()) {
                System.out.print(" -> " + stack.pop());
            }
            System.out.println(" Bellman Ford Done!");
        }
    }

    public static Map<Integer, DistanceInfo> buildDistanceTable(Graph graph, int source) {
        Map<Integer, DistanceInfo> distanceTable = new HashMap<>();
        for (int j = 0; j < graph.getNumVertices(); j++) {
            distanceTable.put(j, new DistanceInfo());
        }

        distanceTable.get(source).setDistance(0);
        distanceTable.get(source).setLastVertex(source);

        // set up a simple queue to explore all the vertices regardless of priority
        LinkedList<Integer> queue = new LinkedList<>();

        // relaxing (processing) all the edges numVertices - 1 times
        for (int numIterations = 0; numIterations < graph.getNumVertices() - 1; numIterations++) {
            // add every vertex to the queue so we're sure to access all the edges in the graph
            for (int v = 0; v < graph.getNumVertices(); v++) {
                queue.add(v);
            }

            // keep track of the edges visited so we visit each edge just once in every iteration
            Set<String> visitedEdges = new HashSet<>();
            while (!queue.isEmpty()) {
                int currentVertex = queue.pollFirst();

                for (int neighbor : graph.getAdjacentVertices(currentVertex)) {
                    // "01" - is an edge going from vertex 0 to vertex 1
                    String edge = String.valueOf(currentVertex) + String.valueOf(neighbor);

                    // do not visit edges more than once in each iteration
                    if (visitedEdges.contains(edge)) {
                        continue;
                    }
                    visitedEdges.add(edge);

                    int distance = distanceTable.get(currentVertex).getDistance()
                            + graph.getWeightedEdge(currentVertex, neighbor);

                    // if we find a new shortest path to the neighbor update the distance and the last vertex
                    if (distanceTable.get(neighbor).getDistance() > distance) {
                        distanceTable.get(neighbor).setDistance(distance);
                        distanceTable.get(neighbor).setLastVertex(currentVertex);
                    }
                }
            }
        }

        // add all the vertices to the queue on last time to check for a negative cycle
        for (int v = 0; v < graph.getNumVertices(); v++) {
            queue.add(v);
        }

        // relaxing (processing) all the edges one last time to check if there exists a negative cycle
        while (!queue.isEmpty()) {
            int currentVertex = queue.pollFirst();
            for (int neighbor : graph.getAdjacentVertices(currentVertex)) {
                int distance = distanceTable.get(currentVertex).getDistance()
                        + graph.getWeightedEdge(currentVertex, neighbor);
                if (distanceTable.get(neighbor).getDistance() > distance) {
                    throw new IllegalArgumentException("The Graph has a -ve cycle");
                }
            }
        }

        return distanceTable;
    }

    public static class DistanceInfo {
        private int distance;
        private int lastVertex;

        public DistanceInfo() {
            // because of adding ro Integer.MAX causes the integer to overflow and become a negative value
            // - this negative value can interfere with the algorithm
            this.distance = 100000;
            lastVertex = -1;
        }

        public int getDistance() {
            return distance;
        }

        public void setDistance(int distance) {
            this.distance = distance;
        }

        public int getLastVertex() {
            return lastVertex;
        }

        public void setLastVertex(int lastVertex) {
            this.lastVertex = lastVertex;
        }
    }

}
