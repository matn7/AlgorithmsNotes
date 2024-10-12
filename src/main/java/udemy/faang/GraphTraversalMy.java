package udemy.faang;

import java.util.*;

public class GraphTraversalMy {

    public static void main(String[] args) {
        int[][] graph = {
                {1, 3},
                {0},
                {3, 8},
                {0, 4, 5, 2},
                {3, 6},
                {3},
                {4, 7},
                {6},
                {2},
                {10},
                {9}
        };

        GraphTraversalMy graphTraversal = new GraphTraversalMy();
        graphTraversal.bfsTraversal(graph);
        graphTraversal.dfsTraversal(graph);
    }

    public List<Integer> dfsTraversal(int[][] graph) {
        List<Integer> result = new ArrayList<>();
        Map<Integer, Node>  graphMap = createGraphMap(graph);

        for (int i = 0; i < graph.length; i++) {
            Node currentNode = graphMap.get(i);
            if (!currentNode.visited) {
                dfs(currentNode, result);
            }
        }
        return result;
    }

    private void dfs(Node currentNode, List<Integer> result) {
        result.add(currentNode.value);
        currentNode.visited = true;
        List<Node> neighbors = currentNode.neighbors;
        for (Node neighbor : neighbors) {
            if (neighbor.visited) {
                continue;
            }
            dfs(neighbor, result);
        }
    }


    public List<Integer> bfsTraversal(int[][] graph) {
        List<Integer> result = new ArrayList<>();
        Map<Integer, Node>  graphMap = createGraphMap(graph);

        for (int i = 0; i < graph.length; i++) {
            Node currentNode = graphMap.get(i);
            if (!currentNode.visited) {
                bfs(currentNode, result);
            }
        }
        return result;
    }

    private void bfs(Node currentNode, List<Integer> result) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(currentNode);
        while (!queue.isEmpty()) {
            Node curr = queue.poll();
            if (curr.visited) {
                continue;
            }
            curr.visited = true;
            result.add(curr.value);
            List<Node> neighbors = curr.neighbors;
            for (Node neighbor : neighbors) {
                if (neighbor.visited) {
                    continue;
                }
                queue.add(neighbor);
            }
        }
    }

    private Map<Integer, Node>  createGraphMap(int[][] graph) {
        Map<Integer, Node> graphMap = new HashMap<>();
        for (int i = 0; i < graph.length; i++) {
            graphMap.put(i, new Node(i));
        }
        for (int i = 0; i < graph.length; i++) {
            int[] curr = graph[i];
            for (int node : curr) {
                graphMap.get(i).addNeighbor(graphMap.get(node));
            }
        }
        return graphMap;
    }

    class Node {
        int value;
        boolean visited;
        List<Node> neighbors;

        public Node(int value) {
            this.value = value;
            this.visited = false;
            this.neighbors = new ArrayList<>();
        }

        public void addNeighbor(Node node) {
            this.neighbors.add(node);
        }
    }

}
