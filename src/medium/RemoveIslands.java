package medium;

import java.util.*;

public class RemoveIslands {

    public static void main(String[] args) {
//        int[][] matrix = {
//                {1, 0, 0, 0, 0, 0},
//                {0, 0, 0, 1, 1, 1},
//                {0, 0, 0, 0, 1, 0},
//                {1, 1, 0, 0, 1, 0},
//                {1, 0, 0, 0, 0, 0},
//                {1, 0, 0, 0, 0, 1}
//        };

        int[][] matrix = {
                {1, 0, 0, 0, 0, 0},
                {0, 1, 0, 1, 1, 1},
                {0, 0, 1, 0, 1, 0},
                {1, 1, 0, 0, 1, 0},
                {1, 0, 1, 1, 0, 0},
                {1, 0, 0, 0, 0, 1}
        };

        RemoveIslands removeIslands = new RemoveIslands();
        removeIslands.removeIslands(matrix);
    }

    public int[][] removeIslands(int[][] matrix) {
        // Write your code here.

        Map<String, Node> createdNodeInfoMap = new HashMap<>();

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                if (matrix[row][col] == 1) {
                    // create new node
                    if (createdNodeInfoMap.containsKey(row + "-" + col)) {
                        addNeighbors(matrix, createdNodeInfoMap, row, col, createdNodeInfoMap.get(row + "-" + col));
                    } else {
                        Node element = new Node(row + "-" + col);
                        if (isBorder(matrix, row, col)) {
                            element.setBorder(true);
                        }
                        createdNodeInfoMap.put(row + "-" + col, element);
                        addNeighbors(matrix, createdNodeInfoMap, row, col, element);
                    }
                }
            }
        }

        // Relax look for missed connections
        for (Map.Entry<String, Node> element : createdNodeInfoMap.entrySet()) {
            Node currentNode = element.getValue(); // 1-5
            if (currentNode.value.equals("1-5")) {
                System.out.println();
            }
            for (Node oneNode : currentNode.getNeighbors()) {
                Node innerNode = createdNodeInfoMap.get(oneNode.getValue());// 1-4
                // check whether 1-4 has 1-5 as a neighbors
                if (!innerNode.getNeighbors().contains(currentNode)) {
                    innerNode.addNeighbor(currentNode);
                    System.out.println();
                }
            }
        }

        Map<String, Node> noBorderNodes = new HashMap<>();
        noBorderNodes.putAll(createdNodeInfoMap);
        for (Map.Entry<String, Node> element : createdNodeInfoMap.entrySet()) {
//            if (!element.getValue().isBorder()) {
//                noBorderNodes.put(element.getKey(), element.getValue());
//            }
            if (element.getValue().isBorder()) {
                breadthFirst(element.getValue(), noBorderNodes);
            }
        }

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                if (noBorderNodes.containsKey(row + "-" + col)) {
                    matrix[row][col] = 0;
                }
            }
        }

        return matrix;
    }

    public List<String> breadthFirst(Node node, Map<String, Node> noBorderNodes) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        List<String> result = new ArrayList<>();
        System.out.println("=========");
        while (!queue.isEmpty()) {
            Node poll = queue.poll();
            System.out.println(poll.value);
            noBorderNodes.remove(poll.value);

            poll.setVisited(true);

            result.add(poll.value);

            for (Node element : poll.getNeighbors()) {
                if (!element.isVisited()) {
                    element.setVisited(true);
                    queue.add(element);
                }
            }
        }

        return result;
    }

    private boolean isBorder(int[][] matrix, int row, int col) {
        return row == 0 || row == matrix.length - 1 || col == 0 || col == matrix[0].length - 1;
    }

    private void addNeighbors(int[][] matrix, Map<String, Node> createdNodeInfoMap, int row, int col, Node element) {
        // add neighbors
        // NORTH
        if (row - 1 > 0) {
            String key = (row - 1) + "-" + col;
            if (matrix[row - 1][col] == 1) {
                if (createdNodeInfoMap.containsKey(key)) {
                    // 2 way connection
                    element.addNeighbor(createdNodeInfoMap.get(key));
                } else {
                    Node newNode = new Node(key);
                    if (isBorder(matrix, row - 1, col)) {
                        newNode.setBorder(true);
                    }
                    element.addNeighbor(newNode);
                    createdNodeInfoMap.put(key, newNode);
                }
            }
        }
        // SOUTH
        if (row + 1 < matrix.length - 1) {
            String key = (row + 1) + "-" + col;
            if (matrix[row + 1][col] == 1) {
                if (createdNodeInfoMap.containsKey(key)) {
                    // 2 way connection
                    element.addNeighbor(createdNodeInfoMap.get(key));
                } else {
                    Node newNode = new Node(key);
                    if (isBorder(matrix, row + 1, col)) {
                        newNode.setBorder(true);
                    }
                    element.addNeighbor(newNode);
                    createdNodeInfoMap.put(key, newNode);
                }
            }
        }
        // WEST
        if (col - 1 > 0) {
            String key = row + "-" + (col - 1);
            if (matrix[row][col - 1] == 1) {
                if (createdNodeInfoMap.containsKey(key)) {
                    // 2 way connection
                    element.addNeighbor(createdNodeInfoMap.get(key));
                } else {
                    Node newNode = new Node(key);
                    if (isBorder(matrix, row, col - 1)) {
                        newNode.setBorder(true);
                    }
                    element.addNeighbor(newNode);
                    createdNodeInfoMap.put(key, newNode);
                }
            }
        }
        // EAST
        if (col + 1 < matrix[0].length - 1) {
            String key = row + "-" + (col + 1);
            if (matrix[row][col + 1] == 1) {
                if (createdNodeInfoMap.containsKey(key)) {
                    // 2 way connection
                    element.addNeighbor(createdNodeInfoMap.get(key));
                } else {
                    Node newNode = new Node(key);
                    if (isBorder(matrix, row, col + 1)) {
                        newNode.setBorder(true);
                    }
                    element.addNeighbor(newNode);
                    createdNodeInfoMap.put(key, newNode);
                }
            }
        }
    }

    class Node {
        String value;
        Set<Node> neighbors;
        boolean border;
        boolean visited;

        public Node(String value) {
            this.value = value;
            this.neighbors = new HashSet<>();
            this.border = false;
            this.visited = false;
        }

        public void addNeighbor(Node node) {
            this.neighbors.add(node);
        }

        public String getValue() {
            return value;
        }

        public Set<Node> getNeighbors() {
            return neighbors;
        }

        public boolean isBorder() {
            return border;
        }

        public void setBorder(boolean border) {
            this.border = border;
        }

        public boolean isVisited() {
            return visited;
        }

        public void setVisited(boolean visited) {
            this.visited = visited;
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
