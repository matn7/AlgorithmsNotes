package august_2025;

import java.util.*;

public class CourseScheduleIV {

    public static void main(String[] args) {
//        int numCourses = 3;
//        int[][] prerequisites = {{1,2},{1,0},{2,0}};
//        int[][] queries = {{1,0},{1,2}};

        int numCourses = 5;
        int[][] prerequisites = {{0,1},{1,2},{2,3},{3,4}};
        int[][] queries = {{0,4},{4,0},{1,3},{3,0}};

        CourseScheduleIV courseScheduleIV = new CourseScheduleIV();
        List<Boolean> result = courseScheduleIV.checkIfPrerequisite(numCourses, prerequisites, queries);
        System.out.println(result);
    }

    // O(V * (V + E) + m) time | O(V^2 + E + m) space
    // v - vertices, e - edges, m - num of queries
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        Map<Integer, Set<Integer>> nodePrereq = new HashMap<>();

        for (int i = 0; i < numCourses; i++) {
            adj.put(i, new ArrayList<>());
            nodePrereq.put(i, new HashSet<>());
        }
        int[] degree = new int[numCourses];

        for (int[] pre : prerequisites) {
            int s = pre[0];
            int d = pre[1];
            adj.get(s).add(d);
            degree[d]++;
            nodePrereq.get(d).add(s);
        }
        LinkedList<Integer> zeroList = new LinkedList<>();
        for (int i = 0; i < degree.length; i++) {
            if (degree[i] == 0) {
                zeroList.add(i);
            }
        }
        if (zeroList.isEmpty()) {
            return new ArrayList<>();
        }

        while (!zeroList.isEmpty()) {
            int current = zeroList.poll();
            Set<Integer> currentPre = nodePrereq.get(current);
            List<Integer> neighbors = adj.get(current);
            for (int nei : neighbors) {
                Set<Integer> neiPre = nodePrereq.get(nei);
                neiPre.addAll(currentPre);
                degree[nei]--;
                if (degree[nei] == 0) {
                    zeroList.add(nei);
                }
            }
        }

        List<Boolean> result = new ArrayList<>();
        for (int[] query : queries) {
            int s = query[0];
            int d = query[1];

            result.add(nodePrereq.get(d).contains(s));
        }
        return result;
    }

}
