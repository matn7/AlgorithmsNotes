package medium;

import java.util.*;

public class CyclesInGraph {

    public static void main(String[] args) {
//        int[][] edges = {
//                {0, 1, 0, 1, 0, 0},
//                {0, 0, 1, 1, 1, 0},
//                {1, 0, 0, 0, 0, 0},
//                {0, 0, 0, 0, 0, 0},
//                {0, 0, 1, 0, 0, 1},
//                {0, 0, 0, 0, 0, 0}
//        };

//        int[][] edges = {{1, 0},
//                         {0, 1}};

//        int[][] edges = {{0, 1, 1},
//                         {0, 0, 1},
//                         {0, 0, 0}};

//        int[][] edges = {
//                {0, 0, 0, 0},
//                {1, 0, 0, 1},
//                {1, 0, 0, 0},
//                {0, 1, 1, 0}
//        };

        int[][] edges = {
                {1, 3},
                {2, 3, 4},
                {0},
                {},
                {2, 5},
                {}
        };

        CyclesInGraph cyclesInGraph = new CyclesInGraph();
        boolean result = cyclesInGraph.cycleInGraph(edges);
        System.out.println(result);
    }

    public boolean cycleInGraph(int[][] edges) {
        // Write your code here.
        if (edges.length == 0 && edges[0].length == 0) {
            return true;
        }

        Map<String, Node> nodesMap = new HashMap<>();
        for (int row = 0; row < edges.length; row++) {
            nodesMap.put(String.valueOf(row), new Node(String.valueOf(row)));
        }

        List<List<Integer>> array = new ArrayList<>();
        for (int i = 0; i < edges.length; i++) {
            array.add(i, new ArrayList<>());
        }

        for (int row = 0; row < edges.length; row++) {
            for (int col = 0; col < edges[row].length; col++) {
                List<Integer> integers = array.get(row);
                integers.add(edges[row][col]);
                array.remove(row);
                array.add(row, integers);
            }
        }


        for (int row = 0; row < edges.length; row++) {
            for (int col = 0; col < edges[row].length; col++) {
//                if (edges[row][col] == 1) {
//                    nodesMap.get(String.valueOf(row)).addNeighbors(nodesMap.get(String.valueOf(col)));
//                }
                if (!array.get(row).isEmpty()) {
                    for (Integer element : array.get(row)) {
                        if (!nodesMap.get(String.valueOf(row)).getNeighbors()
                                .contains(nodesMap.get(String.valueOf(element)))) {
                            nodesMap.get(String.valueOf(row)).addNeighbors(nodesMap.get(String.valueOf(element)));
                        }
                    }
                }
            }
        }

        CycleDetected cycleDetected = new CycleDetected();

        Collection<Node> values = nodesMap.values();

        for (Node element : values) {
            if (!element.isVisited()) {
                depthFirst(element, cycleDetected);
            }
        }


        return cycleDetected.isValue();
    }

    public void depthFirst(Node node, CycleDetected cycleDetected) {

        node.setBeingVisited(true);
        System.out.println(node);

        List<Node> neighbors = node.getNeighbors();
        for (Node element : neighbors) {

            if (element.isBeingVisited()) {
                System.out.println("Cycle for element: " + element);
                cycleDetected.setValue(true);
            }

            if (!element.visited) {
                element.setVisited(true);
                depthFirst(element, cycleDetected);
            }
        }

        node.setBeingVisited(false);
        node.setVisited(true);
    }

    class CycleDetected {
        boolean value;

        public CycleDetected() {
            this.value = false;
        }

        public void setValue(boolean value) {
            this.value = value;
        }

        public boolean isValue() {
            return value;
        }
    }

    class Node {
        String value;
        List<Node> neighbors;
        boolean beingVisited;
        boolean visited;

        public Node(String value) {
            this.value = value;
            this.neighbors = new ArrayList<>();
            this.beingVisited = false;
            this.visited = false;
        }

        public void addNeighbors(Node node) {
            this.neighbors.add(node);
        }

        public List<Node> getNeighbors() {
            return neighbors;
        }

        public boolean isVisited() {
            return visited;
        }

        public void setVisited(boolean visited) {
            this.visited = visited;
        }

        public boolean isBeingVisited() {
            return beingVisited;
        }

        public void setBeingVisited(boolean beingVisited) {
            this.beingVisited = beingVisited;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return Objects.equals(value, node.value);
        }

        @Override
        public int hashCode() {
            return Objects.hash(value);
        }

        @Override
        public String toString() {
            return value;
        }
    }
}

//  "edges": [
//          [1, 3],
//          [2, 3, 4],
//          [0],
//          [],
//          [2, 5],
//          []
//          ]