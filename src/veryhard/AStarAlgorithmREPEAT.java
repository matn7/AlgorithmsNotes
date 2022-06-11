package veryhard;

import java.util.*;

public class AStarAlgorithmREPEAT {

    public static void main(String[] args) {
        AStarAlgorithmREPEAT aStarAlgorithm = new AStarAlgorithmREPEAT();
        int[][] graph = {
                {0, 0, 0, 0, 0},
                {0, 1, 1, 1, 0},
                {0, 0, 0, 0, 0},
                {1, 0, 1, 1, 1},
                {0, 0, 0, 0, 0}
        };

//        int[][] graph = {
//                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
//                {1, 0, 0, 0, 0, 0, 0, 0, 0, 1},
//                {1, 1, 0, 1, 1, 1, 1, 1, 0, 1},
//                {1, 1, 0, 0, 0, 1, 0, 1, 0, 1},
//                {1, 1, 0, 0, 0, 1, 0, 1, 0, 1},
//                {1, 1, 0, 0, 0, 1, 0, 1, 0, 1},
//                {1, 1, 0, 0, 0, 1, 0, 1, 0, 1},
//                {1, 1, 0, 0, 0, 1, 0, 1, 0, 1},
//                {1, 1, 1, 1, 1, 1, 0, 0, 0, 1},
//                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
//        };
        // rec(1,1,)
        aStarAlgorithm.aStarAlgorithm(0, 1, 4, 3, graph);
    }

    // OK - repeated 21/02/2022
    // O(w*h*low(w*h)) time | O(w*h) space
    public int[][] aStarAlgorithm(int startRow, int startCol, int endRow, int endCol, int[][] graph) {
        // Write your code here.
        // H: heuristic value
        // G: current shortest distance
        // F: G + H
        List<List<Node>> nodes = initializeNodes(graph);
        // nodes =
        // [
        //  [(0,0,0), (0,1,0), (0,2,0), (0,3,0), (0,4,0)],
        //  [(1,0,0), (1,1,1), (1,2,1), (1,3,1), (1,4,0)],
        //  [(2,0,0), (2,1,0), (2,2,0), (2,3,0), (2,4,0)],
        //  [(3,0,1), (3,1,0), (3,2,1), (3,3,1), (3,4,1)],
        //  [(4,0,0), (4,1,0), (4,2,0), (4,3,0), (4,4,0)]
        // ]

        // Node(id, row, col, value, distanceFromStart, estimatedDistanceToEnd, comeFrom)
        Node startNode = nodes.get(startRow).get(startCol);
        Node endNode = nodes.get(endRow).get(endCol); // (4,3,0)

        startNode.distanceFromStart = 0;
        startNode.estimatedDistanceToEnd = calculateManhattanDistance(startNode, endNode);

        // startNode = ("0-1", 0, 1, 0, 0, 6)
        List<Node> nodeList = new ArrayList<>();
        nodeList.add(startNode); // [(0,1,0)]

        MinHeap nodesToVisit = new MinHeap(nodeList);

        //   0   1   2   3   4
        // +---+---+---+---+---+
        // | v | S | v | v | v |    0
        // +---+---+---+---+---+
        // |   | # | # | # |   |    1
        // +---+---+---+---+---+
        // |   |   |   |   |   |    2
        // +---+---+---+---+---+
        // | # |   | # | # | # |    3
        // +---+---+---+---+---+
        // |   |   |   | E |   |    4
        // +---+---+---+---+---+

        //                  ("1-4", 1, 4, 0, 4, 8, "0-4")
        //          ("0-0", 0, 0, 0, 1, 8, "0-1")
        //
        //

        while (!nodesToVisit.isEmpty()) {
            Node currentMinDistanceNode = nodesToVisit.remove(); // ("0-4", 0, 4, 0, 3, 8, "0-3")
            if (currentMinDistanceNode == endNode) {
                break;
            }

            // rec(("0-4", 0, 4, 0, 3, 8, "0-3"), [[]])
            List<Node> neighbors = getNeighboringNodes(currentMinDistanceNode, nodes);
            //              *
            // [(1,4,0), (0,3,0)]
            for (Node neighbor : neighbors) {
                if (neighbor.value == 1) {
                    continue;
                }

                int tenativeDistanceToNeighbor = currentMinDistanceNode.distanceFromStart + 1; // 3 + 1 = 4

                if (tenativeDistanceToNeighbor >= neighbor.distanceFromStart) { // 4 >= 2
                    continue;
                }
                // Node(id, row, col, value, distanceFromStart, estimatedDistanceToEnd, comeFrom)
                // ("1-4", 1, 4, 0, 4, 8, "0-4")

                neighbor.cameFrom = currentMinDistanceNode;
                neighbor.distanceFromStart = tenativeDistanceToNeighbor;
                neighbor.estimatedDistanceToEnd = tenativeDistanceToNeighbor
                        + calculateManhattanDistance(neighbor, endNode); // f  4 + rec((1,4,0), (4,3,0)) 3 + 1 = 4

                if (!nodesToVisit.containsNode(neighbor)) {
                    nodesToVisit.insert(neighbor);
                } else {
                    nodesToVisit.update(neighbor);
                }
            }
        }
        return reconstructPath(endNode);
    }

    private int[][] reconstructPath(Node endNode) {
        if (endNode.cameFrom == null) {
            return new int[][] {};
        }

        Node currentNode = endNode;
        List<List<Integer>> path = new ArrayList<>();

        while (currentNode != null) {
            List<Integer> step = new ArrayList<>();
            step.add(currentNode.row);
            step.add(currentNode.col);
            path.add(step);
            currentNode = currentNode.cameFrom;
        }

        int[][] result = new int[path.size()][2];
        int counter = path.size() - 1;

        for (int i = 0; i < path.size(); i++) {
            List<Integer> element = path.get(counter);
            result[i][0] = element.get(0);
            result[i][1] = element.get(1);
            counter--;
        }

        return result;
    }

    // nodes =
    // [                                        *
    //  [(0,0,0), (0,1,0), (0,2,0), (0,3,0), (0,4,0)], *
    //  [(1,0,0), (1,1,1), (1,2,1), (1,3,1), (1,4,0)],
    //  [(2,0,0), (2,1,0), (2,2,0), (2,3,0), (2,4,0)],
    //  [(3,0,1), (3,1,0), (3,2,1), (3,3,1), (3,4,1)],
    //  [(4,0,0), (4,1,0), (4,2,0), (4,3,0), (4,4,0)]
    // ]

    // rec(("0-4", 0, 4, 0, 3, 8, "0-3"), [[]])
    private List<Node> getNeighboringNodes(Node node, List<List<Node>> nodes) {
        List<Node> neighbors = new ArrayList<>(); // [(1,4,0), (0,3,0)]

        int numRow = nodes.size(); // 5
        int numCols = nodes.get(0).size(); // 5

        int row = node.row; // 0
        int col = node.col; // 1

        if (row < numRow - 1) { // down
            neighbors.add(nodes.get(row + 1).get(col));
        }

        if (row > 0) { // up
            neighbors.add(nodes.get(row - 1).get(col));
        }

        if (col < numCols - 1) { // right
            neighbors.add(nodes.get(row).get(col + 1));
        }

        if (col > 0) { // left
            neighbors.add(nodes.get(row).get(col - 1));
        }

        return neighbors;
    }

    // rec((0,2,0), (4,3,0))
    private int calculateManhattanDistance(Node currentNode, Node endNode) {
        int currentRow = currentNode.row; // 0
        int currentCol = currentNode.col; // 2
        int endRow = endNode.row; // 4
        int endCol = endNode.col; // 3
        // abs(0 - 4) + abs(1 - 3) = 4 + 1 = 5
        return Math.abs(currentRow - endRow) + Math.abs(currentCol - endCol);
    }

//    graph =
//     j
//    [0, 0, 0, 0, 0],
//    [0, 1, 1, 1, 0],
//    [0, 0, 0, 0, 0],
//    [1, 0, 1, 1, 1],  i
//    [0, 0, 0, 0, 0]
    private List<List<Node>> initializeNodes(int[][] graph) {
        List<List<Node>> nodes = new ArrayList<>();
        for (int i = 0; i < graph.length; i++) {
            int[] row = graph[i]; // [0, 1, 1, 1, 0]
            nodes.add(new ArrayList<>());
            for (int j = 0; j < row.length; j++) {
                int value = row[j]; // 0
                nodes.get(i).add(new Node(i, j, value));
            }
        }
        return nodes;
        // [
        //  [(0,0,0), (0,1,0), (0,2,0), (0,3,0), (0,4,0)],
        //  [(1,0,0), (1,1,1), (1,2,1), (1,3,1), (1,4,0)],
        //  [(2,0,0), (2,1,0), (2,2,0), (2,3,0), (2,4,0)],
        //  [(3,0,1), (3,1,0), (3,2,1), (3,3,1), (3,4,1)],
        //  [(4,0,0), (4,1,0), (4,2,0), (4,3,0), (4,4,0)]
        // ]
    }

    static class Node implements Comparable<Node> {
        String id;
        int row;
        int col;
        int value;
        int distanceFromStart;
        int estimatedDistanceToEnd;
        Node cameFrom;

        public Node(int row, int col, int value) {
            this.row = row;
            this.col = col;
            this.value = value;
            this.id = row + "-" + col;
            this.distanceFromStart = 99999; // g
            this.estimatedDistanceToEnd = 99999; // f
            this.cameFrom = null;
        }

        @Override
        public int compareTo(Node o) {
            return estimatedDistanceToEnd - o.estimatedDistanceToEnd;
        }
    }

    static class MinHeap {
        List<Node> heap = new ArrayList<Node>();
        //
        Map<String, Integer> nodePositionsInHeap = new HashMap<>();

        public MinHeap(List<Node> array) {
            for (int i = 0; i < array.size(); i++) {
                nodePositionsInHeap.put(array.get(i).id, i);
            }
            heap = buildHeap(array);
        }

        public boolean isEmpty() {
            return heap.size() == 0;
        }

        // O(n) time (when run in siftDown) | O(1) space
        public List<Node> buildHeap(List<Node> array) {
            // Write your code here.
            int firstParentIdx = (array.size() - 2) / 2;
            for (int currentIdx = firstParentIdx; currentIdx >= 0; currentIdx--) {
                siftDown(currentIdx, array.size() - 1, array);
            }
            return array;
        }

        // O(log(n)) time | O(1) space
        public void siftDown(int currentIdx, int endIdx, List<Node> heap) {
            // Write your code here.
            int childOneIdx = currentIdx * 2 + 1;
            int childTwoIdx;
            int idxToSwap;
            while (childOneIdx <= endIdx) {
                if (currentIdx * 2 + 2 <= endIdx) {
                    childTwoIdx = currentIdx * 2 + 2;
                } else {
                    childTwoIdx = -1;
                }
                if (childTwoIdx != -1 && heap.get(childTwoIdx).estimatedDistanceToEnd
                        < heap.get(childOneIdx).estimatedDistanceToEnd) {
                    idxToSwap = childTwoIdx;
                } else {
                    idxToSwap = childOneIdx;
                }
                if (heap.get(idxToSwap).estimatedDistanceToEnd < heap.get(currentIdx).estimatedDistanceToEnd) {
                    swap(currentIdx, idxToSwap, heap);
                    currentIdx = idxToSwap;
                    childOneIdx = currentIdx * 2 + 1;
                } else {
                    // node in correct position
                    break;
                }
            }
        }

        // O(log(n)) time | O(1) space
        public void siftUp(int currentIdx, List<Node> heap) {
            // Write your code here.
            int parentIdx = (currentIdx - 1) / 2;
            while (currentIdx > 0 && heap.get(currentIdx).estimatedDistanceToEnd
                    < heap.get(parentIdx).estimatedDistanceToEnd) {
                swap(currentIdx, parentIdx, heap);
                currentIdx = parentIdx;
                parentIdx = (currentIdx - 1) / 2;
            }
        }

        public Node peek() {
            // Write your code here.
            return heap.get(0);
        }

        public Node remove() {
            // Write your code here.
            swap(0, heap.size() - 1, heap);
            Node node = heap.remove(heap.size() - 1);
            nodePositionsInHeap.remove(node.id);
            siftDown(0, heap.size() - 1, heap);
            return node;
        }

        public void insert(Node node) {
            // Write your code here.
            heap.add(node);
            nodePositionsInHeap.put(node.id, heap.size() - 1);
            siftUp(heap.size() - 1, heap);
        }

        private void swap(int i, int j, List<Node> heap) {
            Node temp = heap.get(i);
            nodePositionsInHeap.put(heap.get(i).id, j);
            nodePositionsInHeap.put(heap.get(j).id, i);
            heap.set(i, heap.get(j));
            heap.set(j, temp);
            System.out.println();
        }

        public boolean containsNode(Node node) {
            return nodePositionsInHeap.containsKey(node.id);
        }

        public void update(Node node) {
            siftUp(nodePositionsInHeap.get(node.id), heap);
        }
    }

}
