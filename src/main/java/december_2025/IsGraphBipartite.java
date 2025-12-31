package december_2025;

public class IsGraphBipartite {

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
        for (int neighbor : graph[node]) {
            if (colors[neighbor] == color) {
                return false;
            }

            if (colors[neighbor] == 0 && !dfs(neighbor, -1 * color, graph, colors)) {
                return false;
            }
        }
        return true;
    }

}
