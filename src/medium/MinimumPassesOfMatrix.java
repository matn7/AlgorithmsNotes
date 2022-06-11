package medium;

import java.util.*;

public class MinimumPassesOfMatrix {

    public static void main(String[] args) {
        int[][] matrix = {
                {0, -2, -1},
                {-5, 2, 0},
                {-6, -2, 0}
        };

        MinimumPassesOfMatrix minimumPassesOfMatrix = new MinimumPassesOfMatrix();
        int result = minimumPassesOfMatrix.minimumPassesOfMatrix(matrix);

        System.out.println(result);
    }

    public int minimumPassesOfMatrix(int[][] matrix) {
        // Write your code here.
        Map<String, Node> nodeMap = new HashMap<>();
        populateNodesMap(matrix, nodeMap);

        Collection<Node> nodes = nodeMap.values();

        boolean isNegativeElement = false;

        // Visit
        for (Node element : nodes) {
            if (element.value < 0) {
                isNegativeElement = true;
                break;
            }
        }
        if (!isNegativeElement) {
            // no negative element found return immediately
            return 0;
        }

        int counter = 0;
        int numberOfCycles = 0;
        while (isNegativeElement) {
            numberOfCycles++;
            for (Node element : nodes) {
                if (!element.isVisited()) {
                    breadthFirst(element);
                }
            }

            for (Node element : nodes) {
                if (element.isEligibleForSignChange()) {
                    element.setValue(element.getValue() * (-1));
                    System.out.println(element.value + " changed");
                    element.setEligibleForSignChange(false);
                }
            }

            // check for negative elements
            for (Node element : nodes) {
                if (element.value < 0) {
                    isNegativeElement = true;
                    break;
                } else {
                    isNegativeElement = false;
                }
            }

            // still some negatives, do over
            resetVisited(nodes);
        }

        return numberOfCycles;
    }

    private void resetVisited(Collection<Node> nodes) {
        // reset visited
        for (Node element : nodes) {
            element.setVisited(false);
        }
    }

    public void depthFirst(Node element) {

        if (element.isVisited()) {
            return;
        }

        System.out.print(element.value + "  ");

        element.setVisited(true);

        Set<Node> neighbors = element.getNeighbors();

        for (Node elem : neighbors) {
            depthFirst(elem);
        }

    }

    public void breadthFirst(Node element) {

        Queue<Node> queue = new LinkedList<>();

        queue.add(element);

        while (!queue.isEmpty()) {

            boolean isEligibleForSignChange = false;

            Node poll = queue.poll();
            poll.setVisited(true);
//            System.out.println(poll.value);
            if (poll.value == -5) {
                System.out.println();
            }

            Set<Node> neighbors = poll.getNeighbors();
            // check whether neighbors
            if (poll.value < 0) {
                int count = 0;
                for (Node elem : neighbors) {
                    if (elem.value > 0) {
                        count++;
                    }
                }
                if (count >= 1) {
                    isEligibleForSignChange = true;
                    poll.setEligibleForSignChange(true);
                }
            }


            for (Node elem : neighbors) {
                if (!elem.isVisited()) {
                    elem.setVisited(true);
                    queue.add(elem);
                }
            }
        }

    }

    private void populateNodesMap(int[][] matrix, Map<String, Node> nodeMap) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == -5) {
                    System.out.println();
                }
                String key = row + "-" + col;
                if (nodeMap.containsKey(key)) {
                    Node node = nodeMap.get(key);
                    populateNeighbors(matrix, nodeMap, row, col, node);
                } else {
                    Node element = new Node(matrix[row][col]);
                    nodeMap.put(key, element);
                    populateNeighbors(matrix, nodeMap, row, col, element);
                }
            }
        }
    }

    private void populateNeighbors(int[][] matrix, Map<String, Node> nodeMap, int row, int col, Node element) {
        // North
        if (row - 1 >= 0) {
            String key1 = (row - 1) + "-" + col;
            if (nodeMap.containsKey(key1)) {
                // add neighbors back to out element
                element.addNeighbor(nodeMap.get(key1));
                nodeMap.get(key1).addNeighbor(element);
            } else {
                Node newNode = new Node(matrix[row-1][col]);
                nodeMap.put(key1, newNode);
                element.addNeighbor(newNode);
            }
        }
        // South
        if (row + 1 < matrix.length) {
            String key1 = (row + 1) + "-" + col;
            if (nodeMap.containsKey(key1)) {
                // node already exists
                element.addNeighbor(nodeMap.get(key1));
                nodeMap.get(key1).addNeighbor(element);
            } else {
              Node newNode = new Node(matrix[row + 1][col]);
              nodeMap.put(key1, newNode);
              element.addNeighbor(newNode);
            }
        }
        // West
        if (col - 1 >= 0) {
            String key1 = row + "-" + (col - 1);
            if (nodeMap.containsKey(key1)) {
                element.addNeighbor(nodeMap.get(key1));
                nodeMap.get(key1).addNeighbor(element);
            } else {
                Node newNode = new Node(matrix[row][col - 1]);
                nodeMap.put(key1, newNode);
                element.addNeighbor(newNode);
            }
        }
        // East
        if (col + 1 < matrix[row].length) {
            String key1 = row + "-" + (col + 1);
            if (nodeMap.containsKey(key1)) {
                element.addNeighbor(nodeMap.get(key1));
                nodeMap.get(key1).addNeighbor(element);
            } else {
                Node newNode = new Node((matrix[row][col + 1]));
                nodeMap.put(key1, newNode);
                element.addNeighbor(newNode);
            }
        }
    }

    class Node {
        int value;
        Set<Node> neighbors;
        boolean visited;
        boolean isEligibleForSignChange;

        public Node(int value) {
            this.value = value;
            this.neighbors = new HashSet<>();
            this.visited = false;
            this.isEligibleForSignChange = false;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public void addNeighbor(Node node) {
            this.neighbors.add(node);
        }

        public Set<Node> getNeighbors() {
            return neighbors;
        }

        public boolean isVisited() {
            return visited;
        }

        public void setVisited(boolean visited) {
            this.visited = visited;
        }

        public boolean isEligibleForSignChange() {
            return isEligibleForSignChange;
        }

        public void setEligibleForSignChange(boolean eligibleForSignChange) {
            isEligibleForSignChange = eligibleForSignChange;
        }
    }

}
