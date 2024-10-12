package udemy.graph;

import udemy.stackandqueue.Queue;

import java.util.List;

public class GraphTraversal {

    private static int N;

    public static void traverse(Graph graph, int[] visited) throws Queue.QueueUnderflowException, Queue.QueueOverflowException {
        // this for-loop ensures that all nodes are covered even for an unconnected graph
        for (int i = 0; i < N; i++) {
            depthFirstTraversal(graph, visited, i);
        }

        for (int i = 0; i < N; i++) {
            breadthFirstTraversal(graph, visited, i);
        }
    }

    public static void depthFirstTraversal(Graph graph, int[] visited, int currentVertex) {
        if (visited[currentVertex] == 1) {
            return;
        }
        visited[currentVertex] = 1;

        List<Integer> list = graph.getAdjacentVertices(currentVertex);
        for (int vertex : list) {
            depthFirstTraversal(graph, visited, vertex);
        }

        System.out.print(currentVertex + "->");
    }

    public static void breadthFirstTraversal(Graph graph, int[] visited, int currentVertex) throws Queue.QueueOverflowException, Queue.QueueUnderflowException {
        Queue<Integer> queue = new Queue<>(Integer.class);
        queue.enqueue(currentVertex);

        while (!queue.isEmpty()) {
            int vertex = queue.dequeue();

            if (visited[vertex] == 1) {
                continue;
            }

            System.out.print(vertex + "->");
            visited[vertex] = 1;

            List<Integer> list = graph.getAdjacentVertices(vertex);
            for (int v : list) {
                if (visited[v] != 1) {
                    queue.enqueue(v);
                }
            }
        }
    }

}
