package october_2024;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CourseSchedule {

    public static void main(String[] args) {
        int[][] prerequisites = {
                {2, 0}, {1, 0}, {2, 3}, {1, 3}, {1, 2}
        };

//        int[][] prerequisites = {
//                {0, 2}, {1, 2}, {2, 0}
//        };

        CourseSchedule courseSchedule = new CourseSchedule();
        boolean result = courseSchedule.canFinish(4, prerequisites);
        System.out.println(result);
    }

    // O(v + e) time | O(v + e) space
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        Map<Integer, Node> graph = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            graph.put(i, new Node(i));
        }

        for (int[] prereq : prerequisites) {
            int sourceIndex = prereq[1];
            int destinationIndex = prereq[0];
            Node sourceNode = graph.get(sourceIndex);
            Node destinationNode = graph.get(destinationIndex);
            sourceNode.addNeighbor(destinationNode);
        }

        for (int i = 0; i < numCourses; i++) {
            Node node = graph.get(i);
            if (!node.visited) {
                boolean cycle = dfs(node);
                if (cycle) {
                    return false;
                }
            }
        }

        return true;
    }

    private boolean dfs(Node node) {
        if (node.visiting) {
            return true;
        }
        if (node.visited) {
            return false;
        }
        node.visiting = true;
        List<Node> neighbors = node.neighbor;
        boolean ret = false;
        for (Node neighbor : neighbors) {
            ret = dfs(neighbor);
            if (ret) {
                break;
            }
        }

        node.visiting = false;
        node.visited = true;
        return ret;
    }

    static class Node {
        int value;
        List<Node> neighbor;
        boolean visited;
        boolean visiting;

        public Node(int value) {
            this.value = value;
            this.neighbor = new ArrayList<>();
            this.visited = false;
            this.visiting = false;
        }

        public void addNeighbor(Node n) {
            this.neighbor.add(n);
        }
    }

}
