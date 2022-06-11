package medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CyclesInGraph2 {

    public static void main(String[] args) {
        int[][] edges = {
                {0, 1, 0, 1, 0, 0},
                {0, 0, 1, 1, 1, 0},
                {1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 1, 0, 0, 1},
                {0, 0, 0, 0, 0, 0}
        };

//        int[][] edges = {{0},
//                         {1}};

//        int[][] edges = {{0, 1, 1},
//                         {0, 0, 1},
//                         {0, 0, 0}};

        CyclesInGraph2 cyclesInGraph = new CyclesInGraph2();
        boolean result = cyclesInGraph.cycleInGraph(edges);
        System.out.println(result);
    }

    public boolean cycleInGraph(int[][] edges) {
        // Write your code here.
        if (edges.length == 0 && edges[0].length == 0) {
            return true;
        }







        int[] visited = new int[edges.length];
//        for (int i = 0; i < edges.length; i++) {
//            if (visited[i] == 0) {
//                breadthFirst(edges, 0, visited);
//            }
//        }
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < edges.length; i++) {
            if (visited[i] == 0) {
                depthFirst(edges, i, visited, result);
            }
        }

        return result.size() != 0;
    }

    public void depthFirst(int[][] edges, int node, int[] visited, List<Integer> result) {
        if (visited[node] == 1) {
            visited[node] = visited[node] + 1;
            return;
        }

        visited[node] = 1;
        System.out.println(node);

        List<Integer> adjacency = getAdjacency(edges, node);

        // check whether already visited node
        for (Integer elem : adjacency) {
            if (visited[elem] == 1) {
                result.add(elem);
                return;
            }
        }

        for (Integer element : adjacency) {
            if (visited[element] == 0) {
                depthFirst(edges, element, visited, result);
            }
        }

    }

    public void breadthFirst(int[][] edges, int node, int[] visited) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);

        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            if (visited[poll] == 1) {
                continue;
            }
            visited[poll] = 1;
            System.out.println(poll);

            List<Integer> adjacency = getAdjacency(edges, poll);
            for (Integer element : adjacency) {
                if (visited[element] == 0) {
                    queue.add(element);
                }
            }
        }
        System.out.println();
    }

    private List<Integer> getAdjacency(int[][] edges, int row) {

        List<Integer> adjacentVertices = new ArrayList<>();

        for (int col = 0; col < edges[row].length; col++) {
            if (edges[row][col] == 1) {
                adjacentVertices.add(col);
            }
        }

        return adjacentVertices;
    }

    private int getIndegree(int[][] edges, int col) {
        int indegree = 0;
        for (int row = 0; row < edges.length; row++) {
            if (edges[row][col] == 1) {
                indegree++;
            }
        }
        return indegree;
    }

    // adjacency: W -> E

    // indegree:  W -> E

    class Node {
        String value;
        List<Node> neighbors;

        public Node(String value) {
            this.value = value;
            this.neighbors = new ArrayList<>();
        }

        public void addNeighbors(Node node) {
            this.neighbors.add(node);
        }
    }
}

//  "edges": [
//          [1, 3],
//          [2, 3, 4],
//          [0],
//          [],
//          [2, 5],
//          []
//          ]