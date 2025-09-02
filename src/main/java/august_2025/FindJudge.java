package august_2025;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindJudge {

    // O(V + E) time | O(V) space
    public int findJudge(int n, int[][] trust) {
        int[] incoming = new int[n + 1];
        int[] outgoing = new int[n + 1];

        for (int[] t : trust) {
            int s = t[0];
            int d = t[1];

            incoming[d]++;
            outgoing[s]++;
        }
        int inc = n - 1;
        int out = 0;

        for (int i = 1; i <= incoming.length; i++) {
            if (incoming[i] == inc && outgoing[i] == out) {
                return i;
            }
        }
        return -1;
    }

    // O(V + E) time | O(V) space
    public int findJudge2(int n, int[][] trust) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            adj.put(i, new ArrayList<>());
        }
        int[] deg = new int[n + 1];

        for (int[] t : trust) {
            int s = t[0];
            int d = t[1];
            adj.get(s).add(d);
            deg[s]++;
        }

        for (int i = 1; i < deg.length; i++) {
            if (deg[i] == n - 1 && adj.get(i).isEmpty()) {
                return i;
            }
        }
        return -1;
    }

}
