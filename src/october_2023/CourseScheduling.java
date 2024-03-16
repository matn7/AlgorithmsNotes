package october_2023;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CourseScheduling {

    public static void main(String[] args) {
        int[][] prereqs = {{1,2}, {1,3}, {3,2}, {4,2}, {4,3}};
        int num = 4;

        courseScheduling(prereqs, num);
    }

    // O(v+e) time | O(v) space
    public static boolean courseScheduling(int[][] prereq, int num) {
        Map<Integer, Node> graphMap = new HashMap<>();
        for (int i = 1; i < prereq.length; i++) {
            graphMap.put(i, new Node(i));
        }

        for (int i = 0; i < prereq.length; i++) {
            int[] current = prereq[i]; // [1, 2]
            int source = current[0];
            int destination = current[1];
            Node sourceNode = graphMap.get(source);
            Node destinationNode = graphMap.get(destination);
            sourceNode.addNeighbors(destinationNode);
            destinationNode.degree++;
        }

        List<Node> zeroDegreeNodes = new ArrayList<>();
        for (Map.Entry<Integer, Node> element : graphMap.entrySet()) {
            Node value = element.getValue();
            if (value.degree == 0) {
                zeroDegreeNodes.add(value);
            }
        }
        List<Integer> result = new ArrayList<>();
        while (!zeroDegreeNodes.isEmpty()) {
            Node currentNode = zeroDegreeNodes.remove(0);
            result.add(currentNode.id);
            List<Node> neighbors = currentNode.neighbors;
            for (Node neighbor : neighbors) {
                neighbor.degree--;
                if (neighbor.degree == 0) {
                    zeroDegreeNodes.add(neighbor);
                }
            }
        }
        return result.size() == num;
    }

    static class Node {
        int id;
        int degree;
        List<Node> neighbors;

        public Node(int id) {
            this.id = id;
            this.neighbors = new ArrayList<>();
        }

        public void addNeighbors(Node node) {
            this.neighbors.add(node);
        }
    }

}
