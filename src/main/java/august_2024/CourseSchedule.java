package august_2024;

import java.util.*;

public class CourseSchedule {

    public static void main(String[] args) {
        int[][] prerequisites = {
                {2, 1},
                {1, 3},
                {3, 2},
                {4, 2},
                {4, 3}
        };
        int n = 4;

        boolean result = courseSchedule(prerequisites, n);
        System.out.println(result);

    }

    public static boolean courseSchedule(int[][] prerequisites, int n) {
        Map<Integer, Node> graph = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            graph.put(i, new Node(i));
        }

        for (int[] pre : prerequisites) {
            int source = pre[0];
            int destination = pre[1];
            Node sourceNode = graph.get(source);
            Node destinationNode = graph.get(destination);

            sourceNode.addNeighbor(destinationNode);
        }

        Set<Integer> visited = new HashSet<>();
        Set<Integer> visiting = new HashSet<>();

        for (int i = 1; i <= n; i++) {
            Node currNode = graph.get(i);
            if (visited.contains(currNode.value)) {
                continue;
            }
            boolean checkCycle = checkCycle(currNode, visited, visiting);
            if (checkCycle) {
                return false;
            }
        }

        return true;
    }

    private static boolean checkCycle(Node node, Set<Integer> visited, Set<Integer> visiting) {
        if (visited.contains(node.value)) {
            return false; // no cycle
        }
        if (visiting.contains(node.value)) {
            return true; // cycle detected
        }
        visiting.add(node.value);

        List<Node> neighbors = node.neighbors;
        boolean ret = false;
        for (Node neighbor : neighbors) {
            ret = checkCycle(neighbor, visited, visiting);
            if (ret) {
                break;
            }
        }

        visiting.remove(node.value);
        visited.add(node.value);
        return ret; // no cycle
    }


    static class Node {
        int value;
        List<Node> neighbors;

        public Node(int value) {
            this.value = value;
            this.neighbors = new ArrayList<>();
        }

        public void addNeighbor(Node node) {
            this.neighbors.add(node);
        }
    }
}
