package july_2024;

import java.util.*;

public class CourseScheduling {

    public static void main(String[] args) {
        int[][] prereqs = {
                {1, 2},
                {1, 3},
                {3, 2},
                {4, 2},
                {4, 3}
        };

        boolean result = courseScheduling(prereqs);
        System.out.println(result);
    }

    // O(e * v) time | O(v) space
    public static boolean courseScheduling(int[][] prereqs) {
        Map<Integer, Node> graph = new HashMap<>();
        for (int i = 1; i < prereqs.length; i++) {
            graph.put(i, new Node(i));
        }
        for (int[] prereq : prereqs) {
            int source = prereq[0];
            int destination = prereq[1];
            Node sourceNode = graph.get(source);
            Node destinationNode = graph.get(destination);
            sourceNode.addNeighbor(destinationNode);
            destinationNode.degree++;
        }

        List<Node> zeroDegNodes = new ArrayList<>();
        for (Map.Entry<Integer, Node> element : graph.entrySet()) {
            Node node = element.getValue();
            if (node.degree == 0) {
                zeroDegNodes.add(node);
            }
        }

        List<Integer> result = new ArrayList<>();
        while (!zeroDegNodes.isEmpty()) {
            Node node = zeroDegNodes.remove(0);
            result.add(node.value);
            List<Node> neighbors = node.neighbors;
            for (Node neighbor : neighbors) {
                neighbor.degree--;
                if (neighbor.degree == 0) {
                    zeroDegNodes.add(neighbor);
                }
            }
        }

        return result.size() == prereqs.length;
    }

    static class Node {
        int value;
        int degree;
        List<Node> neighbors;

        public Node(int value) {
            this.value = value;
            this.neighbors = new ArrayList<>();
        }

        public void addNeighbor(Node n) {
            this.neighbors.add(n);
        }
    }


}
