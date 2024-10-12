package november_2023;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopologicalSort {

    public static void main(String[] args) {
        List<Integer> jobs = new ArrayList<>();
        List<Integer[]> deps = new ArrayList<>();
        jobs.add(1);
        jobs.add(2);
        jobs.add(3);
        jobs.add(4);
        deps.add(new Integer[]{1, 2});
        deps.add(new Integer[]{1, 3});
        deps.add(new Integer[]{3, 2});
        deps.add(new Integer[]{4, 2});
        deps.add(new Integer[]{4, 3});

        topologicalSort(jobs, deps);
    }

    // O(v + e) time | O(v + e) space
    public static List<Integer> topologicalSort(
            List<Integer> jobs, List<Integer[]> deps
    ) {
        // Write your code here.
        Map<Integer, Node> graphMap = new HashMap<>();
        for (Integer job : jobs) {
            graphMap.put(job, new Node(job));
        }
        for (Integer[] dep : deps) {
            Integer source = dep[0];
            Integer destination = dep[1];
            Node sourceNode = graphMap.get(source);
            Node destinationNode = graphMap.get(destination);
            sourceNode.addNeighbors(destinationNode);
            destinationNode.degree++;
        }
        List<Node> zeroDegreeNode = new ArrayList<>();

        for (Map.Entry<Integer, Node> element : graphMap.entrySet()) {
            Node currentNode = element.getValue();
            if (currentNode.degree == 0) {
                zeroDegreeNode.add(currentNode);
            }
        }
        List<Integer> result = new ArrayList<>();
        while (!zeroDegreeNode.isEmpty()) {
            Node current = zeroDegreeNode.remove(0);
            result.add(current.id);
            List<Node> neighbors = current.neighbors;
            for (Node neighbor : neighbors) {
                neighbor.degree--;
                if (neighbor.degree == 0) {
                    zeroDegreeNode.add(neighbor);
                }
            }
        }
        if (result.size() == jobs.size()) {
            return result;
        }
        return new ArrayList<>();
    }

    static class Node {
        int id;
        int degree;
        List<Node> neighbors;

        public Node(int id) {
            this.id = id;
            this.neighbors = new ArrayList<>();
        }

        public void addNeighbors(Node n) {
            this.neighbors.add(n);
        }
    }


}
