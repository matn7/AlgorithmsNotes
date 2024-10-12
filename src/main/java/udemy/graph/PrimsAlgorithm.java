package udemy.graph;

import java.util.*;

public class PrimsAlgorithm {

    public static void spanningTree(Graph graph, int source) {
        Map<Integer, DistanceInfo> distanceTable = new HashMap<>();
        PriorityQueue<VertexInfo> queue = new PriorityQueue<>(new Comparator<VertexInfo>() {
            @Override
            public int compare(VertexInfo v1, VertexInfo v2) {
                return ((Integer) v1.getDistance()).compareTo(v2.getDistance());
            }
        });

        for (int j = 0; j < graph.getNumVertices(); j++) {
            distanceTable.put(j, new DistanceInfo());
        }

        distanceTable.get(source).setDistance(0);
        distanceTable.get(source).setLastVertex(source);

        Map<Integer, VertexInfo> vertexInfoMap = new HashMap<>();

        VertexInfo sourceVertexInfo = new VertexInfo(source, 0);
        queue.add(sourceVertexInfo);
        vertexInfoMap.put(source, sourceVertexInfo);

        Set<String> spanningTree = new HashSet<>();
        Set<Integer> visitedVertices = new HashSet<>();

        while (!queue.isEmpty()) {
            VertexInfo vertexInfo = queue.poll();
            int currentVertex = vertexInfo.getVertexId();

            // do not re-visit vertices which are already part of the tree
            if (visitedVertices.contains(currentVertex)) {
                continue;
            }
            visitedVertices.add(currentVertex);

            // if the current vertex is a source we do not have an edge yet
            if (currentVertex != source) {
                String edge = String.valueOf(currentVertex) + String.valueOf(distanceTable.get(currentVertex).getLastVertex());
                if (!spanningTree.contains(edge)) {
                    spanningTree.add(edge);
                }
            }

            for (Integer neighbor : graph.getAdjacentVertices(currentVertex)) {
                int distance = graph.getWeightedEdge(currentVertex, neighbor);

                // if we find a new shortest path to the neighbor update the distance and the last vertex
                if (distanceTable.get(neighbor).getDistance() > distance) {
                    distanceTable.get(neighbor).setDistance(distance);
                    distanceTable.get(neighbor).setLastVertex(currentVertex);

                    VertexInfo neighborVertexInfo = vertexInfoMap.get(neighbor);
                    if (neighborVertexInfo != null) {
                        queue.remove(neighborVertexInfo);
                    }

                    neighborVertexInfo = new VertexInfo(neighbor, distance);
                    vertexInfoMap.put(neighbor, neighborVertexInfo);
                    queue.add(neighborVertexInfo);
                }
            }
        }

        for (String edge : spanningTree) {
            System.out.println(edge);
        }
    }

    // a simple class which holds the vertex id and the weight of the edge that leads to that vertex from its neighbor
    public static class VertexInfo {
        private int vertexId;
        private int distance;

        public VertexInfo(int vertexId, int distance) {
            this.vertexId = vertexId;
            this.distance = distance;
        }

        public int getVertexId() {
            return vertexId;
        }

        public int getDistance() {
            return distance;
        }
    }

    public static class DistanceInfo {
        private int distance;
        private int lastVertex;

        public DistanceInfo() {
            this.distance = Integer.MAX_VALUE;
            this.lastVertex = -1;
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
