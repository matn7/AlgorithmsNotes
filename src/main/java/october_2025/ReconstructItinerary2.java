package october_2025;

import java.util.*;

public class ReconstructItinerary2 {

    // O(e log(e)) time | O(e) space
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> adj = new HashMap<>();
        for (List<String> ticket : tickets) {
            String src = ticket.get(0);
            String dst = ticket.get(1);
            adj.computeIfAbsent(src, k -> new PriorityQueue<>()).add(dst);
        }
        List<String> result = new ArrayList<>();
        dfs(adj, "JFK", result);
        Collections.reverse(result);
        return result;
    }

    private void dfs(Map<String, PriorityQueue<String>> adj, String node, List<String> result) {
        PriorityQueue<String> queue = adj.get(node);
        while (queue != null && !queue.isEmpty()) {
            String dst = queue.poll();
            dfs(adj, dst, result);
        }
        result.add(node);
    }
}
