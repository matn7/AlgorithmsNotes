package may_2024;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TimeToInformAllEmployee {

    public static void main(String[] args) {
        int employees = 8;
        int[] managers = {2, 2, 4, 6, -1, 4, 4, 5};
        int[] informTime = {0, 0, 4, 0, 7, 3, 6, 0};

        System.out.println(timeToInformBfs(employees, managers, informTime, 4));
        System.out.println(timeToInformDfs(employees, managers, informTime, 4));
    }

    // O(n) time | O(n) space
    public static int timeToInformBfs(int employees, int[] managers, int[] informTime, int headId) {
        List<List<Integer>> adjList = createGraph(employees, managers);
        int numMinutes = 0;

        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(headId, informTime[headId]));

        while (!queue.isEmpty()) {
            Node currNode = queue.poll();
            int vertex = currNode.id;
            int time = currNode.time;
            numMinutes = Math.max(numMinutes, time);
            List<Integer> neighbors = adjList.get(vertex);
            for (Integer neighbor : neighbors) {
                queue.add(new Node(neighbor, time + informTime[neighbor]));
            }
        }

        return numMinutes;
    }

    // O(n) time | O(n) space
    public static int timeToInformDfs(int employees, int[] managers, int[] informTime, int headId) {
        List<List<Integer>> adjList = createGraph(employees, managers);
        return dfs(adjList, headId, informTime[headId], informTime);
    }

    private static int dfs(List<List<Integer>> adjList, int vertex, int time, int[] informTime) {
        List<Integer> neighbors = adjList.get(vertex);
        int maxTime = time;
        for (Integer neighbor : neighbors) {
            maxTime = Math.max(maxTime, dfs(adjList, neighbor, time + informTime[neighbor], informTime));
        }
        return maxTime;
    }

    static class Node {
        int id;
        int time;

        public Node(int id, int time) {
            this.id = id;
            this.time = time;
        }
    }

    private static List<List<Integer>> createGraph(int employees, int[] managers) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < employees; i++) {
            graph.add(new ArrayList<>());
        }
        for (int employee = 0; employee < managers.length; employee++) {
            int employeesManager = managers[employee]; // employee = 0, manager = 2
            if (employeesManager == -1) {
                continue;
            }
            graph.get(employeesManager).add(employee);
        }
        return graph;
    }

}
