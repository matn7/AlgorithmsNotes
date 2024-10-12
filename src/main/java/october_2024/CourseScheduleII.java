package october_2024;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CourseScheduleII {

    public static void main(String[] args) {
        int[][] prerequisites = {{1, 0}, {2, 0}, {3, 1}, {3, 2}};
        int numCourses = 4;

        CourseScheduleII courseSchedule = new CourseScheduleII();
        int[] order = courseSchedule.findOrder(numCourses, prerequisites);
        System.out.println(order);
    }

    // O(v + e) time | O(v + e) space
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, Node> graph = prepareGraph(numCourses, prerequisites);

        List<Integer> resultArr = new ArrayList<>();
        List<Node> zeroDegNode = new ArrayList<>();
        for (Map.Entry<Integer, Node> element : graph.entrySet()) {
            if (element.getValue().degree == 0) {
                zeroDegNode.add(element.getValue());
            }
        }
        if (zeroDegNode.isEmpty()) { // no topological sort possible
            return new int[] {};
        }

        while (!zeroDegNode.isEmpty()) {
            Node removed = zeroDegNode.remove(0);
            resultArr.add(removed.val);
            List<Node> neighbors = removed.neighbors;
            for (Node neighbor : neighbors) {
                neighbor.degree--;
                if (neighbor.degree == 0) {
                    zeroDegNode.add(neighbor);
                }
            }
        }
        if (resultArr.size() < numCourses) {
            return new int[] {};
        }
        int[] result = new int[resultArr.size()];
        int idx = 0;
        for (Integer elem : resultArr) {
            result[idx] = elem;
            idx++;
        }
        return result;
    }

    private Map<Integer, Node> prepareGraph(int numCourses, int[][] prerequisites) {
        Map<Integer, Node> graph = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            graph.put(i, new Node(i));
        }

        for (int[] pre : prerequisites) {
            int sourceId = pre[1];
            int destinationId = pre[0];
            Node sourceNode = graph.get(sourceId);
            Node destinationNode = graph.get(destinationId);
            sourceNode.addNeighbor(destinationNode);
            destinationNode.degree++;
        }
        return graph;
    }

    static class Node {
        int val;
        List<Node> neighbors;
        int degree;

        public Node(int val) {
            this.val = val;
            this.neighbors = new ArrayList<>();
        }

        public void addNeighbor(Node n) {
            this.neighbors.add(n);
        }
    }
}
