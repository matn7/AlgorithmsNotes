package problems.medium;

import java.util.Arrays;
import java.util.Stack;

public class TwoColorable {

    public static void main(String[] args) {
//        int[][] edges = {{1,3}, {0,2}, {1,3}, {0,2}};
        int[][] edges = {{1},{0}};
        TwoColorable twoColorable = new TwoColorable();
        boolean result = twoColorable.twoColorable(edges);
        System.out.println(result);
    }

    // O(v + e) time | O(v) space
    public boolean twoColorable(int[][] edges) {
        // Write your code here.
        String[] colors = new String[edges.length];
        Arrays.fill(colors, "");

        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        String[] colorsStr = {"GREEN", "BLUE"};

        // [GREEN, null, null, null]
        // [ 0 ]
        // {1,3}, {0,2}, {1,3}, {0,2}
        while (!stack.isEmpty()) {
            Integer curr = stack.pop(); // 0
            int[] e = edges[curr]; // {1, 3}
            if (colors[curr] == null) {
                colors[curr] = colorsStr[0];
            }
            int code = colors[curr].equals("GREEN") ? 0 : 1; // 0
            for (int i = 0; i < edges[curr].length; i++) {  // 0
                if (colors[e[i]].equals(colorsStr[code])) {
                    return false;
                }
                if (colors[edges[curr][i]].equals("")) {
                    stack.push(edges[curr][i]);
                    colors[edges[curr][i]] = code == 0 ? "BLUE" : "GREEN";
                }
            }
        }

        return true;
    }

    // O(v + e) time | O(v) space
    public boolean twoColorable2(int[][] edges) {
        boolean[] colors = new boolean[edges.length];
        colors[0] = true;
        Stack<Integer> stack = new Stack<>();
        stack.push(0);

        while (!stack.isEmpty()) {
            Integer node = stack.pop();
            int[] edge = edges[node];
            for (int connection : edge) {
                if (!colors[connection]) {
                    colors[connection] = !colors[node];
                    stack.push(connection);
                } else if (colors[connection] == colors[node]) {
                    return false;
                }
            }
        }
        return true;
    }
    
}
