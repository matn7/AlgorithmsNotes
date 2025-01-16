package december_2024;

import java.util.*;

public class CourseSchedule {

    public static void main(String[] args) {
//        int[][] prerequisites = {{1, 0}, {0, 1}};
//        int[][] prerequisites = {{1, 0}};
        int[][] prerequisites = {{0, 1}, {0, 2}, {1, 3}, {1, 4}, {3, 4}};
        int numCourses = 2;

        CourseSchedule courseSchedule = new CourseSchedule();
        boolean result = courseSchedule.canFinish(numCourses, prerequisites);
        System.out.println(result);
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, Node> graph = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            graph.put(i, new Node(i));
        }
        for (int[] p : prerequisites) {
            int source = p[1];
            int destination = p[0];
            Node sourceNode = graph.get(source);
            Node destinationNode = graph.get(destination);
            sourceNode.neighbors.add(destinationNode);
        }

        Set<Integer> visited = new HashSet<>();
        Set<Integer> visiting = new HashSet<>();

        for (int c = 0; c < numCourses; c++) {
            Node curr = graph.get(c);
            if (!visited.contains(c)) {
                boolean cycle = dfs(curr, visiting, visited);
                if (cycle) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean dfs(Node node, Set<Integer> visiting, Set<Integer> visited) {
        if (visited.contains(node.id)) {
            return false;
        }
        if (visiting.contains(node.id)) {
            return true;
        }
        visiting.add(node.id);

        List<Node> neighbors = node.neighbors;
        for (Node neighbor : neighbors) {
            boolean cycle = dfs(neighbor, visiting, visited);
            if (cycle) {
                return true;
            }
        }

        visited.remove(node.id);
        visited.add(node.id);
        return false;
    }

    static class Node {
        int id;
        List<Node> neighbors;

        public Node(int id) {
            this.id = id;
            this.neighbors = new ArrayList<>();
        }
    }

}
