package udemy.graph;

import java.util.*;

public class KruskalsAlgorithm {

    public static void spanningTree(Graph graph) {
        // a priority queue to store and retrieve the edges on the basis of their weights.
        PriorityQueue<EdgeInfo> queue = new PriorityQueue<>(new Comparator<EdgeInfo>() {
            @Override
            public int compare(EdgeInfo o1, EdgeInfo o2) {
                return o1.getWeight().compareTo(o2.getWeight());
            }
        });

        // add all edges to the priority queue
        for (int i = 0; i < graph.getNumVertices(); i++) {
            for (int neighbor : graph.getAdjacentVertices(i)) {
                queue.add(new EdgeInfo(i, neighbor, graph.getWeightedEdge(i, neighbor)));
            }
        }

        Set<Integer> visitedVertices = new HashSet<>();
        Set<EdgeInfo> spanningTree = new HashSet<>();
        Map<Integer, Set<Integer>> edgeMap = new HashMap<>();
        for (int v = 0; v < graph.getNumVertices(); v++) {
            edgeMap.put(v, new HashSet<>());
        }

        while (!queue.isEmpty() && spanningTree.size() < graph.getNumVertices() - 1) {
            EdgeInfo currentEdge = queue.poll();

            // Add the new edge to the edge map and see if it ends up with a cycle.
            // If yes then discard this edge and get the next edge from the priority queue.
            edgeMap.get(currentEdge.getVertex1()).add(currentEdge.getVertex2());
            if (hasCycle(edgeMap)) {
                edgeMap.get(currentEdge.getVertex1()).remove(currentEdge.getVertex2());
                continue;
            }

            spanningTree.add(currentEdge);

            // Add both vertices to the visited list, the set will endure that only one copy of the vertex exists.
            visitedVertices.add(currentEdge.getVertex1());
            visitedVertices.add(currentEdge.getVertex2());
        }

        // check whether all vertices have been covered with the spanning tree.
        if (visitedVertices.size() != graph.getNumVertices()) {
            System.out.println("Minimum Spanning Tree is not possible");;
        } else {
            System.out.println("Minimum Spanning Tree using Kruskal's Algorithm");
            for (EdgeInfo edgeInfo : spanningTree) {
                System.out.println(edgeInfo);
            }
        }
    }

    private static boolean hasCycle(Map<Integer, Set<Integer>> edgeMap) {
        for (Integer sourceVertex : edgeMap.keySet()) {
            LinkedList<Integer> queue = new LinkedList<>();
            queue.add(sourceVertex);
            Set<Integer> visitedVertices = new HashSet<>();
            while (!queue.isEmpty()) {
                int currentVertex = queue.pollLast();
                if (visitedVertices.contains(currentVertex)) {
                    return true;
                }

                visitedVertices.add(currentVertex);
                queue.addAll(edgeMap.get(currentVertex));
            }
        }
        return false;
    }

    // a class which represents an edge in an undirected weighted graph
    public static class EdgeInfo {
        private Integer vertex1;
        private Integer vertex2;
        private Integer weight;

        public EdgeInfo(Integer vertex1, Integer vertex2, Integer weight) {
            this.vertex1 = vertex1;
            this.vertex2 = vertex2;
            this.weight = weight;
        }

        public Integer getVertex1() {
            return vertex1;
        }

        public Integer getVertex2() {
            return vertex2;
        }

        public Integer getWeight() {
            return weight;
        }

        @Override
        public String toString() {
            return "" + vertex1 + vertex2;
        }
    }

}
