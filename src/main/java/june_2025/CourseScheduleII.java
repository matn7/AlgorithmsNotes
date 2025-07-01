package june_2025;

import java.util.*;

public class CourseScheduleII {

    public static void main(String[] args) {
//        Input: numCourses = 4, prerequisites = [[1,0],[2,0],[3,1],[3,2]]
//        Output: [0,2,1,3]
        int numCourses = 4;
        int[][] prerequisites = {{1,0}, {2,0}, {3,1}, {3,2}};
        CourseScheduleII courseScheduleII = new CourseScheduleII();
        int[] result = courseScheduleII.findOrder(numCourses, prerequisites);
        System.out.println(result);
    }

    // O(V + E) time | O(V + E) space
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, Node> adj = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            adj.put(i, new Node(i));
        }
        for (int[] pre : prerequisites) {
            int s = pre[1];
            int d = pre[0];
            Node source = adj.get(s);
            Node destination = adj.get(d);
            source.neighbors.add(destination);
            destination.deg++;
        }
        List<Node> zeroDeg = new ArrayList<>();
        for (Map.Entry<Integer, Node> elem : adj.entrySet()) {
            if (elem.getValue().deg == 0) {
                zeroDeg.add(elem.getValue());
            }
        }
        if (zeroDeg.isEmpty()) {
            return new int[] {};
        }
        List<Integer> result = new ArrayList<>();

        while (!zeroDeg.isEmpty()) {
            Node removed = zeroDeg.remove(0);
            result.add(removed.id);
            List<Node> neighbors = removed.neighbors;
            for (Node neighbor : neighbors) {
                neighbor.deg--;
                if (neighbor.deg == 0) {
                    zeroDeg.add(neighbor);
                }
            }
        }
        if (result.size() < numCourses) {
            return new int[] {};
        }
        int[] res = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            res[i] = result.get(i);
        }
        return res;
    }

    static class Node {
        int id;
        int deg;
        List<Node> neighbors;

        public Node(int id) {
            this.id = id;
            this.deg = 0;
            this.neighbors = new ArrayList<>();
        }
    }

}
