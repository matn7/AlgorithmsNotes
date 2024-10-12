package june_2024;

import java.util.*;

public class CourseScheduleBfs {

    public static void main(String[] args) {
//        int n = 6;
//        int[][] prereq = {{1, 0}, {2, 1}, {2, 5}, {0, 3}, {4, 3}, {3, 5}, {4, 5}};

        int n = 7;
        int[][] prereq = {{0,3}, {1,0}, {2,1}, {4,5}, {6,4}, {5,6}};


        boolean result = courseScheduling(n, prereq);
        System.out.println(result);
    }

    // O(p + n^3) time | O(n^2) space
    public static boolean courseScheduling(int n, int[][] prereq) {
        Map<Integer, Node> graph = createGraph(n, prereq);

        Set<Node> visited = new HashSet<>();
        for (Map.Entry<Integer, Node> element : graph.entrySet()) {
            Node vertex = element.getValue();
            List<Node> neighbors = vertex.neighbors;
            Queue<Node> queue = new LinkedList<>(neighbors);

            while (!queue.isEmpty()) {
                Node current = queue.poll();
                visited.add(current);
                if (current == vertex) {
                    return false;
                }
                List<Node> neighbors2 = current.neighbors;
                for (Node neighbor : neighbors2) {
                    if (!visited.contains(neighbor)) {
                        queue.add(neighbor);
                    }
                }
            }

        }

        return true;
    }

    private static Map<Integer, Node> createGraph(int n, int[][] prereq) {
        Map<Integer, Node> graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            graph.put(i, new Node(i));
        }

        for (int[] pre : prereq) {
            int source = pre[1];
            int dest = pre[0];
            Node sourceNode = graph.get(source);
            Node destNode = graph.get(dest);
            sourceNode.addNeighbors(destNode);
            destNode.deg++;
        }
        return graph;
    }

    static class Node {
        int value;
        int deg;
        List<Node> neighbors;

        public Node(int value) {
            this.value = value;
            this.deg = 0;
            this.neighbors = new ArrayList<>();
        }

        void addNeighbors(Node node) {
            this.neighbors.add(node);
        }
    }

}
