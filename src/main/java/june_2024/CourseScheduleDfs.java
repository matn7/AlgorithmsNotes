package june_2024;

import java.util.*;

public class CourseScheduleDfs {

    public static void main(String[] args) {
        int n = 6;
        int[][] prereq = {{1, 0}, {2, 1}, {2, 5}, {0, 3}, {4, 3}, {3, 5}, {4, 5}};

//        int n = 7;
//        int[][] prereq = {{0,3}, {1,0}, {2,1}, {4,5}, {6,4}, {5,6}};


        boolean result = courseScheduling(n, prereq);
        System.out.println(result);
    }

    // O(p + n^3) time | O(n^2) space
    public static boolean courseScheduling(int n, int[][] prereq) {
        Map<Integer, Node> graph = createGraph(n, prereq);

        Set<Node> visited = new HashSet<>();
        Set<Node> visiting = new HashSet<>();

        for (Map.Entry<Integer, Node> element : graph.entrySet()) {
            Node currNode = element.getValue();
            if (visited.contains(currNode)) {
                continue;
            }
            boolean cycle = dfs(currNode, visited, visiting);
            if (cycle) {
                return false;
            }
        }

        return true;
    }

    private static boolean dfs(Node node, Set<Node> visited, Set<Node> visiting) {
        if (visiting.contains(node)) {
            return true;
        }
        if (visited.contains(node)) {
            return false;
        }
        visiting.add(node);
        // dfs
        List<Node> neighbors = node.neighbors;
        for (Node neighbor : neighbors) {
            boolean cycle = dfs(neighbor, visited, visiting);
            if (cycle) {
                return true;
            }
        }

        visiting.remove(node);
        visited.add(node);
        return false;

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
