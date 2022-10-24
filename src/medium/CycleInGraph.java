package medium;

public class CycleInGraph {

    // Also check topological sort. If no possible it means there is cycle in Graph.
    public static void main(String[] args) {
        int[][] edges = {
                {1, 3},     // vertex 0
                {2, 3, 4},  // vertex 1
                {0},        // vertex 2
                {},         // vertex 3
                {2, 5},     // vertex 4
                {}          // vertex 5
        };

        CycleInGraph cycleInGraph = new CycleInGraph();
        cycleInGraph.cycleInGraph(edges);
    }

//    {1, 3},     // vertex 0
//    {2, 3, 4},  // vertex 1
//    {5},        // vertex 2
//    {},         // vertex 3
//    {2, 5},     // vertex 4
//    {}          // vertex 5

    int WHITE = 0;
    int GREY = 1;
    int BLACK = 2;

    // O(v + e) time | O(v) space
    public boolean cycleInGraph(int[][] edges) {
        int numberOfNodes = edges.length; // 6
        int[] colors = new int[numberOfNodes];
        // colors = [0, 0, 0, 0, 0, 0]

        for (int node = 0; node < numberOfNodes; node++) {
            if (colors[node] != WHITE) {
                continue;
            }

            boolean containsCycle = traverseAndColorNodes(node, edges, colors);
            if (containsCycle) {
                return true;
            }
        }
        return false; // false
    }
//    {1, 3},     // vertex 0
//    {2, 3, 4},  // vertex 1
//    {5},        // vertex 2
//    {},         // vertex 3
//    {2, 5},     // vertex 4
//    {}          // vertex 5


    // rec(4, [][], [1, 1, 2, 2, 2, 2]) => false
    // rec(3, [][], [1, 1, 2, 2, 0, 2]) => false
    // rec(5, [][], [1, 1, 1, 0, 0, 2]) => false
    // rec(2, [][], [1, 1, 2, 0, 0, 0]) => false
    // rec(1, [][], [1, 1, 2, 2, 2, 2]) => false
    // rec(0, [][], [1, 0, 0, 0, 0, 0])
    private boolean traverseAndColorNodes(int node, int[][] edges, int[] colors) {
        colors[node] = GREY;

        int[] neighbors = edges[node]; // [2,5]
        for (int neighbor : neighbors) { // 5
            int neighborColor = colors[neighbor]; // 2

            if (neighborColor == GREY) { // 0 == 1
                return true; // true
            }

            if (neighborColor != WHITE) {
                continue;
            }

            boolean containsCycle = traverseAndColorNodes(neighbor, edges, colors);
            if (containsCycle) {
                return true;
            }
        }
        colors[node] = BLACK;
        return false;
    }

//    {1, 3},     // vertex 0
//    {2, 3, 4},  // vertex 1
//    {0},        // vertex 2
//    {},         // vertex 3
//    {2, 5},     // vertex 4
//    {}          // vertex 5

    // O(v + e) time | O(v) space
    public boolean cycleInGraph2(int[][] edges) {
        // Write your code here.
        int numberOfNodes = edges.length; // 6
        boolean[] visited = new boolean[numberOfNodes];
        // visited = [false, false, false, false, false, false]
        boolean[] currentlyInStack = new boolean[numberOfNodes];
        // currentlyInStack = [false, false, false, false, false, false]
        for (int node = 0; node < numberOfNodes; node++) {
            if (visited[node]) {
                continue;
            }

            // if not connected graph make sure we run depth first
            // rec([][], 0, [f, f, f, f, f, f], [f, f, f, f, f, f])
            boolean containsCycle = isNodeInCycle(edges, node, visited, currentlyInStack);
            if (containsCycle) {
                return true;
            }
        }

        return false;
    }

    // rec([][], 2, [t, t, t, f, f, f], [t, f, f, f, f, f]) => true 0 currently in stack
    // rec([][], 1, [t, t, f, f, f, f], [t, f, f, f, f, f])
    // rec([][], 0, [t, f, f, f, f, f], [t, f, f, f, f, f])
    private boolean isNodeInCycle(int[][] edges, int node, boolean[] visited, boolean[] currentlyInStack) {
        visited[node] = true;
        currentlyInStack[node] = true;

        int[] neighbors = edges[node]; // [1,3] | [2, 3, 4] | [0]
        for (int neighbor : neighbors) {
            if (!visited[neighbor]) {
                boolean containsCycle = isNodeInCycle(edges, neighbor, visited, currentlyInStack);
                if (containsCycle) {
                    return true;
                }
            } else if (currentlyInStack[neighbor]) {
                return true; // true
            }
        }
        currentlyInStack[node] = false;
        return false;
    }

}
