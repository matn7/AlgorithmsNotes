package medium;

import java.util.*;

public class RiverSizes2 {

    public static void main(String[] args) {

//        int[][] matrix = {
//                {1, 0, 0, 1, 0},
//                {1, 0, 1, 0, 0},
//                {0, 0, 1, 0, 1},
//                {1, 0, 1, 0, 1},
//                {1, 0, 1, 1, 0},
//        };

        int[][] matrix = {
                {1, 0, 0, 1, 0, 1, 0, 0, 1, 1, 1, 0},
                {1, 0, 1, 0, 0, 1, 1, 1, 1, 0, 1, 0},
                {0, 0, 1, 0, 1, 1, 0, 1, 0, 1, 1, 1},
                {1, 0, 1, 0, 1, 1, 0, 0, 0, 1, 0, 0},
                {1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 0, 1}
        };

        List<Integer> integers = riverSizes(matrix);

        System.out.println("==========");
        for (Integer element : integers) {
            System.out.println(element);
        }

    }

    public static List<Integer> riverSizes(int[][] matrix) {
        // Write your code here.
        Map<Integer, List<Node>> nodesMap = new HashMap<>();

        Map<String, Node> nodeInfo = new HashMap<>();

        Map<String, Coord> createdCoords = new HashMap<>();

        createNodesArray(matrix, nodesMap, createdCoords, nodeInfo);

        List<Integer> result = new ArrayList<>();
        Map<String, Boolean> visitedMap = new HashMap<>();


        List<String> expandNeighbors = new ArrayList<>();
        for (Map.Entry<String, Coord> element : createdCoords.entrySet()) {
            if (element.getValue().element.equals(Element.EXPAND)) {
                expandNeighbors.add(element.getKey());
            }
        }

        Map<String, List<String>> elemMap = new HashMap<>();
        for (String element : expandNeighbors) {
            String[] split = element.split("-");
            if (elemMap.containsKey(split[0])) {
                List<String> curentElems = elemMap.get(split[0]);
                curentElems.add(split[1]);

                elemMap.remove(split[0]);

                elemMap.put(split[0], curentElems);
            } else {
                List<String> elems = new ArrayList<>();
                elems.add(split[1]);
                elemMap.put(split[0], elems);
            }
        }

        for (Map.Entry<Integer, List<Node>> mapElement : nodesMap.entrySet()) {
            for (Node element : mapElement.getValue()) {
                if (!visitedMap.containsKey(element.value)) {
                    breadthFirst(element, result, visitedMap);
                }
            }
        }

        return result;
    }

    private static void breadthFirst(Node node, List<Integer> results, Map<String, Boolean> visitedMap) {
        Queue<Node> queue = new LinkedList<>();

        int counter = 1;

        queue.add(node);
        node.setVisited(true);
        visitedMap.put(node.value, Boolean.TRUE);

        while (!queue.isEmpty()) {
            Node poll = queue.poll();
            Set<Node> neighbors = poll.getNeighbors();

            for (Node elem : neighbors) {
                if (!elem.isVisited()) {
                    elem.setVisited(true);
                    visitedMap.put(elem.value, Boolean.TRUE);
                    queue.add(elem);
                    counter++;
                }
            }
        }

        results.add(counter);
    }

    private static void createNodesArray(int[][] matrix, Map<Integer, List<Node>> nodesMap,
                                         Map<String, Coord> createdCoords,  Map<String, Node> nodeInfo) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                if (matrix[row][col] == 1) {

                    String key = row + "-" + col;

                    if (nodeInfo.containsKey(key)) {
//                        Node node = nodeInfo.get(key);
//                        node.addNeighbor(nodeInfo.get(key));
//                        nodeInfo.get(key).addNeighbor(node);
                        continue;
                    } else {
                        Node element = new Node(key); // new
                        createdCoords.put(key, new Coord(Boolean.TRUE, Element.ROOT));
                        nodeInfo.put(key, element);
                        populateCoords(matrix, createdCoords, row, col, element, nodeInfo);

                        if (nodesMap.containsKey(row)) {
                            List<Node> multiElementList = nodesMap.get(row);
                            multiElementList.add(element);
                            nodesMap.remove(row);
                            nodesMap.put(row, multiElementList);
                        } else {
                            List<Node> oneElementList = new ArrayList<>();
                            oneElementList.add(element);
                            nodesMap.put(row, oneElementList);
                        }
                    }

                }
            }
        }
    }

    private static void populateCoords(int[][] matrix, Map<String, Coord> createdCoords, int row, int col,
                                       Node element, Map<String, Node> nodeInfo) {
        // check neighbor
        if (row > 0) {
            // check top
            if (matrix[row - 1][col] == 1) {
                String key = (row - 1) + "-" + col;
                createdCoords.put(key, new Coord(Boolean.TRUE, Element.EXPAND));
                if (nodeInfo.containsKey(key)) {
                    element.addNeighbor(nodeInfo.get(key));
                    // and vice-versa
                    nodeInfo.get(key).addNeighbor(element);
                } else {
                    Node newElement = new Node(key);
                    element.addNeighbor(newElement);
                    nodeInfo.put(key, newElement);
                }
            }
        }
        if (row < matrix.length - 1) {
            if (matrix[row + 1][col] == 1) {
                String key = (row + 1) + "-" + col;
                createdCoords.put(key, new Coord(Boolean.TRUE, Element.EXPAND));
                if (nodeInfo.containsKey(key)) {
                    element.addNeighbor(nodeInfo.get(key));
                    // and vice-versa
                    nodeInfo.get(key).addNeighbor(element);
                } else {
                    Node newElement = new Node(key);
                    element.addNeighbor(newElement);
                    nodeInfo.put(key, newElement);
                }
            }
        }
        if (col > 0) {
            if (matrix[row][col - 1] == 1) {
                String key = row + "-" + (col - 1);
                createdCoords.put(key, new Coord(Boolean.TRUE, Element.EXPAND));
                if (nodeInfo.containsKey(key)) {
                    element.addNeighbor(nodeInfo.get(key));
                    // and vice-versa
                    nodeInfo.get(key).addNeighbor(element);
                } else {
                    Node newElement = new Node(key);
                    element.addNeighbor(newElement);
                    nodeInfo.put(key, newElement);
                }
            }
        }
        if (col < matrix[0].length - 1) {
            if (matrix[row][col + 1] == 1) {
                String key = row + "-" + (col + 1);
                createdCoords.put(key, new Coord(Boolean.TRUE, Element.EXPAND));
                if (nodeInfo.containsKey(key)) {
                    element.addNeighbor(nodeInfo.get(key));
                    // and vice-versa
                    nodeInfo.get(key).addNeighbor(element);
                } else {
                    Node newElement = new Node(key);
                    element.addNeighbor(newElement);
                    nodeInfo.put(key, newElement);
                }
            }
        }
    }
//         0  1  2  3  4            0  1  2  3  4
//        [1, 0, 0, 1, 0],  0      [F, F, F, F, F],  0
//        [1, 0, 1, 0, 0],  1      [F, F, F, F, F],  1
//        [0, 0, 1, 0, 1],  2      [F, F, F, F, F],  2
//        [1, 0, 1, 0, 1],  3      [F, F, F, F, F],  3
//        [1, 0, 1, 1, 0],  4      [F, F, F, F, F],  4

    static class Coord {
        boolean visited;
        Element element;

        public Coord(boolean visited, Element element) {
            this.visited = visited;
            this.element = element;
        }
    }

    enum Element {
        ROOT, EXPAND
    }

    static class Node {
        String value;
        boolean visited;
        Set<Node> neighbors;

        public Node(String value) {
            this.value = value;
            this.neighbors = new HashSet<>();
            this.visited = false;
        }

        public boolean isVisited() {
            return visited;
        }

        public void setVisited(boolean visited) {
            this.visited = visited;
        }

        public void addNeighbor(Node node) {
            this.neighbors.add(node);
        }

        public Set<Node> getNeighbors() {
            return neighbors;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return value.equals(node.value);
        }

        @Override
        public int hashCode() {
            return Objects.hash(value);
        }
    }
}
