package december_2024;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CourseScheduleII {

    public static void main(String[] args) {
        int numCourses = 4;
        // [[1,0],[2,0],[3,1],[3,2]]
        int[][] prerequisites = {{1, 0}, {2, 0}, {3, 1}, {3, 2}};

        CourseScheduleII courseScheduleII = new CourseScheduleII();
        int[] order = courseScheduleII.findOrder(4, prerequisites);
        System.out.println(order);
    }

    // O(e + v) time
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, Node> graph = createGraph(numCourses, prerequisites);
        return findOrderHelper(numCourses, graph);
    }

    private int[] findOrderHelper(int numCourses, Map<Integer, Node> graph) {
        List<Integer> result = new ArrayList<>();

        List<Node> zeroDegList = new ArrayList<>();
        for (int c = 0; c < numCourses; c++) {
            Node node = graph.get(c);
            if (node.degree == 0) {
                zeroDegList.add(node);
            }
        }

        while (!zeroDegList.isEmpty()) {
            Node current = zeroDegList.remove(0);
            result.add(current.id);
            List<Node> neighbors = current.neighbors;
            for (Node neighbor : neighbors) {
                neighbor.degree--;
                if (neighbor.degree == 0) {
                    zeroDegList.add(neighbor);
                }
            }
        }

        int[] res = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            res[i] = result.get(i);
        }
        return res.length == numCourses ? res : new int[] {};
    }

    private Map<Integer, Node> createGraph(int numCourses, int[][] prerequisites) {
        Map<Integer, Node> graph = new HashMap<>();
        for (int c = 0; c < numCourses; c++) {
            graph.put(c, new Node(c));
        }
        for (int[] p : prerequisites) {
            int source = p[1];
            int destination = p[0];
            Node sourceNode = graph.get(source);
            Node destNode = graph.get(destination);
            sourceNode.neighbors.add(destNode);
            destNode.degree++;
        }
        return graph;
    }

    static class Node {
        int id;
        int degree;
        List<Node> neighbors;

        public Node(int id) {
            this.id = id;
            this.degree = 0;
            this.neighbors = new ArrayList<>();
        }
    }
}
