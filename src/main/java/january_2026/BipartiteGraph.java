package january_2026;

public class BipartiteGraph {

    public static void main(String[] args) {
        int[][] graph = {{1,3},{0,2},{1,3},{0,2}};

        BipartiteGraph bipartiteGraph = new BipartiteGraph();
        boolean result = bipartiteGraph.isBipartite(graph);
        System.out.println(result);
    }

    // O(n + e) time | O(n) space
    public boolean isBipartite(int[][] graph) {
        int[] colors = new int[graph.length];

        for (int i = 0; i < graph.length; i++) {
            if (colors[i] == 0 && !dfs(i, 1, graph, colors)) {
                return false;
            }
        }
        return true;
    }

    private boolean dfs(int node, int color, int[][] graph, int[] colors) {
        colors[node] = color;

        for (int nei : graph[node]) {
            if (colors[nei] == color) {
                return false;
            }

            if (colors[nei] == 0 && !dfs(nei, -1 * color, graph, colors)) {
                return false;
            }
        }
        return true;
    }


}
