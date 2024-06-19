package june_2024;

import java.util.*;

public class CourseScheduleTopologicalSort {

    public static void main(String[] args) {
//        int n = 6;
//        int[][] prereq = {{1, 0}, {2, 1}, {2, 5}, {0, 3}, {4, 3}, {3, 5}, {4, 5}};

        int n = 7;
        int[][] prereq = {{0,3}, {1,0}, {2,1}, {4,5}, {6,4}, {5,6}};

        boolean result = courseScheduling(n, prereq);
        System.out.println(result);
    }

    // O(p + n^2) time | O(n^2) space
    public static boolean courseScheduling(int n, int[][] prereq) {
        Map<Integer, Node> graph = createGraph(n, prereq);
        List<Node> zeroDegNodes = getStartNodes(graph);
        if (zeroDegNodes.isEmpty()) {
            return false;
        }
        List<Node> order = new ArrayList<>();

        while (!zeroDegNodes.isEmpty()) {
            Node currentNode = zeroDegNodes.remove(0);
            if (order.contains(currentNode)) {
                return false;
            }
            order.add(currentNode);
            List<Node> neighbors = currentNode.neighbors;
            for (Node neighbor : neighbors) {
                neighbor.deg--;
                if (neighbor.deg == 0) {
                    zeroDegNodes.add(neighbor);
                }
            }
        }

        return order.size() == n;
    }

    private static List<Node> getStartNodes(Map<Integer, Node> graph) {
        List<Node> nodes = new ArrayList<>();
        for (Map.Entry<Integer, Node> element : graph.entrySet()) {
            Node value = element.getValue();
            if (value.deg == 0) {
                nodes.add(value);
            }
        }
        return nodes;
    }

    private static Map<Integer, Node> createGraph(int n, int[][] prereq) {
        Map<Integer, Node> graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            graph.put(i, new Node(i));
        }

        for (int[] pre : prereq) {
            int source = pre[1];
            int dest = pre[0];
            Node sourceNode = graph.get(source);
            Node destNode = graph.get(dest);
            sourceNode.addNeighbors(destNode);
            destNode.deg++;
        }
        return graph;
    }

    static class Node {
        int value;
        int deg;
        List<Node> neighbors;

        public Node(int value) {
            this.value = value;
            this.deg = 0;
            this.neighbors = new ArrayList<>();
        }

        void addNeighbors(Node node) {
            this.neighbors.add(node);
        }
    }

}
